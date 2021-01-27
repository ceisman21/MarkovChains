import java.util.ArrayList;

public class KVArrays {
    private ArrayList<KVArray> words;

    public KVArrays() {
        words = new ArrayList<KVArray>();
    }
    //Adds Word to a Set of words
    public void add(String firstWord, String afterWord) {
        if(contains(firstWord.toLowerCase())) {
            (words.get(locationOf(firstWord.toLowerCase()))).add(afterWord.toLowerCase());
        } else {
            words.add(new KVArray(firstWord.toLowerCase()));
            words.get(words.size()-1).add(afterWord.toLowerCase());
        }
    }
    //Returns Location, or -1 if not exist
    public int locationOf(String word) {
        for(int x = 0; x < words.size(); x++) {
            if(word.equals(words.get(x).getCurrWord())) {
                return x;
            }
        }
        return -1;
    }

    //If contains
    public boolean contains(String word) {
        return !(locationOf(word) == -1);
    }
    //Public KVArr
    public String toString() {
        String s = "";
        for (int x = 0; x < words.size(); x++) {
            s += "" + x + ") " + words.get(x).toString();
        }
        return s;
    }
    public String getWords(int x) {
        //Get a random first word
        String s;
        int y = (int)(words.size()*Math.random());
        s = words.get(y).getCurrWord() + " ";
        String temp = s;

        for(int z = 0; z < x; z++) {
            if(contains(temp)) {
                s += words.get(locationOf(temp)).getNewWord() + " ";
            } else {
                temp = ".";
                s+= ". ";
                s += words.get(locationOf(temp)).getNewWord() + " ";
            }
        }
        return s;

    }

}
