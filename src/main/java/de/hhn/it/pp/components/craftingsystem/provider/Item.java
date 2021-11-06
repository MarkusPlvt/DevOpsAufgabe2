package de.hhn.it.pp.components.craftingsystem.provider;

public class Item {
   // private List<Item> allItems = new ArrayList<>();
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getItemName(){
        return this.name;
    }
}
