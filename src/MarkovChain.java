import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MarkovChain {
    //Instance Variables
    private Scanner fileScan;
    private File file;

    //Declaration
    public MarkovChain(File file){
        //Initialize Instance
        this.file = file;

        //initialize the scanner
        try {
            fileScan = new Scanner(this.file);
        } catch (FileNotFoundException f) {
            fileScan = null;
        }
    }

    //Creates lists of commonly used words and phrases
    public void createLists() {

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
}
