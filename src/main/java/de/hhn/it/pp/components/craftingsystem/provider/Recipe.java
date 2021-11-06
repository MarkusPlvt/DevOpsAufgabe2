package de.hhn.it.pp.components.craftingsystem.provider;

import java.util.*;

public class Recipe {
 //   private List<Recipe> recipes = new ArrayList<>();  //Liste aller Rezepte
    private String recipeName;
    private Integer craftingTime;
    private HashMap<Item, Integer> recipeIngredients;  //Rezeptbestandteile
    private HashMap<Item, Integer> recipeResults;      //Rezeptergebnis

    public Recipe(String recipeName, Integer craftingTime){ //time -> millis
        this.recipeName = recipeName;
        this.craftingTime = craftingTime;

        recipeIngredients = new HashMap<>();
        recipeResults = new HashMap<>();
    }

    public void setRecipeIngredients(Item item, Integer itemAmount){
        recipeIngredients.put(item, itemAmount);
    }

    public Integer getCraftingTime(){
        return craftingTime;
    }

    public HashMap getRecipeIngredients(){
        return recipeIngredients;
    }

    public HashMap getRecipeResults(){
        return recipeResults;
    }

    public void setRecipeResults(Item item, Integer itemamount){
        recipeResults.put(item, itemamount);
    }
}
