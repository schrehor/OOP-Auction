package com.stanrehor.oop.model.characters;

import com.stanrehor.oop.model.items.Item;
import com.stanrehor.oop.model.items.armor.Cloth;
import com.stanrehor.oop.model.items.consumables.Elixir;
import com.stanrehor.oop.model.items.miscellaneous.QuestItems;

import java.util.ArrayList;

public class Mage extends Character {
    public Mage(String name) {
        super(name);
    }

    /**
     * setter pre inventar maga
     * @return inventar
     */
    @Override
    public ArrayList<Item> setInventory() {
        ArrayList<Item> inventoryList = new ArrayList<>();

        inventoryList.add(new Cloth("Bloodmage Hood", 30, "Head", 35));
        inventoryList.add(new Cloth("Bloodmage Robe", 30, "Chest", 35));
        inventoryList.add(new Cloth("Bloodmage Leggings", 30, "Legs", 35));
        inventoryList.add(new Cloth("Bloodmage Gloves", 30, "Hand", 35));
        inventoryList.add(new Elixir("Spectral Flask of Power", 50, 20, "Increase primary stat by 70 for one hour"));
        inventoryList.add(new QuestItems("Head Of Onyxia", 50, true));

        return inventoryList;
    }
}
