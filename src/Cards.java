import java.util.*;
public class Cards {
    public String name;
    int att_def;
    int duration;
    int damage;
    int upgrade_level;
    int upgrade_cost;
    static ArrayList<Cards> cards = new ArrayList<>();
    public Cards(String name, int att_def, int duration,int damage, int upgrade_level, int upgrade_cost) {
        this.name = name;
        this.att_def = att_def;
        this.duration = duration;
        this.upgrade_level = upgrade_level;
        this.upgrade_cost = upgrade_cost;
    }
}
