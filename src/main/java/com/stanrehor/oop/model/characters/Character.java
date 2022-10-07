package com.stanrehor.oop.model.characters;

import com.stanrehor.oop.model.Save;
import com.stanrehor.oop.model.items.Item;

import java.io.Serializable;
import java.util.ArrayList;

abstract public class Character implements Inventory, Gold, Serializable {
    private ArrayList<Item> inventory;
    private String name;
    private int gold;

    public Character(String name) {
        this.inventory = setInventory();
        this.name = name;
        this.gold = setGold();
    }

    /**
     * prideli hracovi nejake goldy pri vytvoreni postavy
     * @return 5000 goldov
     */
    @Override
    public int setGold() {
        return 5000;
    }

    /**
     * @return hracove goldy
     */
    @Override
    public int getGold() {
        return gold;
    }

    /**
     * odpocita zadanu sumu z uctu hraca
     * @param amount pocet goldov kolko odpocita
     */
    @Override
    public void pay(int amount) {
        gold -= amount;
    }

    /**
     * pripocita zadanu sumu do uctu hraca
     * @param amount pocet goldov kolko pripocita
     */
    @Override
    public void sellItem(int amount){
        gold += amount;
    }

    /**
     * getter pre inventar
     * @return invetar
     */
    @Override
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * prida item do inventara
     * @param item item ktory prida do inventara
     */
    @Override
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    /**
     * odstrani item z invetara
     * @param item ktory odstrani z inventara
     */
    @Override
    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    /**
     * serializuje hracovu postavu
     */
    public void saveCharacter() {
        Save<Character> save = new Save<>();
        save.serialize(this, "Serialized/" + name + ".txt");
    }

    /**
     * deserializuje hracovu postavu
     * @param name meno postavy
     * @return deserializovanu postavu
     */
    public static Character loadCharacter(String name) {
        Save<Character> save = new Save<>();
        return save.deserialize("Serialized/" + name + ".txt");
    }
}
