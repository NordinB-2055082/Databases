package be.kuleuven.dbproject;


import be.kuleuven.dbproject.controller.*;
import be.kuleuven.dbproject.model.*;

import be.kuleuven.dbproject.view.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class ScreenFactory {
    private String screenName;
    private Employee employee;

    public ScreenFactory(String screenName) {
        this.screenName = screenName;

        switchScreen();
    }

    public ScreenFactory(String screenName, Employee employee) {
        this.screenName = screenName;
        this.employee = employee;
        switchScreen();
    }

    private void switchScreen() {
        switch (screenName){
            case "login":
                openLoginScreen();
                break;

            case "register":
                openRegisterScreen();
                break;
        }
    }

    private void openLoginScreen() {
        try {
            Stage stage = new Stage();
            Login loginModel = new Login();
            LoginView loginView = new LoginView(stage, loginModel);
            LoginController loginController = new LoginController(loginModel, loginView);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
            fxmlLoader.setController(loginController);
            Parent root = fxmlLoader.load();
            loginView.setRoot(root);
            loginView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openRegisterScreen() {
        try {
            Stage stage = new Stage();
            Register registerModel = new Register();
            RegisterView registerView = new RegisterView(stage, registerModel);
            RegisterController registerController = new RegisterController(registerModel, registerView);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
            fxmlLoader.setController(registerController);
            Parent root = fxmlLoader.load();
            registerView.setRoot(root);
            registerView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


