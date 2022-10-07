package com.stanrehor.oop.model.items.miscellaneous;

import com.stanrehor.oop.model.items.Item;

abstract public class Miscellaneous extends Item {
    private boolean rare;

    public Miscellaneous(String name, int levelRequired, boolean rarity) {
        super(name, levelRequired);
        this.rare = rarity;
    }

    /**
     * @return raritu itemov
     */
    public boolean isRare() {
        return rare;
    }
}
