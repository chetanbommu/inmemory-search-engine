package service;

import java.util.*;

public class TimeBasedSearchEngine implements SearchEngine {

    private static TimeBasedSearchEngine timeBasedSearchEngine;
    private Map<String, Set<Integer>> wordToDocumentIdMapping;

    private TimeBasedSearchEngine() {
        this.wordToDocumentIdMapping = new HashMap<>();
    }

    public static TimeBasedSearchEngine getTimeBasedSearchEngineInstance() {
        if (timeBasedSearchEngine == null) {
            timeBasedSearchEngine = new TimeBasedSearchEngine();
        }
        return timeBasedSearchEngine;
    }

    @Override
    public void addWord(int id, String documentText) {
        Set<String> validWords = DocumentParser.getWords(documentText);
        for (String word : validWords) {
            Set<Integer> documentIds =
                    wordToDocumentIdMapping.getOrDefault(word, new TreeSet<>());
            documentIds.add(id);
            wordToDocumentIdMapping.put(word, documentIds);
        }
    }

    @Override
    public List<Integer> getDocumentIds(String word) {
        if (wordToDocumentIdMapping.containsKey(word)) {
            return new ArrayList<>(wordToDocumentIdMapping.get(word));
        }
        System.out.println("[Time Based Search Engine] No matching documents found");
        return new ArrayList<>();
    }
}
