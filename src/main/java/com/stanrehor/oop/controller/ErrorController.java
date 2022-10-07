package com.stanrehor.oop.controller;


import com.stanrehor.oop.error_view;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * vytvori a spusti vyskakovacie okno s errorom ak k nejakemu dojde
 */
public class ErrorController {
    public static ArrayList<String> error = new ArrayList<>();
    public error_view errorView = null;

    public void errorSession(String string) {
        error.add(0,string);
        new error_view().start(new Stage());
    }

    public void SetupView(error_view errorView) {
        this.errorView = errorView;
    }
}

