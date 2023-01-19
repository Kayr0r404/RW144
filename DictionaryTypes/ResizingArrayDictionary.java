package DictionaryTypes;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

import DictionaryTypes.abstractClasses.ArrayTypeDictionary;

/**
 * 
 * @author Karabo Mahlare
 *
 */
public class ResizingArrayDictionary extends ArrayTypeDictionary implements DictionaryInterface {
    public String[] Array;
    public int counter;

    public ResizingArrayDictionary() {
        // todo
        counter = 0;
        Array = new String[5];
    }

    /* GENERAL METHODS handin 1 */
    /***
     * 
     * @param filepath location of the input file
     * @return return number of words in the dictionary
     */
    int sizeDictionary(String filepath) {
        int j = 0;
        In file = new In(filepath);
        while (file.hasNextLine()) {
            String s = file.readLine();
            if (!isWord(s)) {
                j++;
            }

        }
        return j;
    }

    /**
     * 
     * reads in a textfile and reads all the textfile contents into an array
     * 
     * @param filepath this is the location of the input file
     */
    public void CreateDictionary(String filepath) {
        // todo
        In file = new In(filepath);
        while (file.hasNextLine()) {
            String word = file.readLine();
            if (!isWord(word)) {
                if (counter >= Array.length) {
                    Array = Arrays.copyOf(Array, Array.length + 1);
                }
                Array[counter++] = word;
            }
        }
        if (Array.length != 5) {
            Array = Arrays.copyOf(Array, Array.length + 5);
        }
    }

    /**
     * looks for a word in the dictionary
     * 
     * @param word : word to be checked if it exist in the dictionary
     * @return returns true if the word exist , otherwise false
     */
    public boolean isWord(String word) {
        // todo
        for (int i = 0; i < counter; i++) {
            if (Array[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new word if does not already exist in the dictionary
     * 
     * @param word : word to be added in the dictionary
     */
    public void addNewWord(String word) {
        // todo
        if (!isWord(word)) {
            if (counter < Array.length) {
                Array[counter] = word;
                counter++;
            } else {
                Array = Arrays.copyOf(Array, Array.length * 2);
                Array[counter] = word;
                counter++;
            }
        }
    }

    /**
     * takes in a string as an argument and removes it from the dictionary, if the
     * word exist in the dictionary
     * 
     * @param word word to be removed from the dictionary
     */
    public void removeWord(String word) {
        // todo
        // first find the index of the word to be removed in the array
        int index = 0;
        for (int i = 0; i < counter; i++) {
            if (Array[i].equals(word)) {
                index = i;
                counter--;
            }
        }

        // will contain all the words from the Actual array except the word to be
        // removed
        String[] newArray = new String[Array.length - 1];
        // Copy all words into the new array from original array except the word at the
        // index
        for (int i = 0, j = 0; i < Array.length; i++) {
            // if the index is the removal element index
            if (i == index) {
                continue;
            }
            // if the index is not the removal element index
            newArray[j++] = Array[i];
        }
        Array = Arrays.copyOf(newArray, newArray.length);
        // copy back the elements from new array to a new array
        if (Array.length > 5 && counter <= (.25 * Array.length)) {
            Array = Arrays.copyOf(Array, (int) (0.5 * Array.length));
        }
        if (Array.length < 5) {
            Array = Arrays.copyOf(newArray, 5);
        }
    }

    /**
     * takes no parameter and return the words from the dictionary as an ArrayList
     * 
     * @return it returns an ArrayList
     */
    public ArrayList<String> getDictionaryWords() {
        // todo
        ArrayList<String> text = new ArrayList<String>();
        for (int i = 0; i < counter; i++) {
            text.add(Array[i]);
        }
        return text;
    }

    /**
     * the method return number of words in the dictionary
     * 
     * @return number of words in the dictionary
     */
    public int getNumberOfElements() {
        // todo
        return counter;
    }

    void print() {
        for (int i = 0; i < counter; i++) {
            System.out.println(Array[i]);
        }
    }

    public String[] getArray() {
        return Array; // Replace with array
    }

}
