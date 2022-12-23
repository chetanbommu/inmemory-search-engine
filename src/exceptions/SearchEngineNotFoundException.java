package exceptions;

public class SearchEngineNotFoundException extends Exception {
    public SearchEngineNotFoundException(String searchEngine) {
        super("No Search Engine of type: " + searchEngine + " found");
    }
}
