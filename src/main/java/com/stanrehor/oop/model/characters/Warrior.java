package com.stanrehor.oop.model.characters;

import com.stanrehor.oop.model.items.Item;
import com.stanrehor.oop.model.items.armor.Leather;
import com.stanrehor.oop.model.items.consumables.Buffs;
import com.stanrehor.oop.model.items.consumables.Food;
import com.stanrehor.oop.model.items.miscellaneous.QuestItems;

import java.util.ArrayList;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    /**
     * setter pre inventar warriora
     * @return inventar
     */
    @Override
    public ArrayList<Item> setInventory() {
        ArrayList<Item> inventoryList = new ArrayList<>();

        inventoryList.add(new Leather("Wrathful Gladiator's Plate Helm", 30, "Head", 35));
        inventoryList.add(new Leather("Wrathful Gladiator's Plate Chestpiece", 30, "Chest", 35));
        inventoryList.add(new Leather("Wrathful Gladiator's Plate Legguards", 30, "Legs", 35));
        inventoryList.add(new Leather("Wrathful Gladiator's Plate Gauntlets", 30, "Hand", 35));
        inventoryList.add(new Buffs("Scroll of Strength", 10, 10, "Increase targets strength by 5 for 30 min."));
        inventoryList.add(new QuestItems("Blood of Zul'jin", 30, true));

        return inventoryList;
    }
}
