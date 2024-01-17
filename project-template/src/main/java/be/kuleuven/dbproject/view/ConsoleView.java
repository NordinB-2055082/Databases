package be.kuleuven.dbproject.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConsoleView extends Stage{
    private Stage stage;
    private Scene scene;

    public ConsoleView(Stage stage){
        this.stage = stage;
    }

    public void start(){
        stage.setTitle("Add Console");
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
