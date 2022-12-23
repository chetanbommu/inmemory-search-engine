package service;

import exceptions.DocumentNotFoundException;
import model.Dataset;
import model.Document;
import repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

public class DocumentService {
    private DocumentRepository documentRepository;
    private static DocumentService documentService;

    public DocumentService() {
        this.documentRepository = DocumentRepository.getDocumentRepositoryInstance();
    }

    public static DocumentService getDocumentServiceInstance() {
        if (documentService == null) {
            documentService = new DocumentService();
        }
        return documentService;
    }

    public int addDocument(Dataset dataset, String text) {
        Document document = new Document(text);
        return documentRepository.addDocument(dataset, document);
    }

    public Document getDocumentById(Dataset dataset, int documentId) throws DocumentNotFoundException {
        Optional<Document> documentOptional = documentRepository.getDocumentById(dataset, documentId);
        if (documentOptional.isPresent()) {
            return documentOptional.get();
        }
        throw new DocumentNotFoundException(documentId);
    }

    public List<Document> getDocuments(Dataset dataset, List<Integer> documentIds) {
        return documentRepository.getDocumentsForDocumentIds(dataset, documentIds);
    }
}
