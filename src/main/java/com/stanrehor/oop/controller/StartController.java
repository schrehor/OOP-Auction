package com.stanrehor.oop.controller;

import com.stanrehor.oop.Start;
import com.stanrehor.oop.exception.NoSavedDataException;
import com.stanrehor.oop.model.characters.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.stanrehor.oop.model.characters.Character.loadCharacter;
import static java.lang.String.valueOf;

/**
 * kontroler na inicializaciu projektu
 */
public class StartController {
    public TextField loginField;

    /**
     * prepne scenu na scenu aukcie
     * @param event
     * @param character
     * @throws IOException
     */
    public void goToAucionController(ActionEvent event, Character character) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Start.class.getResource("view/auctionhouse.fxml")));
        Parent root = loader.load();

        AuctionController auctionController = loader.getController();
        auctionController.getCharInventoryDisplay(character);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("WoW Auctionator");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * prihlasi pouzivatela podla zadaneho mena
     * @param event
     */
    @FXML
    protected void onClickSignIn(ActionEvent event) {
        try {
            Character character = loadCharacter(loginField.getText());
            if (character == null){
                throw new NoSavedDataException("There is no account with this name");
            }

            goToAucionController(event, character);

        } catch (NoSavedDataException e){
            ErrorController errorController = new ErrorController();
            errorController.errorSession(valueOf(e));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registruje pouzivatela
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onClickRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Start.class.getResource("view/create-account.fxml")));
        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("WoW Auctionator");
        stage.setScene(scene);
        stage.show();
    }
}