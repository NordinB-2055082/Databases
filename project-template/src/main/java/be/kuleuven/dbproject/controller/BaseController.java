package be.kuleuven.dbproject.controller;

import be.kuleuven.dbproject.model.Employee;
import be.kuleuven.dbproject.view.BaseView;

public class BaseController {
    private BaseView view;
    private Employee employeeLoggedIn;

    public BaseController(BaseView view, Employee employeeLoggedIn) {
        this.view = view;
        this.employeeLoggedIn = employeeLoggedIn;
    }


}
