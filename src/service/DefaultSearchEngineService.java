package service;

import model.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DefaultSearchEngineService implements SearchEngine {

    private Trie root;
    private static DefaultSearchEngineService defaultSearchEngineService;

    public DefaultSearchEngineService() {
        this.root = new Trie('*');
    }

    public static DefaultSearchEngineService getSearchEngineServiceInstance() {
        if (defaultSearchEngineService == null) {
            defaultSearchEngineService = new DefaultSearchEngineService();
        }
        return defaultSearchEngineService;
    }

    @Override
    public void addWord(int id, String documentText) {
        Set<String> validWords = DocumentParser.getWords(documentText);
        for (String word : validWords) {
            addWordToTrie(id, word);
        }
    }

    public void addWordToTrie(int id, String word) {
        char[] charArray = word.toCharArray();
        Trie temp = root;
        for (int index = 0; index < word.length(); index++) {
            temp = temp.getChild(charArray[index]);
        }
        temp.markWord(id, word);
    }

    @Override
    public List<Integer> getDocumentIds(String word) {
        Trie temp = root;
        char[] charArray = word.toCharArray();
        for (int index = 0; index < word.length(); index++) {
            temp = temp.getChild(charArray[index]);
        }

        if (temp.isWord() && temp.getWord().equals(word)) { // ToDo :: 2nd check can be avoided after testing once
            return temp.getDocumentIds();
        }
        System.out.println("[Default Search Engine] No matching documents found");
        return new ArrayList<>();
    }
}
