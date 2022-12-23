package service;

import exceptions.SearchEngineNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchService {
    private static SearchService searchService;
    private Map<String, SearchEngine> searchEngineConfigurationMapping;
    private DefaultSearchEngineService defaultSearchEngineService;
    private TimeBasedSearchEngine timeBasedSearchEngine;

    private SearchService() {
        this.searchEngineConfigurationMapping = new HashMap<>();
        this.defaultSearchEngineService = DefaultSearchEngineService.getSearchEngineServiceInstance();
        this.timeBasedSearchEngine = TimeBasedSearchEngine.getTimeBasedSearchEngineInstance();

        /** Configure search engines */
        this.searchEngineConfigurationMapping.put("default", defaultSearchEngineService);
        this.searchEngineConfigurationMapping.put("time", timeBasedSearchEngine);
    }

    public static SearchService getSearchServiceInstance() {
        if (searchService == null) {
            searchService = new SearchService();
        }
        return searchService;
    }

    public void addWord(int savedDocumentId, String documentText) {
        for (SearchEngine searchEngine : searchEngineConfigurationMapping.values()) {
            searchEngine.addWord(savedDocumentId, documentText);
        }
    }

    public List<Integer> getMatchingDocumentsForWord(String searchEngine, String word)
            throws SearchEngineNotFoundException {
        if (searchEngineConfigurationMapping.containsKey(searchEngine)) {
            return searchEngineConfigurationMapping.get(searchEngine).getDocumentIds(word);
        }
        throw new SearchEngineNotFoundException(searchEngine);
    }
}
