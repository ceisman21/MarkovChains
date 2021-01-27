public class WordTrack {
    //Instance
    private String word;
    private int precision;
    private WordList[] words;


    //Decleration
    public WordTrack(String word, int precision) {
        //Implement Instance
        this.word = word;
        this.precision = precision;

        //For size of precision, create Wordlists in words[]
        words = new WordList[precision];
        for(int x = 0; x < words.length; x++) {
            words[x] = new WordList(word);
        }
    }

    //add word associations
    public void addAssociations(String[] orderedInput) {
        //add words from the ordered input list into the associations list
        for(int x = 0; x < orderedInput.length; x++) {
            words[x].addWord(orderedInput[x]);
        }
    }

    //Return a weighted list and their words
    public WordList[] getLists(int x) {
        return words;
    }
    public int getPrecision() {
        return precision;
    }
}
