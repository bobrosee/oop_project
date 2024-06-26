import java.util.*;
public class Cards {
    int number;
    public String name;
    int att_def;
    int duration;
    int damage;
    int price;
    int upgrade_level;
    int upgrade_cost;
    int colour;
    static ArrayList<Cards> cards = new ArrayList<>();
    public Cards(int number, String name, int att_def, int duration,int damage, int upgrade_level, int upgrade_cost, int price,int colour) {
        this.name = name;
        this.number = number;
        this.att_def = att_def;
        this.duration = duration;
        this.damage = damage;
        this.upgrade_level = upgrade_level;
        this.upgrade_cost = upgrade_cost;
        this.colour = colour;
        this.price = price;
    }
}
