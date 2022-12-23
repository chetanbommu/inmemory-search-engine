package service;

import exceptions.DataSetNotFoundException;
import model.Dataset;
import repository.DataSetRepository;

public class DataSetService {

    private static DataSetService dataSetService;
    private DataSetRepository dataSetRepository;

    private DataSetService() {
        this.dataSetRepository = DataSetRepository.getDataSetRepositoryInstance();
    }

    public static DataSetService getDataSetServiceInstance() {
        if (dataSetService == null) {
            dataSetService = new DataSetService();
        }
        return dataSetService;
    }

    public void createDataSet(String dataSetName) {
        dataSetRepository.createDataSet(dataSetName);
    }

    public Dataset getDataSet(String dataSetName) throws DataSetNotFoundException {
        return dataSetRepository.getDataSet(dataSetName);
    }
}
