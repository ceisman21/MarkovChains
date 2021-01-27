import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./resources/A.txt");
        MarkovChain m = new MarkovChain(file, 1);
        m.createLists();
        String[] str = new String[1];
        str[0] = "!";
        System.out.println(m.nextWord(str));
    }
}
