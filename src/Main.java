import exceptions.DataSetNotFoundException;
import exceptions.SearchEngineNotFoundException;
import service.ApplicationService;

public class Main {

    private static ApplicationService applicationService = ApplicationService.getApplicationServiceInstance();
    public static void main(String[] args)
            throws DataSetNotFoundException, SearchEngineNotFoundException {
        System.out.println("Welcome to Search Engine!");
        applicationService.addDataSet("fruits");
        applicationService.addDocument("fruits", "apple is a fruit");
        applicationService.addDocument("fruits", "apple apple come on");
        applicationService.addDocument("fruits", "oranges are sour");
        applicationService.addDocument("fruits", "apple is sweet");
        System.out.println("\n");
        System.out.println("Default Search Result: " + applicationService.getMatchingDocuments("fruits", "default", "apple"));;
        System.out.println("\n");
        System.out.println("Time Based Search Result: " + applicationService.getMatchingDocuments("fruits", "time", "apple"));;
        // applicationService.addDocument("oranges", "oranges are sour"); // --> throw exception
    }
}