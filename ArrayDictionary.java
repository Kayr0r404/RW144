package DictionaryTypes;
import DictionaryTypes.abstractClasses.ArrayTypeDictionary;
import java.util.*;

/**
 * 
 * @author Karabo Mahlare
 *{@summary}
 */
public class ArrayDictionary extends ArrayTypeDictionary implements DictionaryInterface {
    public String[] Arr;
    public int I;
    /**
     * constructor of the data structure
     */
    public ArrayDictionary() {
        // todo
        Arr = new String[30000];
        this.I = 0;
    }
    /* GENERAL METHODS Hand-in 1 */
    /**
     * reads in a textfile and reads all the textfile contents into an array
     * @param filepath this is the location of the input file 
     */
    @Override
    public void CreateDictionary(String filepath) {
        // todo
        In file = new In(filepath);
        while (file.hasNextLine()) {
            // Arr[I] = file.readLine();
            // I++;
            String word = file.readLine();
            if(!(isWord(word))){
                Arr[I++] = word;
            }
        }
    }
    /**
     * looks for a word in the dictionary
     *@param word : word to be checked if it exist in the dictionary
     *@return returns true if the word exist , otherwise false
     */
    @Override
    public boolean isWord(String word) {
        // todo
        for (int i = 0; i < I; i++) {
            if (Arr[i].equals(word)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Add a new word if does not already exist in the dictionary
     * @param word : word to be added in the dictionary
     */
    @Override
    public void addNewWord(String word) {
        // todo
        if(!(isWord(word))){
            Arr[I++] = word;
        }
    }
    /**
     * takes in a string as an argument and removes it from the dictionary, if the word exist in the dictionary 
     * @param word wordd to be removed from the dictionary
     */
    @Override
    public void removeWord(String word) {
    	  //todo
        //first find the index of the word to be removed in the array
        int index = 2000000000;
        for(int i =0; i < I; i++) {
      	  if(Arr[i].equals(word)) {
      		index = i;
            I--;
      	  }
        }
        
        // will contain all the words from the Actual array except the word to be removed
        String[] newArray = new String[Arr.length - 1];
        // Copy all words into the new array from original array except the word at the index
        for (int i = 0, j = 0; i < Arr.length; i++) {
         // if the index is the removal element index
            if (i == index) {
                continue;
            }
            // if the index is not the removal element index
            newArray[j++] = Arr[i];
        }
      Arr = Arrays.copyOf(newArray, Arr.length);
//      System.out.println(Arr.length);
    }
    /**
     * takes no parameter and return the words from the dictionary as an ArrayList
     * @return it returns an ArrayList 
     */
    @Override
    public ArrayList<String> getDictionaryWords() {
        // todo
        ArrayList<String> text = new ArrayList<String>();
        for (int i = 0; i < I; i++) {
            text.add(Arr[i]);
        }
        return text;
    }
    /**
     * the method return number of words in the dictionary
     * @return number of words in the dictionary
     */
    @Override
    public int getNumberOfElements() {
        // todo
        return I;
    }
    /***
     * 
     * prints the words from the dictionary
     */
    public void Print() {
        for (int i = 0; i < I; i++) {
            System.out.println(Arr[i]);
        }
    }
    public String[] getArray() {
        return Arr; // Replace with array
    }
}