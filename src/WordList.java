public class WordList {
    //instance
    private String word;
    private String[] words;
    private int[] values;
    private int numWords;

    //Decleration
    public WordList(String word) {
        //Initialize Instance
        this.word = word;
        words = new String[999999];
        values = new int[999999];
        numWords = 0;
    }

    //Add a word to the list of associated words. True if word already existed
    public boolean addWord(String word) {
        for(int x = 0; x < numWords; x++) {
            if(word.equals(words[x])) {
                values[x]++;
                return true;
            }
        }
        words[numWords] = word;
        values[numWords] = 1;
        numWords++;
        return false;
    }

    public String[] getWords() {
        return words;
    }
    public int[] getValues() {
        return values;
    }

    public String getHighest() {
        int loc = 0;
        int val = values[0];

        for(int x = 0; x < numWords; x++) {
            if(values[x] > val && words[x] != word) {
                loc = x;
            }
        }
        return words[loc];
    }
}
