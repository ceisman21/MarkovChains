import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        //Find what the user wants
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Markov Chain Generator. Please select a file to train from: ");
        System.out.println("1) Bee Movie Script");
        System.out.println("2) Book of Genesis");
        System.out.println("3) Donald Trump's State of the Union Address");
        System.out.println("4) Your Own File");
        System.out.print("Your choice: ");
        int user = s.nextInt();
        System.out.println();

        File file = null;
        if (user == 1) {
            file = new File("./resources/Bee.txt");
        } else if (user == 2) {
            file = new File("./resources/Genesis.txt");
        } else if(user == 3) {
            file = new File("./resources/TrumpSpeech.txt");
        } else if (user == 4) {
            System.out.println("In order to use your own file, please ensure it has been placed in the Resources Directory.");
            System.out.print("File Name: ");
            String fileName = s.next();
            file = new File("./resources/" + fileName);
            System.out.println();
        } else {
            System.out.println("Not a Valid Expression");
            System.exit(69);
        }



        Scanner fileScan = new Scanner(file);

        //Scans
        fileScan.useDelimiter(" ");

        KVArrays kva = new KVArrays();

        //iterate through text file
        String firstWord = "";
        String secondWord = "";
        String temp = "";
        while(fileScan.hasNext()) {
            temp = fileScan.next().toLowerCase();
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
