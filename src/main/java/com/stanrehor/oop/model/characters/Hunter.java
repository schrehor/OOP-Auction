package com.stanrehor.oop.model.characters;

import com.stanrehor.oop.model.items.Item;
import com.stanrehor.oop.model.items.armor.Cloth;
import com.stanrehor.oop.model.items.armor.Leather;
import com.stanrehor.oop.model.items.consumables.Elixir;
import com.stanrehor.oop.model.items.consumables.Food;
import com.stanrehor.oop.model.items.miscellaneous.QuestItems;

import java.util.ArrayList;

public class Hunter extends Character {
    public Hunter(String name) {
        super(name);
    }

    /**
     * setter pre inventar huntera
     * @return inventar
     */
    @Override
    public ArrayList<Item> setInventory() {
        ArrayList<Item> inventoryList = new ArrayList<>();

        inventoryList.add(new Leather("Helm of Hellfire's Protector", 40, "Head", 40));
        inventoryList.add(new Leather("Chest of Hellfire's Protector", 40, "Chest", 40));
        inventoryList.add(new Leather("Leggings of Hellfire's Protector", 40, "Legs", 40));
        inventoryList.add(new Leather("Gauntlets of Hellfire's Protector", 40, "Hand", 40));
        inventoryList.add(new Food("Crown Roast Aspic", 50, 100, "Restore 1000 health and mana"));
        inventoryList.add(new QuestItems("Blood of Zul'jin", 30, true));

        return inventoryList;
    }
}
