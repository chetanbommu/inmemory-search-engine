package model;

import java.util.HashMap;
import java.util.Map;

public class Dataset {

    private Map<Integer, Document> documentDataMap; // Acts as Rows

    public Dataset() {
        this.documentDataMap = new HashMap<>();
    }

    public Map<Integer, Document> getDocumentDataMap() {
        return documentDataMap;
    }
}
