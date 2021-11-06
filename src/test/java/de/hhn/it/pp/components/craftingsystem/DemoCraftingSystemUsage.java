package de.hhn.it.pp.components.craftingsystem;

import de.hhn.it.pp.components.craftingsystem.provider.*;

public class DemoCraftingSystemUsage {
    public static void main(String[] args) throws InterruptedException {

        //create System
        SimpleCraftingSystem simpleCraftingSystem = new SimpleCraftingSystem();

        //create Player
        Player testPlayer1 = new Player("TestPlayer");

        //create Inventory for Player
        Inventory testInventory1 = new Inventory(testPlayer1);

        //add Inventory to Player
        testPlayer1.setInventory(testInventory1);

        //add Items to the Inventory
        System.out.println("Leeres Inventar: Itemvalue ");
        System.out.println(testPlayer1.getInventory().size());
   //     testPlayer1.getInventory().add(BasicResources.IRON);
        System.out.println("Inventar: Itemvalue ");
        System.out.println(testPlayer1.getInventory().size());
        //testInventory1.getInventory().add(BasicResources.STONE);




        //Items hinzufügen
        Item wood = new Item("Wood");
        System.out.println("Added Item " + wood.getItemName() + " to the Game.");
        Item iron = new Item("Iron");
        System.out.println("Added Item " + iron.getItemName() + " to the Game.");
        Item leather = new Item("Leather");
        System.out.println("Added Item " + leather.getItemName() + " to the Game.");
        Item coal = new Item("Coal");
        System.out.println("Added Item " + coal.getItemName() + " to the Game.");
        Item stone = new Item("Stone");
        System.out.println("Added Item " + stone.getItemName() + " to the Game.");
        Item ash = new Item("Ash");
        System.out.println("Added Item " + ash.getItemName() + " to the Game.");
        Item sword = new Item("Sword");
        System.out.println("Added Item " + sword.getItemName() + " to the Game.");
        Item pickaxe = new Item("Sword");
        System.out.println("Added Item " + sword.getItemName() + " to the Game.");

        //add items to inventory
        testPlayer1.getInventory().add(wood);
        System.out.println("Added " + wood.getItemName() + " to inventory.");
        testPlayer1.getInventory().add(wood);
        System.out.println("Added " + wood.getItemName() + " to inventory.");
        testPlayer1.getInventory().add(iron);
        System.out.println("Added " + iron.getItemName() + " to inventory.");
        testPlayer1.getInventory().add(wood);
        System.out.println("Added " + wood.getItemName() + " to inventory.");
        testPlayer1.getInventory().add(wood);
        System.out.println("Added " + wood.getItemName() + " to inventory.");
        testPlayer1.getInventory().add(iron);
        System.out.println("Added " + iron.getItemName() + " to inventory.");

        simpleCraftingSystem.getItemList().add(wood);
        simpleCraftingSystem.getItemList().add(iron);
        simpleCraftingSystem.getItemList().add(leather);
        simpleCraftingSystem.getItemList().add(coal);
        simpleCraftingSystem.getItemList().add(stone);
        simpleCraftingSystem.getItemList().add(ash);
        simpleCraftingSystem.getItemList().add(sword);
        simpleCraftingSystem.getItemList().add(pickaxe);
        System.out.println("ItemsInTheGame: " + simpleCraftingSystem.getItemList().size());

        System.out.println("InventoryItemsBeforeCrafting: " + testPlayer1.getInventory().size());
        //create Recipe + add Recipe to RecipeList
        Recipe testRecipe = new Recipe("TestRecipe", 10);
        testRecipe.setRecipeIngredients(wood, 2);
        testRecipe.setRecipeIngredients(iron, 1);
        testRecipe.setRecipeResults(sword, 1);
        testRecipe.setRecipeResults(ash, 1);
        simpleCraftingSystem.addRecipe(testRecipe);

        Recipe testRecipe2 = new Recipe("TestRecipe2", 10);
        testRecipe2.setRecipeIngredients(wood, 2);
        testRecipe2.setRecipeIngredients(iron, 1);
        testRecipe2.setRecipeResults(pickaxe, 1);
        testRecipe2.setRecipeResults(ash, 1);
        simpleCraftingSystem.addRecipe(testRecipe2);

        System.out.println("Recipes: " + simpleCraftingSystem.getRecipeList().size());
        System.out.println("RecipeCost: " + simpleCraftingSystem.getRecipeResourceCost(testRecipe));

        simpleCraftingSystem.craftItem(testRecipe, testPlayer1);
        simpleCraftingSystem.craftItem(testRecipe2, testPlayer1);


  /**
        //show all available recipes
        simpleCraftingSystem.getRecipeList();

        //show cost of recipe
        simpleCraftingSystem.getRecipeResourceCost(testRecipe);

        //show craftingQueue of player
        testPlayer1.getPlayerCraftList();

        //player craft item
        simpleCraftingSystem.craftItem(testRecipe, testPlayer1);

        //
 */
    }
}
