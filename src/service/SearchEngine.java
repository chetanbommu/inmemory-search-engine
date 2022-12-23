package service;

import java.util.List;

public interface SearchEngine {
    public void addWord(int id, String documentText);
    public List<Integer> getDocumentIds(String word);
}
