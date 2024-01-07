package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.view.BaseView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BaseController {
    @FXML
    private Button btnLogOut;

    @FXML
    void initialize(){
        btnLogOut.setOnAction(e -> {
           new ScreenFactory("login");
           view.stop();
        });

    }

    private BaseView view;
    private Employee employeeLoggedIn;
    public BaseController(BaseView view, Employee employeeLoggedIn) {
        this.view = view;
        this.employeeLoggedIn = employeeLoggedIn;
    }


}
