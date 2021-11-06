package de.hhn.it.pp.components.craftingsystem.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Player {
    private Inventory inventory;
    private List<Item> playerInventory;
    private Queue<Recipe> craftingQueue;
    private String playerName;
    private int playerLevel;

    public Player(String playerName) {
        this.playerLevel = 1; //Default = 1
        this.playerName = playerName;

    }

    public List<Item> getInventory() {
        playerInventory = inventory.getInventory();
        return playerInventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCraftingQueue(Queue craftingQueue){
        this.craftingQueue = craftingQueue;
    }

    public Queue<Recipe> getCraftingQueue(){return null;};

    public Queue<Recipe> getPlayerCraftList() {
        return craftingQueue;
    }

    public void removeItem(Item item) {

    }

    public void addItem(Item item) {
        playerInventory.add(item);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerLevel(){
        return playerLevel;
    }
}
