package service;

import exceptions.DataSetNotFoundException;
import exceptions.SearchEngineNotFoundException;
import model.Dataset;
import model.Document;

import java.util.List;

/** Acts as an Orchestrator. */
public class ApplicationService { //ToDo:: Think about renaming
    private static ApplicationService applicationService;
    private DataSetService dataSetService;
    private DocumentService documentService;
    private SearchService searchService;

    private ApplicationService() {
        this.dataSetService = DataSetService.getDataSetServiceInstance();
        this.documentService = DocumentService.getDocumentServiceInstance();
        this.searchService = SearchService.getSearchServiceInstance();
    }

    public static ApplicationService getApplicationServiceInstance() {
        if (applicationService == null) {
            applicationService = new ApplicationService();
        }
        return applicationService;
    }

    public void addDataSet(String dataSetName) {
        dataSetService.createDataSet(dataSetName);
    }

    public Dataset getDataSet(String dataSetName) throws DataSetNotFoundException {
        return dataSetService.getDataSet(dataSetName);
    }

    public void addDocument(String dataSetName, String text) throws DataSetNotFoundException {
        int savedDocumentId = documentService.addDocument(getDataSet(dataSetName), text);
        searchService.addWord(savedDocumentId, text);
    }

    public List<Document> getMatchingDocuments(String dataSetName, String searchEngine, String word)
            throws DataSetNotFoundException, SearchEngineNotFoundException {
        List<Integer> documentIds = searchService.getMatchingDocumentsForWord(searchEngine, word);
        return documentService.getDocuments(getDataSet(dataSetName), documentIds);
    }

}
