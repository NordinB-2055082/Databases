package be.kuleuven.dbproject;

import be.kuleuven.dbproject.controller.LoginController;
import be.kuleuven.dbproject.database.*;
import be.kuleuven.dbproject.model.*;
import be.kuleuven.dbproject.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.GapContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        GameDb gameDb = new GameDb();
        ConsoleTypeDb consoleTypeDb = new ConsoleTypeDb();
        GameCopyDb gameCopyDb = new GameCopyDb();
        ClientDb clientDb = new ClientDb();
        TransactionDb transactionDb = new TransactionDb();

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

        Museum museumAntwerpen = new Museum();
        museumAntwerpen.setLocation("Antwerpen");
        museumAntwerpen.setDonations(4000.00F);
        museumAntwerpen.setName("VGHF Antwerpen");
        museumAntwerpen.setEntranceFee(5.0F);
        museumAntwerpen.setVisitorsPerYear(50000);

        museumDb.createMuseum(museumAntwerpen);

        //NOG AANPASSEN NAAR HASSELT IPV A
        Employee employeeHasselt = new Employee();
        employeeHasselt.setName("a");
        employeeHasselt.setLastname("a");
        employeeHasselt.setPassword("a");
        employeeHasselt.setMuseum(museumHasselt);
        employeeHasselt.setGender("M");
        employeeHasselt.setEmail("a");

        employeeDb.createEmployee(employeeHasselt);

        Employee employeeBrussel = new Employee();
        employeeBrussel.setName("Brussel");
        employeeBrussel.setLastname("Brussel");
        employeeBrussel.setPassword("Brussel");
        employeeBrussel.setMuseum(museumBrussel);
        employeeBrussel.setGender("M");
        employeeBrussel.setEmail("Brussel");

        employeeDb.createEmployee(employeeBrussel);

        ConsoleType snes = new ConsoleType();
        snes.setName("SNES");
        snes.setManufacturer("Nintendo");
        snes.setAddressForRepairing("ergens bij nintendo");
        snes.setReleaseDate(LocalDate.of(1993, 8, 30));
        //consoleTypeDb.createConsoleType(snes);

        ConsoleType nds = new ConsoleType();
        nds.setName("Nintendo DS");
        nds.setManufacturer("Nintendo");
        nds.setAddressForRepairing("ergens bij nintendo");
        nds.setReleaseDate(LocalDate.of(2004, 11, 21));
        //consoleTypeDb.createConsoleType(nds);

        Game marioB = new Game();
        marioB.setTitle("Super Mario Bros");
        marioB.setDescription("mooie description");
        marioB.setGenre("arcadegame");
        marioB.setAgeClassification(3);
        marioB.setPrice(60.0F);
        marioB.setDeveloper("Nintendo");
        marioB.setReleaseDate(LocalDate.of(1981, 7, 9));
        //gameDb.createGame(marioB);



        Game dk = new Game();
        dk.setTitle("Donkey Kong Country 2: Diddy's Kong Quest");
        dk.setDescription("mooie description");
        dk.setGenre("platformer");
        dk.setAgeClassification(3);
        dk.setPrice(60.0F);
        dk.setDeveloper("Rare");
        dk.setReleaseDate(LocalDate.of(1995, 7, 9));

        gameDb.createGame(dk);
        gameDb.createGame(marioB);
        consoleTypeDb.createConsoleType(nds);
        consoleTypeDb.createConsoleType(snes);

        //add games naar lijst consoletype en creeer alles
        nds.getGamesOfConsoleType().add(marioB);
        nds.getGamesOfConsoleType().add(dk);
        snes.getGamesOfConsoleType().add(marioB);
        snes.getGamesOfConsoleType().add(dk);
        marioB.getConsoleTypesOfGame().add(snes);
        marioB.getConsoleTypesOfGame().add(nds);

        System.out.println("ConsoleTypesOfGame: " + marioB.getConsoleTypesOfGame());
        System.out.println("GamesOfConsoleType: " + nds.getGamesOfConsoleType());

        GameCopy dkCopy = new GameCopy();
        dkCopy.setGame(dk);
        dkCopy.setMuseum(museumHasselt);
        dkCopy.setStatus(Status.AVAILABLE);
        gameCopyDb.createGameCopy(dkCopy);

        museumHasselt.getGameCopiesOfMuseum().add(dkCopy);

        GameCopy dkCopyAntwerpen = new GameCopy();
        dkCopyAntwerpen.setGame(dk);
        dkCopyAntwerpen.setMuseum(museumAntwerpen);
        dkCopyAntwerpen.setStatus(Status.AVAILABLE);
        gameCopyDb.createGameCopy(dkCopyAntwerpen);



        System.out.println("gameCopies van hasselt" + museumHasselt.getGameCopiesOfMuseum());

        Client klant = new Client();
        klant.setName("Laurens");
        klant.setLastname("blablabla");
        klant.setEmail("test@gmail.com");
        klant.setGender("M");
        klant.setPassword("Geheim");
        klant.setBirthdate(LocalDate.of(2002, 1, 25));
        clientDb.createClient(klant);

        Client klant2 = new Client();
        klant2.setName("Laura");
        klant2.setLastname("blablabla");
        klant2.setEmail("test@gmail.com");
        klant2.setGender("V");
        klant2.setPassword("Geheim");
        klant2.setBirthdate(LocalDate.of(2001, 2, 3));
        clientDb.createClient(klant2);


        GameCopy dkTest = new GameCopy();
        dkTest.setGame(dk);
        dkTest.setMuseum(museumBrussel);
        dkTest.setStatus(Status.LENT_OUT);
        gameCopyDb.createGameCopy(dkTest);

        /*Transaction uitleenTest = new Transaction();

        List<GameCopy> gameCopiesList = new ArrayList<>();
        gameCopiesList.add(dkTest);
        gameCopiesList.add(dkCopy);
        uitleenTest.setDate(LocalDate.of(2023, 1, 11));
        uitleenTest.setClient(klant);
        uitleenTest.setGameCopiesInTransaction(gameCopiesList);
        transactionDb.createTransaction(uitleenTest);
        */
    }
}
