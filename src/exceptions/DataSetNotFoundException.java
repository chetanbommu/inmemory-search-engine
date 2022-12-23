package exceptions;

public class DataSetNotFoundException extends Exception {
    public DataSetNotFoundException(String dataSetName) {
        super(dataSetName + "data set not found");
    }
}
