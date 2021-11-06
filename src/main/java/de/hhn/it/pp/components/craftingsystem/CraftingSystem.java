package de.hhn.it.pp.components.craftingsystem;

import com.sun.jdi.Value;
import de.hhn.it.pp.components.craftingsystem.provider.Player;
import de.hhn.it.pp.components.craftingsystem.provider.Recipe;
import de.hhn.it.pp.components.craftingsystem.provider.Item;

import java.util.List;
import java.util.Map;

public interface CraftingSystem {

   //Must-Have

   /**
    * adds an recipe to the recipeList
    *
    * @param recipe recipe to add
    */
   void addRecipe(Recipe recipe);

   /**
    * removes an recipe to the recipeList
    *
    * @param recipe recipe to add
    */
   void removeRecipe(Recipe recipe);

   /**
    * getter for craftingTime
    *
    * @param recipe recipe to get its craftingTime
    */
   Integer getCraftingTime(Recipe recipe);

   /**
    * getter for Item
    */
   void getItem();

   /**
    * getter for player
    *
    */
   void getPlayer();

   /**
    * getter for recipe
    */
   void getRecipe();

   /**
    * getter for craftingTime
    */
   void getCraftTime();

   /**
    * setter for craftingTime
    */
   void setCraftTime();

   /**
    * getter for all existing recipes
    *
    * @return List of all existing recipes
    */
   List<Recipe> getRecipeList();

   /**
    *
    */
   List<Item> getItemList();


   /**
    * getter for recipe cost
    *
    * @param recipe recipe to check cost
    * @return returns a List of recipe cost
    */
   List<String> getRecipeResourceCost(Recipe recipe);

   boolean craftingTimer(Recipe recipe);
   /**
    * crafts an item
    *
    * @param recipe     recipe to craft
    * @param playerName name of the player
    */
   void craftItem(Recipe recipe, Player playerName) throws InterruptedException;

   List getCraftingQueue();

   void setCraftingQueue(List craftingQueue);


   //Nice-To-Have

   /**
    * enchants an item
    *
    * @param playerName player who wants to enchant
    * @param item       item to enchant
    */
   void enchantItem(Player playerName, Item item);

   /**
    * enchants an item
    *
    * @param playerName player who wants to enhance
    * @param item       item to enhance
    */
   void enhanceItem(Player playerName, Item item);

   /**
    * getter for level requirement of a recipe
    *
    * @param recipe recipe to check
    */
   void getRecipeLevelReq(Recipe recipe);

   /**
    * setter for level requirement of a recipe
    *
    * @param recipe recipe to set level requirement
    */
   void setRecipeLevelReq(Recipe recipe);

}
