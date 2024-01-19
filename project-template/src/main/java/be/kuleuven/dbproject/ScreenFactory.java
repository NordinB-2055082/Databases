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
    private Game selectedGame;

    public ScreenFactory(String screenName) {
        this.screenName = screenName;

        switchScreen();
    }

    public ScreenFactory(String screenName, Employee employee) {
        this.screenName = screenName;
        this.employee = employee;
        switchScreen();
    }

    public ScreenFactory(String screenName, Employee employee, Game selectedGame) {
        this.screenName = screenName;
        this.employee = employee;
        this.selectedGame = selectedGame;   //Als tijd over is, een betere manier vinden om dit door te geven
        switchScreen();
    }

    private void switchScreen() {
        switch (screenName) {
            case "login":
                showLoginScreen();
                break;

            case "register":
                showRegisterScreen();
                break;

            case "base":
                showBaseScreen();
                break;
            case "donation":
                showDonationScreen();
            case "gameInfo":
                showGameInfoScreen();
                break;
            case "addGame":
                showAddGameScreen();
                break;
            case "console":
                showConsoleScreen();
                break;
        }
    }

    private void showAddGameScreen() {
        try {
            Stage stage = new Stage();
            AddGameView addgameview = new AddGameView(stage);
            AddGameController gameController = new AddGameController(addgameview, employee);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("addGame.fxml"));
            fxmlLoader.setController(gameController);
            Parent root = fxmlLoader.load();
            addgameview.setRoot(root);
            addgameview.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDonationScreen() {
        try {
            Stage stage = new Stage();
            Museum model = new Museum();

            DonationView donationView = new DonationView(stage);
            DonationController donationController = new DonationController(model, donationView, employee);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("donation.fxml"));
            fxmlLoader.setController(donationController);
            Parent root = fxmlLoader.load();
            donationView.setRoot(root);
            donationView.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBaseScreen() {
        try {
            Stage stage = new Stage();
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

    private void showRegisterScreen() {
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

    private void showGameInfoScreen() {
        try {
            Stage stage = new Stage();
            GameInfoView gameInfoView = new GameInfoView(stage);
            GameInfoController gameInfoController = new GameInfoController(gameInfoView, selectedGame);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("GameInfo.fxml"));
            fxmlLoader.setController(gameInfoController);
            Parent root = fxmlLoader.load();
            gameInfoView.setRoot(root);
            gameInfoView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showConsoleScreen() {
        try {
            Stage stage = new Stage();
            ConsoleView consoleView = new ConsoleView(stage);
            ConsoleController consoleController = new ConsoleController(consoleView, employee);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Console.fxml"));
            fxmlLoader.setController(consoleController);
            Parent root = fxmlLoader.load();
            consoleView.setRoot(root);
            consoleView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



