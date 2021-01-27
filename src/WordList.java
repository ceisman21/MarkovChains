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
        words = new String[100];
        values = new int[100];
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
}
