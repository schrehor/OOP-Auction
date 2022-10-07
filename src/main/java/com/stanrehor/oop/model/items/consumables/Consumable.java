package com.stanrehor.oop.model.items.consumables;

import com.stanrehor.oop.model.items.Item;

import static java.lang.String.valueOf;

abstract public class Consumable extends Item {
    private int count;
    private String description;


    public Consumable(String name, int levelRequired, int count, String description) {
        super(name, levelRequired);
        this.count = count;
        this.description = description;
    }

    /**
     * getter pre pocet itemov
     * @return pocet itemov ako string
     */
    public String getCount() {
        return valueOf(count);
    }

    /**
     * @return popis konzumovatelnych itemov
     */
    public String getDescription() {
        return description;
    }
}
