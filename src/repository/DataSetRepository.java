package repository;

import exceptions.DataSetNotFoundException;
import model.Dataset;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataSetRepository {
    private static DataSetRepository dataSetRepository;

    private Map<String, Dataset> datasetMap;

    private DataSetRepository() {
        this.datasetMap = new HashMap<>();
    }

    public static DataSetRepository getDataSetRepositoryInstance() {
        if (dataSetRepository == null) {
            dataSetRepository = new DataSetRepository();
        }
        return dataSetRepository;
    }

    public void createDataSet(String dataSetName) {
        if (Objects.isNull(dataSetName) || "".equals(dataSetName)) {
            System.out.println("[ERROR] Can't add DataSet as it is null");
            return;
        }

        if (datasetMap.containsKey(dataSetName)) {
            System.out.println("[ERROR] Can't add DataSet as it is already present!"); // ToDo:: Add User Defined Exception
            return;
        }

        this.datasetMap.put(dataSetName, new Dataset());
        System.out.println("[SUCCESS] " + dataSetName + " dataSet is created");
    }

    public Dataset getDataSet(String dataSetName) throws DataSetNotFoundException {
        if (datasetMap.containsKey(dataSetName)) {
            return this.datasetMap.get(dataSetName);
        }
        throw new DataSetNotFoundException(dataSetName);
    }
}
