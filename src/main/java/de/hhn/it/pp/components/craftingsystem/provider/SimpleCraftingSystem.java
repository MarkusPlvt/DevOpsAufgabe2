package de.hhn.it.pp.components.craftingsystem.provider;

import de.hhn.it.pp.components.craftingsystem.CraftingSystem;

import java.util.*;

public class SimpleCraftingSystem implements CraftingSystem {

    protected Queue<Recipe> craftingQueue;
    private List<Item> allItems;
    private List<Recipe> allRecipes;
    private boolean craftingDone;

    public SimpleCraftingSystem() {
        allRecipes = new ArrayList<>();
        allItems = new ArrayList<>();
        craftingQueue = new ArrayDeque<>();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        if (!allRecipes.contains(recipe)) {
            allRecipes.add(recipe);
            System.out.println("Recipe added successfully.");
        } else {
            System.out.println("Recipe already added.");
        }
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        for (int i = 0; i < allRecipes.size(); i++) {
            Recipe recipeSearch = allRecipes.get(i);
            if (recipeSearch == recipe) {
                allRecipes.remove(i);
                System.out.println("Recipe" + recipe.getClass().getSimpleName() + "removed.");
            }
        }
    }

    @Override
    public Integer getCraftingTime(Recipe recipe) {
        return recipe.getCraftingTime();
    }

    @Override
    public void getItem() {

    }

    @Override
    public void getPlayer() {

    }

    @Override
    public void getRecipe() {

    }

    @Override
    public void getCraftTime() {

    }

    @Override
    public void setCraftTime() {

    }

    @Override
    public List<Recipe> getRecipeList() {
        return allRecipes;
    }

    @Override
    public List<Item> getItemList() {
        return allItems;
    }

    @Override
    public List<String> getRecipeResourceCost(Recipe recipe) {
        HashMap<Item, Integer> map;
        List<String> listToPrint = new ArrayList<>();
        String toPrint;
        map = recipe.getRecipeIngredients();
        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            Item k = entry.getKey();
            Integer v = entry.getValue();
            toPrint = "" + k.getItemName() + " = " + v;
            listToPrint.add(toPrint);
        }
        return listToPrint;
    }

    @Override
    public boolean craftingTimer(Recipe recipe) {
        craftingDone = false;
        int i = recipe.getCraftingTime();

        while (i > 0) {
            System.out.println("Crafting will be finished in: " + i + " seconds.");
            try {
                i--;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Crafting canceled.");
            }
            craftingDone = true;
        }
        System.out.println("Crafting successful.");  //Callback for Player
        return craftingDone;
    }


    @Override
    public void craftItem(Recipe recipe, Player playerName) throws InterruptedException {
        //put toRemoveItems in list
        HashMap<Item, Integer> craftIngredientsMap = recipe.getRecipeIngredients();
        List<Item> craftIngredients = new ArrayList<>();
        List<String> craftIngredientsReadable = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : craftIngredientsMap.entrySet()) {
            Item k = entry.getKey();
            Integer v = entry.getValue();
            for (int i = 0; i < v; i++) {
                craftIngredients.add(k);
                craftIngredientsReadable.add(k.getItemName());
            }
        }
        System.out.println("ItemsNeedToCraft" + craftIngredientsReadable);

        //removeItems
        for (int i = 0; i < craftIngredients.size(); i++) {
            playerName.getInventory().remove(craftIngredients.get(i));
        }
        craftingQueue.add(recipe);
        System.out.println("CraftingQueueRecipesBefore: " + craftingQueue.size());
        craftingTimer(recipe);
        craftingQueue.remove(recipe);
        System.out.println("CraftingQueueRecipesAfter: " + craftingQueue.size());

        HashMap<Item, Integer> craftResultsMap = recipe.getRecipeResults();
        List<Item> craftResults = new ArrayList<>();
        List<String> craftResultsReadable = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : craftResultsMap.entrySet()) {
            Item k = entry.getKey();
            Integer v = entry.getValue();
            for (int i = 0; i < v; i++) {
                craftResults.add(k);
                craftResultsReadable.add(k.getItemName());
            }
        }
        System.out.println("ItemsCrafted" + craftResultsReadable);

        //addCraftedItemToInventory
        if (craftingDone == true) {
            for (int i = 0; i < craftResults.size(); i++) {
                playerName.getInventory().add(craftResults.get(i));
            }
        }
        System.out.println("ItemAmountPlayerInventory: " + playerName.getInventory().size());
        System.out.println("ItemInInventoryAfterCrafting: " + playerName.getInventory().get(0).getItemName());
        System.out.println("ItemInInventoryAfterCrafting: " + playerName.getInventory().get(1).getItemName());
    }

    @Override
    public List getCraftingQueue() {
        return null;
    }

    @Override
    public void setCraftingQueue(List craftingQueue) {

    }

    @Override
    public void enchantItem(Player player, Item item) {

    }

    @Override
    public void enhanceItem(Player player, Item item) {

    }

    @Override
    public void getRecipeLevelReq(Recipe recipe) {

    }

    @Override
    public void setRecipeLevelReq(Recipe recipe) {

    }
}
