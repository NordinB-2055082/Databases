package be.kuleuven.dbproject.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AllGamesView extends Stage {

    private Stage stage;
    private Scene scene;
    public AllGamesView(Stage stage) {this.stage = stage;}

    public void start() {
        stage.setTitle("All the games in our entire collection of the community:");
        stage.setResizable(false);
        stage.show();
    }
    public void stop() {
        stage.close();
    }
    public void setRoot(Parent root) {
        scene = new Scene(root);
        stage.setScene(scene);
    }

}
