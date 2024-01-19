package be.kuleuven.dbproject.controller;

import java.net.URL;
import java.util.ResourceBundle;

import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.EmployeeDb;
import be.kuleuven.dbproject.database.MuseumDb;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.model.Museum;
import be.kuleuven.dbproject.model.Register;
import be.kuleuven.dbproject.view.RegisterView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class RegisterController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchr_background;

    @FXML
    private AnchorPane anchr_right_side;

    @FXML
    private Button btn_signup;

    @FXML
    private ImageView img_background;

    @FXML
    private ChoiceBox<String> input_gender;

    @FXML
    private PasswordField input_psw;

    @FXML
    private Hyperlink link_signin;

    @FXML
    private Text txt_email;

    @FXML
    private Text txt_gender;

    @FXML
    private TextField txt_input_email;

    @FXML
    private TextField txt_input_name;

    @FXML
    private TextField txt_input_lastname;

    @FXML
    private Text txt_name;

    @FXML
    private Text txt_password;

    @FXML
    private Text txt_sign_in;

    @FXML
    private Text txt_lastname;

    @FXML
    private ChoiceBox<String> input_museum;
    @FXML
    private Text txt_museum;

    @FXML
    void initialize() {
        assert anchr_background != null : "fx:id=\"anchr_background\" was not injected: check your FXML file 'register.fxml'.";
        assert anchr_right_side != null : "fx:id=\"anchr_right_side\" was not injected: check your FXML file 'register.fxml'.";
        assert btn_signup != null : "fx:id=\"btn_signup\" was not injected: check your FXML file 'register.fxml'.";
        assert img_background != null : "fx:id=\"img_background\" was not injected: check your FXML file 'register.fxml'.";
        assert input_gender != null : "fx:id=\"input_gender\" was not injected: check your FXML file 'register.fxml'.";
        assert input_psw != null : "fx:id=\"input_psw\" was not injected: check your FXML file 'register.fxml'.";
        assert link_signin != null : "fx:id=\"link_signin\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_email != null : "fx:id=\"txt_email\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_museum != null : "fx:id=\"txt_museum\" was not injected: check your FXML file 'register.fxml'.";
        assert input_museum != null : "fx:id=\"txt_input_museumId\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_name != null : "fx:id=\"txt_name\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_password != null : "fx:id=\"txt_password\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_sign_in != null : "fx:id=\"txt_sign_in\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_lastname != null : "fx:id=\"txt_lastname\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_gender != null : "fx:id=\"txt_gender\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_email != null : "fx:id=\"txt_input_email\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_name != null : "fx:id=\"txt_input_name\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_lastname != null : "fx:id=\"txt_input_lastname\" was not injected: check your FXML file 'register.fxml'.";

        txt_input_name.textProperty().bindBidirectional(model.nameProperty());
        txt_input_lastname.textProperty().bindBidirectional(model.lastnameProperty());
        txt_input_email.textProperty().bindBidirectional(model.emailProperty());
        input_psw.textProperty().bindBidirectional(model.passwordProperty());
        input_gender.valueProperty().bindBidirectional(model.genderProperty());
        input_museum.valueProperty().bindBidirectional(model.museumLocationProperty());


        btn_signup.setOnAction(event -> register());
        link_signin.setOnAction(event -> {
            new ScreenFactory("login");
            view.stop();
        });
    }

    private Register model;
    private RegisterView view;

    public RegisterController(Register model, RegisterView view) {
        this.model = model;
        this.view = view;
    }

    public Register getModel() {
        return model;
    }

    public void setModel(Register model) {
        this.model = model;
    }

    public RegisterView getView() {
        return view;
    }

    public void setView(RegisterView view) {
        this.view = view;
    }

    private void register() {
        EmployeeDb employeeDb = new EmployeeDb();
        MuseumDb museumDb = new MuseumDb();
        if (employeeDb.findEmployeeByEmail(model.getEmail()) == null) {
            Employee addEmployee = new Employee();
            addEmployee.setName(model.getName());
            addEmployee.setLastname(model.getLastname());
            addEmployee.setEmail(model.getEmail());
            addEmployee.setPassword(model.getPassword());
            addEmployee.setGender(model.getGender());

            Museum museum = museumDb.findMuseumByLocation(model.getMuseumLocation());
            addEmployee.setMuseum(museum);

            employeeDb.createEmployee(addEmployee);

            new ScreenFactory("base", addEmployee);
            view.stop();

        } else {
            showAlert("Warning!", "We hebben al een account gevonden met dit email adres, probeer in te loggen");
        }
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}