import javax.swing.*;
import java.util.*;
import java.util.regex.*;
public class Admin {


    public static void starts()
    {
        System.out.println("Welcome admin!");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        Pattern[] patterns = new Pattern[4];
        Matcher[] matchers = new Matcher[4];
        patterns[0] = Pattern.compile("^create a new card$");
        patterns[1] = Pattern.compile("^edit cards$");
        patterns[2] = Pattern.compile("^delete a card$");
        patterns[3] = Pattern.compile("^view players$");

        while(!input.equals("Exit"))
        {
            for(int i = 0; i < patterns.length;i++)
            {
                matchers[i] = patterns[i].matcher(input);
            }
            if(matchers[0].find())
            {
                create_card(scanner);
            }
            if(matchers[1].find())
            {
                editcards(scanner);
            }
            if(matchers[2].find())
            {
                deletecard(scanner);
            }
            if(matchers[3].find())
            {
                viewplayer();
            }





            input = scanner.nextLine();
        }
    }
    public static void create_card(Scanner scanner)
    {
        String name;
        int att_def;
        int duration;
        int damage;
        int upgrade_level;
        int upgrade_cost;
        Boolean flag = false;
        System.out.println("Enter cards name");
        name = scanner.nextLine();
        while(!flag)
        {
            for(int i = 0; i < Cards.cards.size();i++)
            {
                if(Cards.cards.get(i).name.equals(name))
                {
                    System.out.println("This name has already been used!");
                    name = scanner.nextLine();
                    break;
                }
                else{
                    flag = true;
                }
            }
            if(Cards.cards.isEmpty())
            {
                flag = true;
            }
        }
        System.out.println("Enter attack/defence attribute");
        att_def = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter duration");
        duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter damage");
        damage = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter upgrade level");
        upgrade_level = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter upgrade cost");
        upgrade_cost = Integer.parseInt(scanner.nextLine());
        Cards card = new Cards(name,att_def,duration,damage,upgrade_level,upgrade_cost);
        Cards.cards.add(card);
        System.out.println("Card added successfully");
    }
    public static void editcards(Scanner scanner)
    {
        System.out.println("which card you wish to change");
        for(int i = 0; i < Cards.cards.size();i++)
        {
            System.out.println((i+1) +": "+Cards.cards.get(i).name);
        }
        int x;
        x = Integer.parseInt(scanner.nextLine());
        x--;
        System.out.println("Which attribute you wish to change");
        System.out.println("1. name 2.att/def 3.duration 4.damage 5.upgrade level 6.upgrade cost");
        int y;
        y = Integer.parseInt(scanner.nextLine());
        int z;
        if(y == 1)
        {
            String name = "hi!";
            System.out.println("Enter the new name");
            name = scanner.nextLine();
            Boolean flag = false;
            while(!flag)
            {
                for(int i = 0; i < Cards.cards.size();i++)
                {
                    if(Cards.cards.get(i).name.equals(name))
                    {
                        System.out.println("This name has already been used!");
                        name = scanner.nextLine();
                        break;
                    }
                    else{
                        flag = true;
                    }
                }
                if(Cards.cards.isEmpty())
                {
                    flag = true;
                }
            }
            System.out.println("name changed successfully");
            Cards.cards.get(x).name = name;
        }
        else if(y == 2)
        {
            System.out.println("Enter the att/def number");
            z = Integer.parseInt(scanner.nextLine());
            Cards.cards.get(x).att_def = z;
        }
        else if(y == 3)
        {
            System.out.println("Enter the duration");
            z = Integer.parseInt(scanner.nextLine());
            Cards.cards.get(x).duration = z;
        }
        else if(y == 4)
        {
            System.out.println("Enter the damage");
            z = Integer.parseInt(scanner.nextLine());
            Cards.cards.get(x).damage = z;
        }
        else if(y == 5)
        {
            System.out.println("Enter upgrade level");
            z = Integer.parseInt(scanner.nextLine());
            Cards.cards.get(x).upgrade_level = z;
        }
        else if(y == 6)
        {
            System.out.println("Enter upgrade cost");
            z = Integer.parseInt(scanner.nextLine());
            Cards.cards.get(x).upgrade_cost = z;
        }
    }
    public static void deletecard(Scanner scanner)
    {
        System.out.println("Which card you wish to delete");
        for (int i = 0; i < Cards.cards.size(); i++) {
            System.out.println((i+1)+": "+Cards.cards.get(i).name);
        }
        int x;
        x = Integer.parseInt(scanner.nextLine());
        x--;
        Cards.cards.remove(x);
        System.out.println("Card was removed successfully");
    }
    public static void viewplayer()
    {
        for (int i = 0; i < User.users.size(); i++) {
            System.out.println((1+i) +". name:"+User.users.get(i).getUsername() +"\n mail: "+User.users.get(i).getMail()+"\n level:"+User.users.get(i).getLevel()+"\n nickname:"+User.users.get(i).getNickname()+"\n security question: "+User.users.get(i).getSec_answer()+"\n security answer:"+User.users.get(i).getSec_answer());

        }
    }
}
