package be.kuleuven.dbproject.model;

import javafx.beans.property.*;

public class Register {
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty password = new SimpleStringProperty("");
    private StringProperty name = new SimpleStringProperty("");
    private StringProperty lastname = new SimpleStringProperty("");
    private StringProperty gender = new SimpleStringProperty("");
    private StringProperty museumLocation = new SimpleStringProperty("");



    public String getMuseumLocation() {
        return museumLocation.get();
    }

    public StringProperty museumLocationProperty() {
        return museumLocation;
    }

    public void setMuseumLocation(String museumLocation) {
        this.museumLocation.set(museumLocation);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }
}
