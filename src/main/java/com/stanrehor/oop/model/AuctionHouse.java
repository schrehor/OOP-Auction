package com.stanrehor.oop.model;

import com.stanrehor.oop.model.items.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class AuctionHouse implements Serializable {
    private ArrayList<Auction> auctions = new ArrayList<>();

    /**
     * ulozi stav aukcie
     */
    public void saveAuctionHouse() {
        Save<AuctionHouse> save = new Save<>();
        save.serialize(this,"Serialized/Auction.txt");
    }

    /**
     * @return nacita auckiu
     */
    public static AuctionHouse loadAuctionHouse(){
        Save<AuctionHouse> save = new Save<>();
        return save.deserialize("Serialized/Auction.txt");
    }

    /**
     * getter na aukcie
     */
    public ArrayList<Auction> getAuctions() {
        return auctions;
    }

    /**
     * prida aukciu do zoznamu aukcii
     * @param auction aukcia ktora sa prida do zoznamu aukcii
     */
    public void addAuctions(Auction auction) {
        auctions.add(auction);
    }

    /**
     * odstrani aukciu zo zoznamu
     * @param auction aukcia ktora sa odstranu zo zoznamu aukcii
     */
    public void removeAuction(Auction auction) {
        auctions.remove(auction);
    }
}
