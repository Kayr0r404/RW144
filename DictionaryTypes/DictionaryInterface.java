package DictionaryTypes;
//import java.io.IOException;
import java.util.*;
import java.io.*;

public interface DictionaryInterface {
    void CreateDictionary(String filepath);
    boolean isWord(String word);
    void addNewWord(String word);
    void removeWord(String word);
    ArrayList<String> getDictionaryWords();
    String[] getTopNSuggestions(ArrayList<String> dictionaryWords, String word, int N);
    int getLevenshteinDistance(String wrongWord, String actualWord);
    int getNumberOfElements();
}
