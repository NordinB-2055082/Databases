package be.kuleuven.dbproject.view;

import be.kuleuven.dbproject.model.Login;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Stage {
    private Stage stage;
    private Login model;
    private Scene scene;
    private Parent root;

    public LoginView(Stage stage, Login model) {
        this.stage = stage;
        this.model = model;
    }

    public void start() {
        stage.setTitle("VGHF Museum");
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
