package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.ConsoleTypeDb;
import be.kuleuven.dbproject.model.ConsoleType;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.view.ConsoleView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ConsoleController {
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField consoleField;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField repairField;
    @FXML
    private DatePicker releaseDate;

    @FXML
    public void initialize() {
        btnCancel.setOnAction(e -> {
            new ScreenFactory("addGame", employee);
            view.stop();
        });
        btnAdd.setOnAction(e -> {
            addConsole();
            new ScreenFactory("addGame", employee);
            view.stop();
        });
    }

    private ConsoleView view;
    private Employee employee;

    public ConsoleController(ConsoleView view, Employee employee) {
        this.view = view;
        this.employee = employee;
    }

    private void addConsole() {
        ConsoleTypeDb consoleTypedb = new ConsoleTypeDb();
        ConsoleType consoleType = new ConsoleType();
        consoleType.setName(consoleField.getText());
        consoleType.setManufacturer(manufacturerField.getText());
        consoleType.setAddressForRepairing(repairField.getText());
        consoleType.setReleaseDate(releaseDate.getValue());
        consoleTypedb.createConsoleType(consoleType);
    }
}
