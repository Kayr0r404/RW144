import java.util.*;
import java.io.*;


public class ArrayDictionary1 {
    public static String[] Dict;
    public int numOfElements;

    /* GENERAL METHODS hand-in 1*/
    public ArrayDictionary1() {
        Dict = new String[30000];
        numOfElements = 0;
    }

    /* GENERAL METHODS Hand-in 1*/

    /**
     * Populate the essential dictionary data structure
     * with all the words read from the input language.
     * Returns nothing.
     *
     * @param filepath the filepath for the input language.
     * @throws IOException catch an file errors.
     */
   public void CreateDictionary(String filepath)throws IOException{
        // todo
        // In file = new In(filepath);
        Scanner file = new Scanner(new File(filepath));
        while (file.hasNextLine()) {
            String word = file.nextLine();
            if(!(isWord(word))){
                Dict[numOfElements++] = word;
            }
        }
    }

    /**
     * Look for the word in the dictionary
     *
     * @param word the word to look for in the dictionary.
     * @return the return value indicating whether word is
     * found or not.
     */
    public boolean isWord(String word) {
        for (int i = 0; i < numOfElements; i++) {
            if (Dict[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * adds a new word to the dictionary if the word
     * not found in the dictionary.
     *
     * @param word word to add in the dictionary
     */
    public void addNewWord(String word) {
//        for (int i = 0; i < Dict.length; i++) {
//            if (!Dict[i].contains(word)) {
//
//                int wordIndex = locatePosition();
//                Dict[wordIndex] = word;
//
//            }
//        }

        if (!isWord(word)) {
            Dict[numOfElements++] = word;
        }
    }

    /**
     * Removes the word in the dictionary if the word is there
     * in the dictionary.
     *
     * @param word the word to remove
     */
    public void removeWord(String word) {
//        //todo
//        String[] dict2 = new String[Dict.length - 1];
//        int wordIndex = 0;
//        for (int i = 0; i < Dict.length; i++) {
//            if (Dict[i] != null && Dict[i].equals(word)) {
//                wordIndex = i;
//                break;
//            }
//        }
//        System.out.println(wordIndex);
//
//        for (int j = 0; j < wordIndex; j++) {
//            dict2[j] = Dict[j];
//        }
//        for (int k = wordIndex + 1; k < dict2.length; k++) {
//            dict2[k - 1] = Dict[
//        Dict = dict2;k];
////        }
//        System.out.print(Arrays.toString(Dict));
        int index = 0;
        for (int i = 0; i < Dict.length; i++) {
//            find the index of the word to be removed
            if (Dict[i].equals(word)) {
                index = i;
                numOfElements--;
            }
        }
        String newDict[] = new String[Dict.length];
        int j = 0;
        for (int i = 0; i < newDict.length; i++, j++) {
            if (Dict[i].equals(word)) {
                continue;
            }
            newDict[j] = Dict[i];
        }
        for (int i = 0; i < newDict.length; i++) {
            Dict[i] = newDict[i];
        }
    }

    /**
     * adds  all the words in the dictionary to an arraylist.
     *
     * @return the arraylist of all words in the dictionary.
     */

    public ArrayList<String> getDictionaryWords() {
        //todo
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < numOfElements; i++) {
//            while (!(Dict[i] == null)) {
//                System.out.println(Dict[i] + "\n");
            list.add(Dict[i]);
//            }
        }
        return list;
    }

//    private String get(String s) {
//        return s;
//    }

    /**
     * @return the number of elements in the dictionary.
     */
    public int getNumberOfElements() {
//        //todo
//        int count = 0;
//        for (int i = 0; i < Dict.length; ++i) {
//            while (Dict[i] != null) {
//                count++;
//            }
//            numOfElements = count - 1;
//        }
        return numOfElements;
    }

    /**
     * find the position where to add word.
     *
     * @return the integer position value
     */
//    private int locatePosition() {
//        int position = 0;
//        while (position <= numOfElements) {
//            position++;
//        }
//        return position;
//
//
//    }
}