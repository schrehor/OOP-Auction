package com.stanrehor.oop.model.characters;

import com.stanrehor.oop.model.items.Item;

import java.util.ArrayList;

public interface Inventory{
    ArrayList<Item> setInventory();
    ArrayList<Item> getInventory();
    void addItemToInventory(Item item);
    void removeItemFromInventory(Item item);
}
