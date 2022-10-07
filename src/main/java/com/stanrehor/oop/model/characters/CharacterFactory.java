package com.stanrehor.oop.model.characters;

public class CharacterFactory{
    /**
     * Factory pattern na vytvaranie novych postav
     * @param charClass classa ktory chcem vytvorit
     * @param name meno postavy
     * @return postava
     */
    public static Character createCharacter(CharacterClass charClass, String name){
        return switch (charClass){
            case Warrior -> new Warrior(name);
            case Mage -> new Mage(name);
            case Hunter -> new Hunter(name);
        };
    }
}
