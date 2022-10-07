package com.stanrehor.oop.model.items.armor;

public class Leather extends Armor {
    public Leather(String name, int levelRequired, String itemSlot, int itemLevel) {
        super(name, levelRequired, itemSlot, itemLevel);
    }

    /**
     * @return popis armoru
     */
    @Override
    public String getItemDescription() {
        return getItemLevel() + ", " + getItemSlot();
    }
}
