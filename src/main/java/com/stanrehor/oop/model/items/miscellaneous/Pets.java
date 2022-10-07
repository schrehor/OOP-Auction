package com.stanrehor.oop.model.items.miscellaneous;

public class Pets extends Miscellaneous {
    public Pets(String name, int levelRequired,  boolean rarity) {
        super(name, levelRequired, rarity);
    }

    /**
     * @return popis roznych itemov
     */
    @Override
    public String getItemDescription() {
        if (isRare())
            return "Rare";
        else
            return "Common";
    }
}
