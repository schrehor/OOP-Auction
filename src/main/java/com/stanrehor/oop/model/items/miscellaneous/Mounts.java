package com.stanrehor.oop.model.items.miscellaneous;

public class Mounts extends Miscellaneous {
    public Mounts(String name, int levelRequired, boolean rarity) {
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
