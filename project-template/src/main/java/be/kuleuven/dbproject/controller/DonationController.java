package be.kuleuven.dbproject.controller;
import be.kuleuven.dbproject.ScreenFactory;
import be.kuleuven.dbproject.database.GameDb;
import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.database.EmployeeDb;
import be.kuleuven.dbproject.model.Museum;
import be.kuleuven.dbproject.database.MuseumDb;

import be.kuleuven.dbproject.view.DonationView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import be.kuleuven.dbproject.ScreenFactory;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import static java.lang.Float.parseFloat;

public class DonationController{
    //private static int currentDonationAmount;
    @FXML
    private Text textDonation;
    @FXML
    private TextField textFieldDonation;
    @FXML
    private Button btnMakeADonation;
    @FXML
    private TextField textFieldDonationsAmount;
    @FXML
    private Button btnGoBack;
    @FXML
    void initialize(){
        assert textFieldDonation != null : "fx:id=\"textDonation\" was not injected: check your FXML file 'donation.fxml'.";
        float don;

        try{
            don = employeeLoggedIn.getMuseum().getDonations();
        }
        catch (Exception e){
            don = 6789;
        }
        textFieldDonationsAmount.setText(Float.toString(don));

        btnMakeADonation.setOnAction(e -> {

            registerDonation();
            textFieldDonation.setText("");
        });
        btnGoBack.setOnAction(e-> {
            new ScreenFactory("base");
            view.stop();
        });
    }

    private DonationView view;
    private Employee employeeLoggedIn;
    private Museum model;

    public DonationController(Museum model, DonationView view, Employee employeeLoggedIn){
        this.model = model;
        this.view = view;
        this.employeeLoggedIn = employeeLoggedIn;
    }
    private void registerDonation(){
        EmployeeDb employeeDb = new EmployeeDb();
        MuseumDb museumDb = new MuseumDb();
        Museum museum = employeeLoggedIn.getMuseum();

        String ingevoerdeDonatie = textFieldDonation.getText();
        Float flDonatie = Float.valueOf(ingevoerdeDonatie);
        museum.setDonations(museum.getDonations() + flDonatie);
        museumDb.updateMuseum(museum);
        textFieldDonationsAmount.setText(String.valueOf(museum.getDonations()));

    }
    /*public void makeDonation(){
        MuseumDb museumDb = new MuseumDb();
        Museum museum = museumDb.findMuseumByLocation(model.getMuseumLocation());
        if(museumDb.find)
    }*/



    /*public DonationController(Museum model, DonationView view){
        this.model = model;
        this.view = view;
    }*/
}