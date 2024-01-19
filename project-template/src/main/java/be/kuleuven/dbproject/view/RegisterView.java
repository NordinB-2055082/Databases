package be.kuleuven.dbproject.view;

import be.kuleuven.dbproject.model.Register;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RegisterView extends Stage {

    private Stage stage;
    private Register registerModel;
    private Scene scene;

    public RegisterView(Stage stage, Register registerModel) {
        this.stage = stage;
        this.registerModel = registerModel;
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
