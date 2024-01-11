package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.model.Game;
import be.kuleuven.dbproject.view.GameInfoView;
import be.kuleuven.dbproject.model.GameInfo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class GameInfoController {
    @FXML
    private Button btnLoan;
    @FXML
    private Button btnBack;
    @FXML
    private TextArea gameDescription;
    @FXML
    private Label gameDescriptionLabel;
    @FXML
    private VBox dataVBox;
    @FXML
    void initialize(){

        showGameInfo();
        btnLoan.setOnAction(e -> {
            //ADD LOANING ACTION HERE
        });
        btnBack.setOnAction(e -> {
            new ScreenFactory("base");
            view.stop();
        });
    }

    private void showGameInfo() {
        //Display data on a VBox
        Label titleLabel = new Label("Title: " + selectedGame.getTitle());
        Label developerLabel = new Label("Developer: " + selectedGame.getDeveloper());
        Label genreLabel = new Label("Genre: " + selectedGame.getGenre());
        Label releaseDateLabel = new Label("Releasedate: " + selectedGame.getReleaseDate());
        Label ageLabel = new Label("Age classification: " + selectedGame.getAgeClassification());
        Label priceLabel = new Label("Price: $" + selectedGame.getPrice());

        dataVBox.getChildren().addAll(titleLabel, developerLabel, genreLabel, releaseDateLabel, ageLabel, priceLabel);

        //display description
        gameDescription.setText(selectedGame.getDescription());
    }

    private final GameInfo model;
    private final GameInfoView view;
    private Game selectedGame;

    public GameInfoController(GameInfo model, GameInfoView view, Game selectedGame) {
        this.model = model;
        this.view = view;
        this.selectedGame = selectedGame;
    }
}
