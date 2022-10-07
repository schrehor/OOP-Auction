package com.stanrehor.oop.controller;

import com.stanrehor.oop.exception.NoSavedDataException;
import com.stanrehor.oop.exception.NotEnoughtGoldException;
import com.stanrehor.oop.exception.WrongInput;
import com.stanrehor.oop.model.Auction;
import com.stanrehor.oop.model.AuctionHouse;
import com.stanrehor.oop.model.characters.Character;
import com.stanrehor.oop.model.items.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static com.stanrehor.oop.model.AuctionHouse.loadAuctionHouse;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * kontroler na pracu s aukciou
 */
public class AuctionController implements Initializable {
    public TableView<Item> tableInventory;
    public TableView<Auction> tableAuction;
    public TableColumn<Item, String> nameInv;
    public TableColumn<Item, String> descInv;
    public TableColumn<Item, String> levelInv;
    public TableColumn<Auction, String> nameAuc;
    public TableColumn<Auction, String> levelAuc;
    public TableColumn<Auction, String> descAuc;
    public TableColumn price;
    public TextField priceField;
    private Character character;
    private AuctionHouse auctionHouse;
    public Label charGold;

    /**
     * prenesie hraca z jedneho okna do druheho a vypise jeho inventar v TableView
     * @param character prihlaseny hrac
     */
    public void getCharInventoryDisplay(Character character){
        this.character = character;

        charGold.setText(valueOf(character.getGold()));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(character.getInventory());
        nameInv.setCellValueFactory(new PropertyValueFactory<>("name"));
        levelInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReqItemLevel()));
        descInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItemDescription()));
        tableInventory.setItems(itemObservableList);
    }


    /**
     * inicializuje akciu, najprv sa snazi nacitat ulozene data, ak neexistuju tak nic nevykona
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            auctionHouse = loadAuctionHouse();

            if (auctionHouse == null){
                throw new NoSavedDataException("You don't have any saved data.");
            }

            ObservableList<Auction> auctionObservableList = FXCollections.observableArrayList(auctionHouse.getAuctions());
            nameAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getName()));
            levelAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getReqItemLevel()));
            descAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getItemDescription()));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));
            tableAuction.setItems(auctionObservableList);
        } catch (NoSavedDataException e) {
            auctionHouse = new AuctionHouse();
        }
    }

    /**
     * hrac preda item zo svojho inventara do aukcie a pripocita goldy za ktore item predal
     * @param event
     */
    public void sellItem(ActionEvent event) {
        if (tableInventory.getSelectionModel().getSelectedItem() != null && !priceField.getText().trim().isEmpty()){
            if (!priceField.getText().toString().matches("\\d+")){
                try {
                    throw new WrongInput("Wrong input type. Use numbers only!");
                } catch (WrongInput e) {
                        ErrorController errorController = new ErrorController();
                        errorController.errorSession(valueOf(e));
                }
                return;
            }

            Item selectedItem = tableInventory.getSelectionModel().getSelectedItem();
            character.removeItemFromInventory(selectedItem);
            auctionHouse.addAuctions(new Auction(selectedItem, parseInt(priceField.getText())));
            character.sellItem(parseInt(priceField.getText()));
            update();
        }
    }

    /**
     * hrac kupi item z aukcie a prida si ho do inventaru
     * @param event
     */
    public void buyItem(ActionEvent event) {
        if (tableAuction.getSelectionModel().getSelectedItem() != null)
        {
            Auction selectedAuction = tableAuction.getSelectionModel().getSelectedItem();

            if (character.getGold() - selectedAuction.getPrice() <= 0){
                try {
                    throw new NotEnoughtGoldException("You dont have enough gold to buy this item");
                } catch (NotEnoughtGoldException e) {
                    ErrorController errorController = new ErrorController();
                    errorController.errorSession(valueOf(e));
                }
                return;
            }

            auctionHouse.removeAuction(selectedAuction);
            character.addItemToInventory(selectedAuction.getItem());
            character.pay(selectedAuction.getPrice());
            update();
        }
    }

    /**
     * po zmene stavu inventara alebo aukcie nanovo vypise ich stav a ulozi stav aukcie do suboru
     */
    public void update() {
        ObservableList<Auction> auctionObservableList = FXCollections.observableArrayList(auctionHouse.getAuctions());
        nameAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getName()));
        levelAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getReqItemLevel()));
        descAuc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItem().getItemDescription()));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableAuction.setItems(auctionObservableList);

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(character.getInventory());
        nameInv.setCellValueFactory(new PropertyValueFactory<>("name"));
        levelInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReqItemLevel()));
        descInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getItemDescription()));
        tableInventory.setItems(itemObservableList);

        charGold.setText(valueOf(character.getGold()));
        auctionHouse.saveAuctionHouse();
    }

    /**
     * ulozi hracovi postavu
     * @param event
     */
    public void saveCharacter(ActionEvent event) {
        character.saveCharacter();
    }
}
