package be.kuleuven.dbproject;

import be.kuleuven.dbproject.controller.LoginController;
import be.kuleuven.dbproject.database.EmployeeDb;
import be.kuleuven.dbproject.database.MuseumDb;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.model.Login;
import be.kuleuven.dbproject.model.Museum;
import be.kuleuven.dbproject.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * DB Taak 2022-2023: De Vrolijke Zweters
 * Zie https://kuleuven-diepenbeek.github.io/db-course/extra/project/ voor opgave details
 *
 * Deze code is slechts een quick-start om je op weg te helpen met de integratie van JavaFX tabellen en data!
 * Zie README.md voor meer informatie.
 */
public class ProjectMain extends Application {

    private static Stage rootStage;

    public static Stage getRootStage() {
        return rootStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        makeSomeRecords();
        Login model = new Login();
        LoginView view = new LoginView(stage, model);
        LoginController controller = new LoginController(model, view);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();

        view.setRoot(root);
        view.start();
    }

    public static void main(String[] args) {
        launch();
    }

    private void makeSomeRecords(){
        MuseumDb museumDb = new MuseumDb();
        EmployeeDb employeeDb = new EmployeeDb();

        Museum museumHasselt = new Museum();
        museumHasselt.setLocation("Hasselt");
        museumHasselt.setDonations(2000.00F);
        museumHasselt.setName("VGHF Hasselt");
        museumHasselt.setEntranceFee(5.0F);
        museumHasselt.setVisitorsPerYear(20000);

        museumDb.createMuseum(museumHasselt);

        Museum museumBrussel = new Museum();
        museumBrussel.setLocation("Brussel");
        museumBrussel.setDonations(4000.00F);
        museumBrussel.setName("VGHF Brussel");
        museumBrussel.setEntranceFee(5.0F);
        museumBrussel.setVisitorsPerYear(60000);

        museumDb.createMuseum(museumBrussel);

        Employee employeeHasselt = new Employee();
        employeeHasselt.setName("hasselt");
        employeeHasselt.setLastname("hasselt");
        employeeHasselt.setPassword("hasselt");
        employeeHasselt.setMuseum(museumHasselt);
        employeeHasselt.setGender("M");
        employeeHasselt.setEmail("hasselt");

        employeeDb.createEmployee(employeeHasselt);

        Employee employeeBrussel = new Employee();
        employeeBrussel.setName("Brussel");
        employeeBrussel.setLastname("Brussel");
        employeeBrussel.setPassword("Brussel");
        employeeBrussel.setMuseum(museumBrussel);
        employeeBrussel.setGender("M");
        employeeBrussel.setEmail("Brussel");

        employeeDb.createEmployee(employeeBrussel);


    }
}
