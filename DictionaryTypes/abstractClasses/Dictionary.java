package DictionaryTypes.abstractClasses;
import java.util.*;

public abstract class Dictionary {
	/**
	 * This method return an array of Strings, which are top suggestion of words closely to the word given
	 * @param dictionaryWords an input ArrayList of string objects, which contains all the words in the dictionary
	 * @param word : identifies a misspelt word for which you must find the N closest matching words present in the dictionary
	 * @param N number of words closest to the wrongword found in the ArrayList dictionarywords
	 * @ return return an array of string of size N containing 
	 */
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
    /**
     * The method use Levenshtein distace to calculate number of edits between two Strings
     * @param wrongWord misspelt which we want to compare to an actualword
     * @param actualWord correctly spelt word in the dictionary
     * @return the number of edits needed to change the wrongword into an actualword
     */
    public int getLevenshteinDistance(String wrongWord, String actualWord) {
    	// todo
        int dis = 0; // store difference
        int counter = 0; // count different characters
        if (wrongWord.length() == 0) {
            dis = actualWord.length();
        }
        if (actualWord.length() == 0) {
            dis = wrongWord.length();
        }
        if (actualWord.length() == wrongWord.length()) {
            for (int i = 0; i < actualWord.length(); i++) {
                if (wrongWord.charAt(i) != actualWord.charAt(i)) {
                    counter++;

                }
            }
            dis = counter;
            
        }
        if (wrongWord.length() > actualWord.length()) {
            for (int i = 0; i < actualWord.length(); i++) {
                if (wrongWord.charAt(i) != actualWord.charAt(i)) {
                    counter++;
                }
            }
            dis = counter + (wrongWord.length() - actualWord.length());
           
        }
        if (actualWord.length() > wrongWord.length()) {
            for (int i = 0; i < wrongWord.length(); i++) {
                if (wrongWord.charAt(i) != actualWord.charAt(i)) {
                    counter += 1;
                }
            }
            dis = counter + (actualWord.length() - wrongWord.length());
        }

        return dis;
    }
    
}
