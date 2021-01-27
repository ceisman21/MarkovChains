import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./resources/TrumpSpeech.txt");
        Scanner fileScan = new Scanner(file);
        fileScan.useDelimiter(" ");

        KVArrays kva = new KVArrays();

        //iterate
        String firstWord = "";
        String secondWord = "";
        String temp = "";
        while(fileScan.hasNext()) {
            temp = fileScan.next();
            if((temp.endsWith("."))) {
                secondWord = (temp.substring(0,temp.length()-1));
                kva.add(firstWord, secondWord);
                firstWord = secondWord;
                temp = ".";
                kva.add(firstWord, temp);
            } else if (temp.endsWith(",")) {
                secondWord = (temp.substring(0,temp.length()-1));
                kva.add(firstWord, secondWord);
                firstWord = secondWord;
                temp = ",";
                kva.add(firstWord, temp);
            } else if (temp.endsWith("!")) {
                secondWord = (temp.substring(0,temp.length()-1));
                kva.add(firstWord, secondWord);
                firstWord = secondWord;
                temp = "!";
                kva.add(firstWord, temp);
            } else if (temp.endsWith("?")) {
                secondWord = (temp.substring(0,temp.length()-1));
                kva.add(firstWord, secondWord);
                firstWord = secondWord;
                temp = "?";
                kva.add(firstWord, temp);
            } else {
                kva.add(firstWord, temp);
            }
            firstWord = temp;
        }

        System.out.println(kva.getWords(100));
    }
}
