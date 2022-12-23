package model;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private char key;
    private Trie[] child;
    private boolean isWord;
    private List<Integer> documentIds;
    private String word;

    public Trie(char key) {
        this.key = key;
        this.isWord = false;
        this.child = new Trie[26];
        this.documentIds = new ArrayList<>();
        this.word = "";
    }

    /** Marks the node as word, adds word and the document id */
    public void markWord(int documentId, String word) {
        this.word = word;
        this.isWord = true;
        this.documentIds.add(documentId);
    }

    public Trie getChild(char character) {
        int childKey = character - 'a';

        /** If already created, return child node */
        if (this.child[childKey] != null) {
            return this.child[childKey];
        }

        /** If not present, create and return */
        Trie child = new Trie(character);
        this.child[childKey] = child;
        return child;
    }

    public boolean isWord() {
        return isWord;
    }

    public String getWord() {
        return word;
    }

    public List<Integer> getDocumentIds() {
        return documentIds;
    }
}
