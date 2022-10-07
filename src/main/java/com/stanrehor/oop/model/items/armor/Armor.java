package com.stanrehor.oop.model.items.armor;

import com.stanrehor.oop.model.items.Item;

import static java.lang.String.valueOf;

abstract public class Armor extends Item {
    private String itemSlot;
    private int itemLevel;

    public Armor(String name, int levelRequired, String itemSlot, int itemLevel) {
        super(name, levelRequired);
        this.itemSlot = itemSlot;
        this.itemLevel = itemLevel;
    }

    /**
     * getter na item slot
     * @return item slot
     */
    public String getItemSlot() {
        return itemSlot;
    }

    /**
     * getter na itemlevel itemu
     * @return item level itemu
     */
    public String getItemLevel() {
        return valueOf(itemLevel);
    }
}
