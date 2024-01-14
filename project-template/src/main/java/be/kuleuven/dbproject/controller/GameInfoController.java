package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.GameCopyDb;
import be.kuleuven.dbproject.model.*;
import be.kuleuven.dbproject.view.GameInfoView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;
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
    private TableView GameCopyTable;
    @FXML
    private TableColumn TableLocation;
    @FXML
    private TableColumn TableConsole;
    @FXML
    private TableColumn TableStatus;
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

        String consoleString = "";
        List<ConsoleType> consoleTypes = selectedGame.getConsoleTypesOfGame();
        for(int i = 0; i<consoleTypes.size(); i++){
            consoleString = consoleString + consoleTypes.get(i).getName() + " ";
        }
        Label ConsoleLabel = new Label("Console: " + consoleString);

        dataVBox.getChildren().addAll(titleLabel, developerLabel, genreLabel, releaseDateLabel, ageLabel, ConsoleLabel, priceLabel);

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

    private List<GameCopy> getGameCopies(String title){
        GameCopyDb gameCopyDb = new GameCopyDb();
        List<GameCopy> gamecopies = gameCopyDb.findGameCopyByTitle(title);
        return gamecopies;
    }
}