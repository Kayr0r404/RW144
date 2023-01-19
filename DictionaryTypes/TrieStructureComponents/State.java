package DictionaryTypes.TrieStructureComponents;

import java.util.ArrayList;

public class State {
	    State [] arr;
	    boolean isEnd;
	    // Initialize your data structure here.
	    public State() {
	        this.arr = new State[26];
	    }
    private ArrayList<Edge> outgoingEdges = new ArrayList<>();

    public State(int NN, boolean accept, String wordUpUntil) {
        //todo
    }

    public void removeLink(State s, Character ch) {
        // you don't have to use this but you can if you want to
    }

    public void addLink(State s, Character ch) {
        // you don't have to use this but you can if you want to
    }
}
