import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<User> users = new ArrayList<User>();
    public static void main(String[] args) {
        User firstUser = null;
        User secondUser = null;
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine();
        while (!entry.equals("Exit")) {
            System.out.println(entry);
            if (entry.matches("user create -u (?<Username>\\S+) -p (?<Password>\\S+) (?<PasswordConfirmation>\\S+) -email (?<Email>\\S+) -n (?<Nickname>\\S+)")) {
                Matcher matcher = getCommandMatcher(entry, "user create -u (?<Username>\\S+) -p (?<Password>\\S+) (?<PasswordConfirmation>\\S+) -email (?<Email>\\S+) -n (?<Nickname>\\S+)");
                matcher.find();
                String pass = matcher.group("Password");
                if (!pass.equals("random")) {
                    signup(matcher, scanner);
                }
            }
            if (entry.matches("user create -u (?<Username>\\S+) -p random -email (?<Email>\\S+) -n (?<Nickname>\\S+)")) {
                Matcher matcher = getCommandMatcher(entry, "user create -u (?<Username>\\S+) -p random -email (?<Email>\\S+) -n (?<Nickname>\\S+)");
                matcher.find();
                randomSignup(matcher, scanner);
            }
            entry = scanner.nextLine();
        }

    }
    public static Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public static void signup(Matcher matcher, Scanner scanner) {
        String username = matcher.group("Username");
        String password = matcher.group("Password");
        String email = matcher.group("Email");
        String passwordConfirmation = matcher.group("PasswordConfirmation");
        String nickname = matcher.group("Nickname");
        if (password.equals("random")) {
            return;
        }
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || nickname.isEmpty() || passwordConfirmation.isEmpty()) {
            System.out.println("You have left a field empty!");
            return;
        }
        if (!username.matches("^[A-Za-z0-9_]+$")) {
            System.out.println("invalid username");
            return;
        }
        if (!password.equals(passwordConfirmation)) {
            System.out.println(password +  "  " + passwordConfirmation);
            System.out.println("passwords do not match");
            return;
        }
        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("an account with this username already exists");
                return;
            }
        }
        Boolean smallLetter = false;
        Boolean capitalLetter = false;
        Boolean specialCharacter = false;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                    capitalLetter = true;
                }
                if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                    smallLetter = true;
                }
                if (!(password.charAt(i) >= 65 && password.charAt(i) <= 90) && !(password.charAt(i) >= 97 && password.charAt(i) >= 122) && !(password.charAt(i) >= 48 && password.charAt(i) >= 57)) {
                    specialCharacter = true;
                }
            }
        if (!smallLetter || !specialCharacter || !capitalLetter || password.length() < 8) {
            if (password.length() < 8) {
                System.out.println("your password is too short");
                return;
            }
            if (!smallLetter || !capitalLetter || !specialCharacter) {
                System.out.println("your password lacks the required characters");
                return;
            }
        }
        if (!email.matches("\\S+@\\S+.com")) {
            System.out.println("your email is invalid");
            return;
        }
        System.out.println("User created successfully. Please choose a security question : ");
        System.out.println("• 1-What is your father’s name ?");
        System.out.println("• 2-What is your favourite color ?");
        System.out.println("• 3-What was the name of your first pet?");
        String entry = scanner.nextLine();
        Matcher newMatcher = null;
        if (entry.matches("question pick -q (?<QusetionNumber>[\\S]*) -a (?<Answe>[\\S]*) -c (?<AnswerConfirmation>[\\S]*)")) {
            newMatcher = getCommandMatcher(entry,"question pick -q (?<QuestionNumber>[\\S]*) -a (?<Answer>[\\S]*) -c (?<AnswerConfirmation>[\\S]*)");
            newMatcher.find();
        }
        String questionNumber = newMatcher.group("QuestionNumber");
        String answer = newMatcher.group("Answer");
        String answerConfirmation = newMatcher.group("AnswerConfirmation");
        System.out.println(questionNumber + " " + answer + " " + answerConfirmation);
        User newUser = new User(email, username, password, questionNumber, answer, answerConfirmation);
        users.add(newUser);
    }
    public static void randomSignup(Matcher matcher, Scanner scanner) {
        String email = matcher.group("Email");
        String username = matcher.group("Username");
        String nickname = matcher.group("Nickname");
        if (email.isEmpty() || username.isEmpty() || nickname.isEmpty()) {
            System.out.println("you have left a field empty!");
            return;
        }
        if (!username.matches("^[A-Za-z0-9_]+$")) {
            System.out.println("invalid username");
            return;
        }
        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("an account with this username already exists");
                return;
            }
        }
        System.out.println("HI");
        String[] passwords = new String[5];
        passwords[0] = "K05xher4g3";
        passwords[1] = "fhn13ca01";
        passwords[2] = "ionffvbe1";
        passwords[3] = "mbcpa2179";
        passwords[4] = "nompngh0982";
        int indicator = (int)Math.floor(Math.random() * 5);
        String password = passwords[indicator];
        System.out.println("Your random password: " + password);
        System.out.println("Please enter your password :...");
        String takenAnswer = scanner.nextLine();
        if (!takenAnswer.equals(password)) {
            System.out.println("the passwords do not match!");
            return;
        }
        System.out.println("User created successfully. Please choose a security question : ");
        System.out.println("• 1-What is your father’s name ?");
        System.out.println("• 2-What is your favourite color ?");
        System.out.println("• 3-What was the name of your first pet?");
        String entry = scanner.nextLine();
        Matcher newMatcher = null;
        if (entry.matches("question pick -q (?<QusetionNumber>[\\s\\S]*) -a (?<Answe>[\\s\\S]*) -c (?<AnswerConfirmation>[\\s\\S]*)")) {
            newMatcher = getCommandMatcher(entry,"question pick -q (?<QuestionNumber>[\\s\\S]*) -a (?<Answer>[\\s\\S]*) -c (?<AnswerConfirmation>[\\s\\S]*)");
            newMatcher.find();
        }
        String questionNumber = newMatcher.group("QuestionNumber");
        String answer = newMatcher.group("Answer");
        String answerConfirmation = newMatcher.group("AnswerConfirmation");
        User newUser = new User(email, username, password, questionNumber, answer, answerConfirmation);
        users.add(newUser);
    }
}