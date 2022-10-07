package com.stanrehor.oop.model.items.armor;

public class Plate extends Armor {
    public Plate(String name, int levelRequired, String itemSlot, int itemLevel) {
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
