package com.stanrehor.oop.model;

import com.stanrehor.oop.model.characters.Character;
import com.stanrehor.oop.model.items.Item;

import java.io.Serializable;

public class Auction implements Serializable {
    private Item currentItem;
    private int price;

    public Auction(Item item, int price){
        currentItem = item;
        this.price = price;
    }

    /**
     * @return item s ktorym sa pracuje
     */
    public Item getItem() {
        return currentItem;
    }

    /**
     * nastavi item v aukcii
     * @param item
     */
    public void setItem(Item item) {
        this.currentItem = item;
    }

    /**
     * @return cenu akucie
     */
    public int getPrice() {
        return price;
    }
}
