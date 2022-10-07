package com.stanrehor.oop.model.items;

import java.io.Serializable;

public class ItemInfo implements Serializable {
    private static int currentId = 1;
    private int id;
    private int requiredLevel;

    public ItemInfo(int requiredLevel){
        this.requiredLevel = requiredLevel;
        id = setId();
    }

    /**
     * setter pre ID ktore je unikatne
     * @return unikatne ID
     */
    private int setId(){
        return currentId++;
    }

    /**
     * getter na potrebny level na pouzitie itemu
     * @return otrebny level na pouzitie itemu
     */
    public int getRequiredLevel() {
        return requiredLevel;
    }
}
