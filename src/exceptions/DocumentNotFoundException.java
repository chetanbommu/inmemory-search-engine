package exceptions;

public class DocumentNotFoundException extends Exception {
    public DocumentNotFoundException(int id) {
        super("Document with id : " + id + " not found");
    }
}
