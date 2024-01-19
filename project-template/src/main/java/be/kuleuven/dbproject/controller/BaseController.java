package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.ConsoleTypeDb;
import be.kuleuven.dbproject.database.GameCopyDb;
import be.kuleuven.dbproject.database.GameDb;
import be.kuleuven.dbproject.database.MuseumDb;
import be.kuleuven.dbproject.model.*;
import be.kuleuven.dbproject.view.BaseView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.Console;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class BaseController {
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnDonation;
    @FXML
    private TableView<Game> tableAllGames;

    @FXML
    private TableColumn<Game, String> TableTitle;

    @FXML
    private TableColumn<Game, String> TableGenre;

    @FXML
    private TableColumn<Game, Integer> TableAge;

    @FXML
    private TableColumn<Game, Float> TablePrice;
    @FXML
    private Button btnGameSelection;
    @FXML
    private Button btnAdd;
    @FXML
    private ChoiceBox selectorConsole;
    @FXML
    private ChoiceBox selectorMuseum;
    @FXML
    void initialize(){
        assert tableAllGames != null : "fx:id=\"tableAllGames\" was not injected: check your FXML file 'base.fxml'.";

        showGames();
        btnLogOut.setOnAction(e -> {
           new ScreenFactory("login", employeeLoggedIn);
           view.stop();
        });

        btnDonation.setOnAction(e -> {
            new ScreenFactory("donation", employeeLoggedIn);
            //view.stop();
        });

        btnGameSelection.setOnAction(e -> {
            Game selectedGame = tableAllGames.getSelectionModel().getSelectedItem();
            if(selectedGame != null){
                new ScreenFactory("gameInfo", employeeLoggedIn, selectedGame);
                //view.stop();
            }
        });

        btnAdd.setOnAction(e -> {
            new ScreenFactory("addGame", employeeLoggedIn);
            view.stop();
        });
        selectorConsole.setOnAction(e -> {
            updateTable();
        });
        selectorMuseum.setOnAction(e -> {
            updateTable();
        });
    }

    private void showGames() {

        GameDb gameDb = new GameDb();
        List<Game> gameList = gameDb.findAllGames();

        ObservableList<Game> data = FXCollections.observableArrayList();
        TableTitle.setCellValueFactory(new PropertyValueFactory<Game, String>("title"));
        TableGenre.setCellValueFactory(new PropertyValueFactory<Game, String>("genre"));
        TableAge.setCellValueFactory(new PropertyValueFactory<Game, Integer>("ageClassification"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<Game, Float>("price"));
        TableTitle.setSortType(TableColumn.SortType.DESCENDING);

        data.addAll(gameList);

        tableAllGames.setItems(data);


        ConsoleTypeDb consoleTypeDb = new ConsoleTypeDb();
        ObservableList<ConsoleType> consoleTypes = FXCollections.observableList(consoleTypeDb.getAllConsoleTypes());
        selectorConsole.setItems(consoleTypes);

        MuseumDb museumDb = new MuseumDb();
        ObservableList<Museum> museums = FXCollections.observableList(museumDb.findAllMuseums());
        selectorMuseum.setItems(museums);
        selectorConsole.converterProperty().set(new StringConverter<ConsoleType>() {
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

    private BaseView view;
    private Employee employeeLoggedIn;
    public BaseController(BaseView view, Employee employeeLoggedIn) {
        this.view = view;
        this.employeeLoggedIn = employeeLoggedIn;
    }

    private void updateTable(){
        GameDb gameDb = new GameDb();
        List<Game> gameList= gameDb.findAllGames();

        //Update by console
        ConsoleType console = (ConsoleType) selectorConsole.getSelectionModel().getSelectedItem();

        if(selectorConsole.getValue() != null){
            for(int i = 0; i< gameList.size();i++){
                if(!gameList.get(i).getConsoleTypesOfGame().contains(console)){
                    gameList.remove(i);
                }
            }
        }

        GameCopyDb gameCopyDb = new GameCopyDb();
        Museum museum = (Museum) selectorMuseum.getSelectionModel().getSelectedItem();
        if(selectorMuseum.getValue() != null){
            for(int j = 0; j< gameList.size();j++){
                if(!museumContainsGame(museum, gameList.get(j))){
                    gameList.remove(j);
                    j--;
                }

            }
        }

        ObservableList<Game> data = FXCollections.observableArrayList();
        data.addAll(gameList);
        tableAllGames.setItems(data);
    }

    private boolean museumContainsGame(Museum museum, Game game){
        GameCopyDb gameCopyDb = new GameCopyDb();
        List<GameCopy> gamecopies= gameCopyDb.findGameCopyByGame(game);
        for(int i = 0; i< gamecopies.size(); i++){
            if(gamecopies.get(i).getMuseum().getName().equals(museum.getName())){
                return true;
            }
        }
        return false;
    }
}
