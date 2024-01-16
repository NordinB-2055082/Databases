package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.ConsoleTypeDb;
import be.kuleuven.dbproject.database.GameCopyDb;
import be.kuleuven.dbproject.database.GameDb;
import be.kuleuven.dbproject.database.TransactionDb;
import be.kuleuven.dbproject.model.*;
import be.kuleuven.dbproject.view.AddGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import java.util.List;

public class AddGameController {

    @javafx.fxml.FXML
    private TextField FieldTitle;
    @javafx.fxml.FXML
    private ChoiceBox SelectorConsole;
    @javafx.fxml.FXML
    private TextField FieldDeveloper;
    @javafx.fxml.FXML
    private DatePicker ReleaseDatePicker;
    @javafx.fxml.FXML
    private TextField FieldGenre;
    @javafx.fxml.FXML
    private TextArea FieldDescription;
    @javafx.fxml.FXML
    private TextField FieldAge;
    @javafx.fxml.FXML
    private TextField FieldPrice;
    @javafx.fxml.FXML
    private Button btnAddGame;
    @FXML
    private Button btnCancel;

    @FXML
    void initialize(){
        loadSelector();
        btnCancel.setOnAction(e -> {
            new ScreenFactory("base", employee);
            view.stop();
        });
        btnAddGame.setOnAction(e -> {
            addGame();
            new ScreenFactory("base", employee);
            view.stop();
        });
    }

    private AddGameView view;
    private Employee employee;
    public AddGameController(AddGameView view, Employee employee) {
        this.view = view;
        this.employee = employee;
    }

    private void loadSelector(){
        ConsoleTypeDb consoleTypeDb = new ConsoleTypeDb();
        ObservableList<ConsoleType> consoleTypes = FXCollections.observableList(consoleTypeDb.getAllConsoleTypes());
        SelectorConsole.setItems(consoleTypes);
        SelectorConsole.converterProperty().set(new StringConverter<ConsoleType>() {
            @Override
            public String toString(ConsoleType consoleType) {
                return (consoleType != null) ? consoleType.getName() : null;
            }

            @Override
            public ConsoleType fromString(String string) {
                // You can implement this method if needed, but for a ChoiceBox, you can usually leave it as is
                return null;
            }
        });
    }

    private void addGame(){
        GameDb gameDb = new GameDb();
        Game game;
        // check if game already exists, else adds game with new information
        try{
            game = gameDb.findGameByTitle(FieldTitle.getText()).get(0);
        }
        catch(IndexOutOfBoundsException e){
            game = new Game();
            game.setTitle(FieldTitle.getText());
            game.setDescription(FieldDescription.getText());
            game.setGenre(FieldGenre.getText());
            game.setDeveloper(FieldDeveloper.getText());
            game.setPrice(Float.parseFloat(FieldPrice.getText()));
            game.setAgeClassification(Integer.parseInt(FieldAge.getText()));
            game.setReleaseDate(ReleaseDatePicker.getValue());
            gameDb.createGame(game);
        }

        TransactionDb transactionDb = new TransactionDb();
        Transaction transaction = new Transaction();

        //Create Gamecopy
        GameCopyDb gamecopyDb = new GameCopyDb();
        GameCopy gamecopy = new GameCopy();
        gamecopy.setGame(game);
        gamecopy.setMuseum(employee.getMuseum());
        gamecopy.setStatus(Status.AVAILABLE);
        gamecopy.setTransaction(transaction);
        //add to DB
        //transactionDb.createTransaction(transaction);
        gamecopyDb.createGameCopy(gamecopy);


    }

}
