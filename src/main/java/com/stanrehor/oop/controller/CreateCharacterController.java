package com.stanrehor.oop.controller;

import com.stanrehor.oop.Start;
import com.stanrehor.oop.model.characters.Character;
import com.stanrehor.oop.model.characters.CharacterClass;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.stanrehor.oop.model.characters.CharacterFactory.createCharacter;

/**
 * kontroler na vytvaranie novych uctov
 */
public class CreateCharacterController implements Initializable {
    public ChoiceBox<CharacterClass> classChoice;
    public TextField charName;


    /**
     * Vytovri postavu aku si hrac vyberie za pomoci ChoiceBoxu
     * @param event
     * @throws IOException
     */
    @FXML
    public void onActionCreateCharacter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Start.class.getResource("view/start-windows.fxml")));
        Parent root = loader.load();

        Character newCharacter =  createCharacter(classChoice.getSelectionModel().getSelectedItem(), charName.getText());

        Node source = (Node)  event.getSource();
        Stage currentStage  = (Stage) source.getScene().getWindow();
        currentStage.close();

        StartController createStartController = loader.getController();
        createStartController.goToAucionController(event, newCharacter);
    }

    /**
     * inicializuje hodnoty v ChoiceBoxe
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        classChoice.setItems(FXCollections.observableArrayList(CharacterClass.values()));
    }
}
