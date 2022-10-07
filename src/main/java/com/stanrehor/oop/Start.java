package com.stanrehor.oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Start extends Application {

    /**
     * spusti program
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(Start.class.getResource("view/start-windows.fxml")));
        Scene scene = new Scene(fxmlLoader, 406, 478);
        stage.setTitle("WoW Auctionator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}