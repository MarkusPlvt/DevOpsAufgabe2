package de.hhn.it.pp.components.craftingsystem.provider;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private Player player;
    private List<Item> playerInventory;

    public Inventory(Player player){
        this.player = player;
        this.playerInventory = new ArrayList<>();
    }

    public List<Item> getInventory() {
        return playerInventory;
    }

}
