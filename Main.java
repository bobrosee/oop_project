import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        writer.write("fuck off\n");
        writer.write("hello");
        writer.close();
    }
}