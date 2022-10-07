package com.stanrehor.oop.model.items.consumables;

public class Food extends Consumable {
    public Food(String name, int levelRequired, int count, String description) {
        super(name, levelRequired, count, description);
    }

    /**
     * @return popis konzumovatelnych itemov
     */
    @Override
    public String getItemDescription() {
        return getCount() + ", " + getDescription();
    }
}
