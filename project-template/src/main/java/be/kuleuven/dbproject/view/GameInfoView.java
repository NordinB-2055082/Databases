package be.kuleuven.dbproject.view;

import be.kuleuven.dbproject.model.GameInfo;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class GameInfoView extends Stage {
    private Stage stage;
    private Scene scene;

    public GameInfoView(Stage stage){
        this.stage = stage;
    }

    public void start(){
        stage.setTitle("Game information");
        stage.setResizable(false);
        stage.show();
    }

    public void stop(){
        stage.close();
    }

    public void setRoot(Parent root){
        scene = new Scene(root);
        stage.setScene(scene);
    }
}