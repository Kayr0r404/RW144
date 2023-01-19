package DictionaryTypes;
import java.util.*;
import DictionaryTypes.abstractClasses.Dictionary;
import DictionaryTypes.TrieStructureComponents.*;

public class TrieDictionary extends Dictionary implements DictionaryInterface {

    public String Array[];
    public int counter;
    private State root;

    public TrieDictionary() {
        root = new State();
        Array = new String[30000];
        this.counter = 0;
    }

    /* SPECIFIC METHODS - Hand in 2 */
    public ArrayList<Character> BFS() {
        // todo
        return null;
    }

    public ArrayList<Character> DFS() {
        // todo
        return null;
    }

    /* GENERAL METHODS - Hand in 1 */
    public void removeWord(String word1) {
        // todo
        String[] newArr = new String[counter - 1];
        int index = 0;
        for (int i = 0; i < counter; i++) {
            if (Array[i].equals(word1)) {
                index = i;
                counter--;
            }
        }

        String[] anotherArray = new String[Array.length - 1];
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < Array.length; i++) {
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
            // if the index is not
            // the removal element index
            anotherArray[k++] = Array[i];
        }
        Array = Arrays.copyOf(anotherArray, Array.length);
    }

    public void CreateDictionary(String filePath) {
        // todo
        In file = new In(filePath);
        while (file.hasNextLine()) {
            String word = file.readLine();
            if (!(isWord(word))) {
                Array[counter++] = word;
            }
        }
    }

    public String findCommonPrefix(String word) {
        // todo
        String commonPrefix = "";
        for (int i = 0; i < counter; i++) {
            String temp = "";
            int sizeSmall = Math.min(word.length(), Array[i].length());
            for (int j = 0; j < sizeSmall; j++) {
                if (Array[i].charAt(j) == word.charAt(j)) {
                    temp += word.charAt(j);
                    if (temp.length() > commonPrefix.length()) {
                        commonPrefix = temp;
                    }
                }
            }
        }
        return commonPrefix;
    }

    public boolean isWord(String word) {
        // todo
        for (int i = 0; i < counter; i++) {
            if (Array[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void addNewWord(String w) {
        // todo
        if (!isWord(w)) {
            if (counter != Array.length) {
                Array[counter++] = w;
            }
        }
    }

    public ArrayList<String> getDictionaryWords() {
        // todo
        ArrayList<String> text = new ArrayList<String>();
        for (int i = 0; i < counter; i++) {
            text.add(Array[i]);
        }
        return text;
    }

    public int getNumberOfElements() {
        // todo
        return counter;
    }

    public String[] getTopNSuggestions(ArrayList<String> dictionaryWords, String word, int N) {
        // todo
        String[] Arr = dictionaryWords.toArray(new String[dictionaryWords.size()]);
        String[] A = {};
        int count = 0, diff = 0;
        while (count <= word.length()) {
            for (int i = 0; i < Arr.length; i++) {
                if ((this.getLevenshteinDistance(Arr[i], word) == diff && A.length < N)) {
                    A = Arrays.copyOf(A, A.length + 1);
                    A[A.length - 1] = Arr[i];
                }
            }
            diff++;
            count++;
        }
        return A;
    }

}
