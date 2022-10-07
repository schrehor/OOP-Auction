package com.stanrehor.oop.model.items;

import java.io.Serializable;

import static java.lang.String.valueOf;

abstract public class Item implements Serializable, ItemDescription {
    private String name;
    private ItemInfo info;

    public Item(String name, int requiredLevel) {
        this.name = name;
        info = new ItemInfo(requiredLevel);
    }

    /**
     * getter pre meno itemu
     * @return meno itemu
     */
    public String getName() {
        return name;
    }

    /**
     * getter pre potrebny level na pouzitie itemu
     * @return popis roznych itemov
     */
    public String getReqItemLevel() {
        return valueOf(info.getRequiredLevel());
    }
}
