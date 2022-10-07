package com.stanrehor.oop;

import com.stanrehor.oop.controller.ErrorController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class error_view extends Application {
    Label title = new Label("Error!");
    Label errorLabel = new Label("");
    Button Continue = new Button("Continue");
    Pane pane = new Pane();
    ErrorController errorController = new ErrorController();

    private void setLayout() {
        title.setLayoutX(3);
        title.setLayoutY(3);
        title.setMinWidth(0);
        title.setMinHeight(30);
        title.setFont(new Font("Calibri", 24));

        errorLabel.setText(ErrorController.error.get(0));
        errorLabel.setLayoutX(3);
        errorLabel.setLayoutY(58);
        errorLabel.setMinWidth(400);
        errorLabel.setMinHeight(62);
        errorLabel.setFont(new Font("Calibri", 14));

        Continue.setLayoutX(168);
        Continue.setLayoutY(151);
        Continue.setMinWidth(60);
        Continue.setMinHeight(30);
        Continue.setFont(new Font("Calibri", 12));
        Continue.setVisible(true);
    }
    private void registerChildren()
    {
        pane.getChildren().add(title);
        pane.getChildren().add(errorLabel);
        pane.getChildren().add(Continue);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            errorController.SetupView(this);
            primaryStage.setTitle("WoW Auctionator");
            setLayout();
            registerChildren();

            primaryStage.setScene(new Scene(pane, 400, 200));
            primaryStage.show();
            primaryStage.setOnCloseRequest(e -> Platform.exit());

        } catch(Exception e) {
            e.printStackTrace();
        }

        Continue.setOnAction(e -> {
            try {
                primaryStage.close();
            }catch(Exception e2) {
                e2.printStackTrace();
            }
        });




    }


}
