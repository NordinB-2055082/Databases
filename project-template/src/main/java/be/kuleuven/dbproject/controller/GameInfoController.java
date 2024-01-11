package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.view.GameInfoView;
import be.kuleuven.dbproject.model.GameInfo;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GameInfoController {
    @FXML
    private Button btnLoan;
    @FXML
    private Button btnBack;
    @FXML
    private TableView gameInformationTable;
    @FXML
    private TextArea gameDescription;
    @FXML
    private Label gameDescriptionLabel;
    @FXML
    private TableColumn tableInfo;
    @FXML
    private TableColumn tableValue;
    @FXML
    void initialize(){
        assert gameInformationTable != null: "fx:id=\"gameInformationTable\" was not injected: check your FXML file 'gameInfo.fxml'.";

        showGameInfo();
        btnLoan.setOnAction(e -> {
            //ADD LOANING ACTION HERE
        });
        btnBack.setOnAction(e -> {
            new ScreenFactory("base", employee);
            view.stop();
        });
    }

    private void showGameInfo() {
        //ADD IN SHOWING LOGIC HERE
    }

    private final GameInfo model;
    private final GameInfoView view;
    private final Employee employee;

    public GameInfoController(GameInfo model, GameInfoView view, Employee employee) {
        this.employee = employee;
        this.model = model;
        this.view = view;
    }
}
