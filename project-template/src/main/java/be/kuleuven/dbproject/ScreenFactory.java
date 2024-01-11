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
    private Stage stage;
    private Employee employee;
    private Game selectedGame;

    public ScreenFactory(String screenName) {
        this.screenName = screenName;
        stage = new Stage();
        switchScreen();
    }

    public ScreenFactory(String screenName, Employee employee) {
        this.screenName = screenName;
        this.employee = employee;
        stage = new Stage();
        switchScreen();
    }

    public ScreenFactory(String screenName, Employee employee, Game selectedGame) {
        this.screenName = screenName;
        this.employee = employee;
        this.selectedGame = selectedGame;   //Als tijd over is, een betere manier vinden om dit door te geven
        stage = new Stage();
        switchScreen();
    }

    private void switchScreen() {
        switch (screenName){
            case "login":
                showLoginScreen();
                break;

            case "register":
                showRegisterScreen();
                break;

            case "base":
                showBaseScreen();
                break;

            case "gameInfo":
                showGameInfoScreen();
                break;
        }
    }


    private void showBaseScreen() {
        try {
            BaseView baseView = new BaseView(stage);
            BaseController baseController = new BaseController(baseView, employee);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("base.fxml"));
            fxmlLoader.setController(baseController);
            Parent root = fxmlLoader.load();
            baseView.setRoot(root);
            baseView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLoginScreen() {
        try {
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

    private void showRegisterScreen() {
        try {
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

    private void showGameInfoScreen(){
        try {
            GameInfo gameInfoModel = new GameInfo();
            GameInfoView gameInfoView = new GameInfoView(stage, gameInfoModel);
            GameInfoController gameInfoController = new GameInfoController(gameInfoModel, gameInfoView, selectedGame);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("gameInfo.fxml"));
            fxmlLoader.setController(gameInfoController);
            Parent root = fxmlLoader.load();
            gameInfoView.setRoot(root);
            gameInfoView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


