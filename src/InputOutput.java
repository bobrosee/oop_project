import java.util.*;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputOutput {
    static Scanner scanner;

    User firstUser = null;
    User secondUser = null;

    public InputOutput(Scanner scanner) {
        this.scanner = scanner;
    }
    public static boolean asciiArt() {
        String[] firstLineAscii =  {"000000", "1111  ","222222", "333333", "44  44", "555555", "666666", "777777", "888888", "999999"};
        String[] secondLineAscii = {"00  00", "  11  ","     2", "    33", "44  44", "55    ", "66    ", "    77", "88  88", "99  99"};
        String[] thirdLineAscii =  {"00  00", "  11  ","222222", "333333", "444444", "555555", "666666", "    77", "888888", "999999"};
        String[] fourthLineAscii = {"00  00", "  11  ","2     ", "    33", "    44", "    55", "66  66", "    77", "88  88", "    99"};
        String[] fifthLineAscii =  {"000000", "111111","222222", "333333", "    44", "555555", "666666", "    77", "888888", "999999"};
        Random random = new Random();

        int length = 5 + random.nextInt(3);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        ArrayList<String> firstLine = new ArrayList<String>();
        ArrayList<String> secondLine = new ArrayList<String>();
        ArrayList<String> thirdLine = new ArrayList<String>();
        ArrayList<String> fourthLine = new ArrayList<String>();
        ArrayList<String> fifthLine = new ArrayList<String>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int d = (c-'0');
            firstLine.add(firstLineAscii[d] + " ");
            secondLine.add(secondLineAscii[d] + " ");
            thirdLine.add(thirdLineAscii[d] + " ");
            fourthLine.add(fourthLineAscii[d] + " ");
            fifthLine.add(fifthLineAscii[d] + " ");
        }
        for (int i = 0 ; i < length; i++) {
            System.out.print(firstLine.get(i));
        }
        System.out.println();
        for (int i = 0 ; i < length; i++) {
            System.out.print(secondLine.get(i));
        }
        System.out.println();

        for (int i = 0 ; i < length; i++) {
            System.out.print(thirdLine.get(i));
        }
        System.out.println();

        for (int i = 0 ; i < length; i++) {
            System.out.print(fourthLine.get(i));
        }
        System.out.println();
        for (int i = 0 ; i < length; i++) {
            System.out.print(fifthLine.get(i));
        }
        System.out.println();
        String entry = scanner.nextLine();
        String sbs = String.valueOf(sb);
        if (sbs.equals(entry)) {
            return true;
        }
        else {
            System.out.println("Incorrect! please repeat!");
            return false;
        }
    }
    public static boolean asciiMath() {
        Random random = new Random();
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        int c = random.nextInt(10) + 1;
        String captcha = null;
        String[] operations = {"PLUS", "MINUS", "DIVIDED BY", "TIMES"};
        int d = random.nextInt(4);
        int e = 0;
        if (d == 0) {
            e = b + c;
        }
        if (d == 1) {
            e = b - c;
        }
        if (d == 2) {
            e = b / c;
        }
        if (d == 3) {
            e = b * c;
        }
        int f = random.nextInt(4);
        int g = random.nextInt(2);
        int h = 0;
        if (f == 0) {
            h = a + e;
            captcha = Integer.toString(a) + " " + "PLUS" + " (" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+") = ";
        }
        if (f == 2) {
            h = a * e;
            captcha = Integer.toString(a) + " " + "TIMES" + " (" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+") = ";

        }
        if (f == 1) {
            if (g == 0) {
                h = a - e;
                captcha = Integer.toString(a) + " " + "MINUS" + " (" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+") = ";
            }
            else {
                h = e - a;
                captcha ="(" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+")" + " MINUS " + Integer.toString(a) + " =";
            }
        }
        if (f == 3) {
            if (g == 0) {
                h = a / e;
                captcha = Integer.toString(a) + " " + "DIVIDED BY" + " (" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+") = ";

            }
            else {
                h = e / a;
                captcha = "(" + Integer.toString(b) + " " +operations[d] + " " + Integer.toString(c)+") " + "DIVIDED BY" + " " + Integer.toString(a) + " = ";
            }
        }
        System.out.println(captcha);
        int answer = Integer.parseInt(scanner.nextLine());
        if (answer == h) {
            return true;
        }
        else {
            System.out.println("Incorrect! please repeat!");
            return false;
        }
    }
    public void start()
    {
        String entry;
        entry = scanner.nextLine();
        Pattern[] patterns = new Pattern[10];
        patterns[0] = Pattern.compile("^user create -u \\S+ -p \\S{8,} \\S{8,} -email \\S+@\\S+.com -n \\S+$");
        patterns[1] = Pattern.compile("^user login -u \\S+ -p \\S+$");
        patterns[2] = Pattern.compile("^Forgot my password -u \\S+$");
        patterns[3] = Pattern.compile("^Show information$");
        patterns[4] = Pattern.compile("^log out$");
        patterns[5] = Pattern.compile("^Profile change -u \\S+$");
        patterns[6] = Pattern.compile("^Profile change -n \\S+$");
        patterns[7] = Pattern.compile("^Profile change -e \\S+$");
        patterns[8] = Pattern.compile("^Profile change password -o \\S+ -n \\S+$");
        patterns[9] = Pattern.compile("^-login admin adminpass$");
        Matcher[] matchers = new Matcher[10];
        while(!entry.equals("Exit"))
        {
        for(int i = 0; i < matchers.length; i++)
        {
            matchers[i] = patterns[i].matcher(entry);
        }
            if (entry.matches("user create -u (?<Username>\\S+) -p (?<Password>\\S+) (?<PasswordConfirmation>\\S+) -email (?<Email>\\S+) -n (?<Nickname>\\S+)"))
            {
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
        if(matchers[0].find())
        {
            //sign up
        }
        else if(matchers[1].find())
        {
            login(entry.split("\\s+"));
        }
        else if(matchers[2].find())
        {
            forgetPass(entry.split("\\s+"));
        }
        else if(matchers[3].find())
        {
            showinfo();
        }
        else if (matchers[4].find()) {
            logout();
        }
        else if (matchers[5].find()) {
            changeUsername(entry.split("\\s+"));
        }
        else if (matchers[6].find()) {
            changeNickname(entry.split("\\s+"));
        }
        else if (matchers[7].find()) {
            changeMail(entry.split("\\s+"));
        }
        else if (matchers[8].find()) {
            changePass(entry.split("\\s+"));
        }
        else if(matchers[9].find())
        {
            Admin.starts();
        }


            entry = scanner.nextLine();

        }
    }
    //make this shi its own class
    public void login(String[] inputs)
    {
        Boolean flag = false;
        for(int i = 0; i < User.users.size();i++)
        {
            if(inputs[3].equals(User.users.get(i).getUsername()))
            {
                flag = true;
                if(inputs[5].equals(User.users.get(i).getPassword()))
                {
                    User.users.get(i).login = true;
                    User.logged = i;
                    System.out.println("user logged in successfully!");
                    break;
                }
                else
                {
                    System.out.println("Password and Username don't match!");
                }
            }

        }
        if(!flag)
        {
            System.out.println("Username doesn't exist!");
        }
        //add time
    }
    public void secondLogin(String[] inputs) {
        firstUser = User.users.get(User.logged);
        String username = inputs[3];
        String password = inputs[5];
        boolean usernameFlag = false;
        boolean passwordFlag = false;
        for (User user : User.users) {
            if (user.getUsername().equals(username)){
                usernameFlag = true;
                if (user.getPassword().equals(password)){
                    passwordFlag = true;
                    secondUser = user;
                }
            }
        }
        if (!usernameFlag) {
            System.out.println("Username doesn't exist!");
            return;
        }
        if (!passwordFlag) {
            System.out.println("Password and Username don’t match!");
            return;
        }
        if (passwordFlag && usernameFlag) {
            System.out.println("user logged in successfully!");
        }
    }

    public void forgetPass(String[] inputs)
    {
        String answer;
        for(int i = 0; i< User.users.size();i++)
        {
            if(inputs[4].equals(User.users.get(i).getUsername()))
            {
                if(User.users.get(i).getSec_question().equals("1"))
                {
                    System.out.println("What is your Father's name ?");
                    answer = scanner.nextLine();
                    if(answer.equals(User.users.get(i).getSec_answer()))
                    {
                        System.out.println("your password is:"+User.users.get(i).getPassword());
                    }
                    else{
                        System.out.println("your answer was incorrect!");
                    }
                }
                else if(User.users.get(i).getSec_question().equals("2"))
                {
                    System.out.println("What is your favourite color ?");
                    answer = scanner.nextLine();
                    if(answer.equals(User.users.get(i).getSec_answer()))
                    {
                        System.out.println("your password is:"+User.users.get(i).getPassword());
                    }
                    else{
                        System.out.println("your answer was incorrect!");
                    }
                }
                else{
                    System.out.println("What was the nname");
                    answer = scanner.nextLine();
                    if(answer.equals(User.users.get(i).getSec_answer()))
                    {
                        System.out.println("your password is:"+User.users.get(i).getPassword());
                    }
                    else{
                        System.out.println("your answer was incorrect!");
                    }
                }
                break;
            }
        }

    }
    public void showinfo()
    {
        System.out.println("Username : " + User.users.get(User.logged).getUsername());
        System.out.println(" Mail : " + User.users.get(User.logged).getMail());
        System.out.println("Password : " + User.users.get(User.logged).getPassword());
        System.out.println("Nickname : " + User.users.get(User.logged).getNickname());
        System.out.println(" Level : " + User.users.get(User.logged).getLevel());
    }
    public void logout()
    {
        User.users.get(User.logged).login = false;
        User.logged = -1;
    }
    public void changeUsername(String[] inputs)
    {
        Boolean flag = false;
        for(int i = 0; i< User.users.size();i++)
        {
            if(inputs[3].equals(User.users.get(i).getUsername()))
            {
                System.out.println("Username already exists!");
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            User.users.get(User.logged).setUsername(inputs[3]);
            System.out.println("Username changed successfully!");
        }
    }
    public void changeNickname(String[] inputs)
    {
        Boolean flag = false;
        for(int i = 0; i< User.users.size();i++)
        {
            if(inputs[3].equals(User.users.get(i).getNickname()))
            {
                System.out.println("Nickname already exists!");
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            User.users.get(User.logged).setNickname(inputs[3]);
            System.out.println("Nickname changed successfully!");
        }
    }
    public void changeMail(String[] inputs)
    {
        Boolean flag = false;
        if(inputs[3].matches("\\S+@\\S+.com"))
        {
            User.users.get(User.logged).setMail(inputs[3]);
            System.out.println("Mail changed successfully!");
        }

        else{
            System.out.println("Mail format is not accepted!");
        }
    }
    public void changePass(String[] inputs)
    {
        String pass;
        if(inputs[6].matches("\\S{8,}"))
        {
            if(inputs[6].equals(inputs[4]))
            {
                System.out.println("Please enter a new password!");
            }
            else{
                System.out.println("Please enter your new password again!");
                pass = scanner.nextLine();
                if(pass.equals(inputs[6]))
                {
                    User.users.get(User.logged).setPassword(pass);
                }
                else{
                    System.out.println("Current Password is Incorrect!");
                }
            }
        }
        else{
            System.out.println("Password should contain at least 8 characters and should not have any spaces!");
        }
    }

    public void signup(Matcher matcher, Scanner scanner) {
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
        for (User user : User.users) {
            if (user.getUsername().equals(username)) {
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
        if (entry.matches("question pick -q (?<QusetionNumber>[\\S]*) -a (?<Answer>[\\S]*) -c (?<AnswerConfirmation>[\\S]*)")) {
            newMatcher = getCommandMatcher(entry,"question pick -q (?<QuestionNumber>[\\S]*) -a (?<Answer>[\\S]*) -c (?<AnswerConfirmation>[\\S]*)");
            newMatcher.find();
        }
        String questionNumber = newMatcher.group("QuestionNumber");
        String answer = newMatcher.group("Answer");
        String answerConfirmation = newMatcher.group("AnswerConfirmation");
        Random random = new Random();
        int f = random.nextInt(2);
        if (f == 0) {
            while (!asciiMath()) {

            }
        }
        else {
            while (!asciiArt()) {

            }
        }
        System.out.println("Correct! account created successfully!");
//        System.out.println(questionNumber + " " + answer + " " + answerConfirmation);
        User newUser = new User(email, username, password, questionNumber, answer, nickname);
        User.users.add(newUser);
    }


    ////////////////////////
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
        for (User user : User.users) {
            if (user.getUsername().equals(username)) {
                System.out.println("an account with this username already exists");
                return;
            }
        }
        System.out.println("HI");
        String[] passwords = new String[5];
        passwords[0] = "K05xher4g3";
        passwords[1] = "fHn13ca01";
        passwords[2] = "ioNffvbe1";
        passwords[3] = "mBcpa2179";
        passwords[4] = "nompNgh0982";
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
        if (entry.matches("question pick -q (?<QusetionNumber>[\\s\\S]*) -a (?<Answer>[\\s\\S]*) -c (?<AnswerConfirmation>[\\s\\S]*)")) {
            newMatcher = getCommandMatcher(entry,"question pick -q (?<QuestionNumber>[\\s\\S]*) -a (?<Answer>[\\s\\S]*) -c (?<AnswerConfirmation>[\\s\\S]*)");
            newMatcher.find();
        }
        String questionNumber = newMatcher.group("QuestionNumber");
        String answer = newMatcher.group("Answer");
        String answerConfirmation = newMatcher.group("AnswerConfirmation");
        Random random = new Random();
        int f = random.nextInt(2);
        if (f == 0) {
            while (!asciiMath()) {

            }
        }
        else {
            while (!asciiArt()) {

            }
        }
        System.out.println("Correct! account created successfully!");
        User newUser = new User(email, username, password, questionNumber, answer, nickname);
        User.users.add(newUser);
    }
    public static Matcher getCommandMatcher(String input, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
}