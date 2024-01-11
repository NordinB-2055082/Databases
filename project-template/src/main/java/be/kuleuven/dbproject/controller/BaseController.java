package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.GameDb;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.model.Game;
import be.kuleuven.dbproject.view.BaseView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class BaseController {
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnAllGames;
    @FXML
    private Button btnDonation = new Button();
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
    void initialize(){
        assert tableAllGames != null : "fx:id=\"tableAllGames\" was not injected: check your FXML file 'base.fxml'.";

        showGames();
        btnLogOut.setOnAction(e -> {
           new ScreenFactory("login", employeeLoggedIn);
           view.stop();
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
    }

    private BaseView view;
    private Employee employeeLoggedIn;
    public BaseController(BaseView view, Employee employeeLoggedIn) {
        this.view = view;
        this.employeeLoggedIn = employeeLoggedIn;
    }


}
