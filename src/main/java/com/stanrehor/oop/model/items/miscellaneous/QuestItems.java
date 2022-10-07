package com.stanrehor.oop.model.items.miscellaneous;

public class QuestItems extends Miscellaneous {
    public QuestItems(String name, int levelRequired, boolean rarity) {
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
