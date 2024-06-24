import java.util.*;
import java.util.regex.*;

public class InputOutput {
    Scanner scanner;

    public InputOutput(Scanner scanner) {
        this.scanner = scanner;
    }
    public void start()
    {
        String entry;
        entry = scanner.nextLine();
        Pattern[] patterns = new Pattern[9];
        patterns[0] = Pattern.compile("^user create -u \\S+ -p \\S{8,} \\S{8,} -email \\S+@\\S+.com -n \\S+$");
        patterns[1] = Pattern.compile("^user login -u \\S+ -p \\S+$");
        patterns[2] = Pattern.compile("^Forgot my password -u \\S+$");
        patterns[3] = Pattern.compile("^Show information$");
        patterns[4] = Pattern.compile("^log out$");
        patterns[5] = Pattern.compile("^Profile change -u \\S+$");
        patterns[6] = Pattern.compile("^Profile change -n \\S+$");
        patterns[7] = Pattern.compile("^Profile change -e \\S+$");
        patterns[8] = Pattern.compile("^Profile change password -o \\S+ -n \\S+$");


        Matcher[] matchers = new Matcher[9];
        while(!entry.equals("Exit"))
        {
        for(int i = 0; i < matchers.length; i++)
        {
            matchers[i] = patterns[i].matcher(entry);
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


            entry = scanner.nextLine();

        }
    }
    // sign up barb
//    public void signup(String[] inputs)
//    {
//        if(!inputs[3].matches("[a-zA-Z0-9_]+"))
//        {
//            System.out.println("Invalid Username");
//        }
//        else if(!inputs[5].equals(inputs[6]))
//        {
//            System.out.println("Passwords do not match");
//        }
//
//    }

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
}
