package repository;

import model.Dataset;
import model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentRepository {
    private int DOCUMENT_ID = 0; // ToDo:: We can use an Id Generator here. Modify later
    private static DocumentRepository documentRepository;

    private DocumentRepository() {
    }

    public static DocumentRepository getDocumentRepositoryInstance() {
        if (documentRepository == null) {
            documentRepository = new DocumentRepository();
        }
        return documentRepository;
    }

    /** Document Service will invoke this to save on user add document command.
     * Saves Document and returns documentId */

    public int addDocument(Dataset dataset, Document document) {
        int documentId = getNewDocumentId();
        dataset.getDocumentDataMap().put(documentId, document);
        return documentId;
    }

    public Optional<Document> getDocumentById(Dataset dataset, int documentId) {
        return Optional.ofNullable(dataset.getDocumentDataMap().getOrDefault(documentId, null));
    }

    public List<Document> getDocumentsForDocumentIds(Dataset dataset, List<Integer> documentIds) {
        List<Document> documentList = new ArrayList<>();
        for (Integer documentId : documentIds) {
            getDocumentById(dataset, documentId).ifPresent(documentList::add);
        }
        return documentList;
    }

    private int getNewDocumentId() {
        DOCUMENT_ID++;
        return DOCUMENT_ID;
    }
}
