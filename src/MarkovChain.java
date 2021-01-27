import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MarkovChain {
    //Instance Variables
    private Scanner fileScan;
    private File file;
    private int prescision;
    private ArrayList theWords;

    //Declaration
    public MarkovChain(File file, int prescision){
        //Initialize Instance
        this.file = file;
        this.prescision = prescision;

        //initialize the scanner
        try {
            fileScan = new Scanner(this.file);
        } catch (FileNotFoundException f) {
           System.exit(69);
        }

        theWords = new ArrayList<WordTrack>();
    }

    //Creates lists of commonly used words and phrases
    public void createLists() {
        //Seperate Words
        fileScan.useDelimiter(" ");

        ArrayList words = new ArrayList<String>();

        //iterate
        String temp = "";
        while(fileScan.hasNext()) {
            temp = fileScan.next();
            if((temp.endsWith("."))) {
                words.add(temp.substring(0,temp.length()-1));
                words.add(".");
            } else if (temp.endsWith(",")) {
                words.add(temp.substring(0, temp.length() - 1));
                words.add(",");
            } else if (temp.endsWith("!")) {
                words.add(temp.substring(0,temp.length()-1));
                words.add("!");
            } else if (temp.endsWith("?")) {
                words.add(temp.substring(0,temp.length()-1));
                words.add("?");
            } else {
                words.add(temp);
            }
        }
        addToList(words);

    }

    //adds a val to list or adds a weighting
    private void addToList(ArrayList words) {
        //iterate through and assign all words
        for(int x = 0; x < words.size() - prescision; x++) {
            String[] temp = new String[prescision];

            for(int z = 0; z < temp.length; z++) {
                temp[z] = (String)(words.get(x+z));
            }

            boolean hadWord = false;
            for (int y = 0; y < theWords.size(); y++) {
                if (words.get(x).equals(((WordTrack)(theWords.get(y))).getWord())) {
                    ((WordTrack)(theWords.get(y))).addAssociations(temp);
                    hadWord = true;
                }
            }
            if(!hadWord) {
                theWords.add(new WordTrack((String)(words.get(x)), prescision));
                ((WordTrack)(theWords.get(theWords.size()-1))).addAssociations(temp);
            }
            hadWord = false;
        }
    }

    public String nextWord(String[] prev) {
        //iterate through and assign all words
        ArrayList vals = new ArrayList();
        ArrayList odds = new ArrayList();
        System.out.println(theWords.indexOf(new WordTrack(prev[0], prescision)));
        return (((WordTrack)(theWords.get(theWords.indexOf(new WordTrack(prev[0], prescision))))).getLists(0)).getHighest();
        }



    //Mutator for File
    public void setFile(File file) {
        //Sets the file
        this.file = file;

        //Re-initializes the Scanner
        try {
            fileScan = new Scanner(this.file);
        } catch (FileNotFoundException f) {
            fileScan = null;
        }

    }

    //Accessor for File
    public File getFile() {
        return file;
    }

    //Test Equals

}
