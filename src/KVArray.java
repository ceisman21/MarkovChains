import java.util.ArrayList;

public class KVArray {
    //Instance
    private ArrayList<KVNode> KVNodes;
    private String currWord;


    //Constructor
    public KVArray(String word) {
        KVNodes = new ArrayList<KVNode>();
        currWord = word;
    }

    //Adds a value to the Array, or sets weighting
    public void add(String word) {
        if(contains(word)) {
            KVNodes.get(locationOf(word)).addValue(1.0);
        } else {
            KVNodes.add(new KVNode(1.0, word));
        }
    }

    //Returns location of a String; -1 if doesn't exist
    public int locationOf(String word) {
        for(int x = 0; x < KVNodes.size(); x++) {
            if(KVNodes.get(x).getData().equals(word)) {
                return x;
            }
        }
        return -1;
    }

    //Returns whether or not the array contains the inputted object
    public boolean contains(String word) {
        return !(locationOf(word) == -1);
    }

    //Sorts the Array by odds, most to least
    public void order() {
        int len = KVNodes.size();
        ArrayList<KVNode> KVTemp = new ArrayList<KVNode>();

        //find the highest of remaining ints
        do {
            double max = KVNodes.get(0).getValue();
            int maxPos = 0;

            for(int x = 0; x < KVNodes.size();x++) {
                if (KVNodes.get(x).getValue() > max) {
                    max = KVNodes.get(x).getValue();
                    maxPos = x;
                }
            }
            KVTemp.add(KVNodes.get(maxPos));
            KVNodes.remove(maxPos);

        } while (!KVNodes.isEmpty());

        KVNodes = KVTemp;
    }

    //Accesor
    public KVNode get(int x) {
        return KVNodes.get(x);
    }

    //ToStirng
    public String toString() {
        String s = currWord + ": ";
        for(int x = 0; x < KVNodes.size(); x++) {
            s += "     " + x + ". " + KVNodes.get(x).getData() + "(" + KVNodes.get(x).getValue() + ")\n";
        }
        return s;
    }

    //Gets the word
    public String getCurrWord() {
        return currWord;
    }
    public String getNewWord() {
        int x = (int)(KVNodes.size()*Math.random());
        return KVNodes.get(x).getData();
    }
}
