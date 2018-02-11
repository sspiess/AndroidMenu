package com.example.shanespiess.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shane Spiess on 2/7/18.
 */

public class DataManager {
    private static DataManager ourInstance = null;
    private HashMap<Integer,MenuCategory> mMenuCategoryMap = new HashMap<>();
    private HashMap<Integer,List<MenuItem>> mCategoryMenuItemsMap = new HashMap<>();
    private HashMap<Integer,MenuItem> mMenuItemsMap = new HashMap<>();

    public static DataManager getInstance(){
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeMenuData();
        }
        return ourInstance;
    }

    public List<MenuCategory> getMenuCategories() {
        return new ArrayList<>(mMenuCategoryMap.values());
    }

    public List<MenuItem> getMenuItems(Integer categoryId) {
        if (!mCategoryMenuItemsMap.containsKey(categoryId))
            return null;

        return mCategoryMenuItemsMap.get(categoryId);
    }

    public MenuItem getMenuItem(int itemId) {
        if (!mMenuItemsMap.containsKey(itemId))
            return null;

        return mMenuItemsMap.get(itemId);
    }

    public MenuCategory getMenuCategory(int categoryId) {
        if (!mMenuCategoryMap.containsKey(categoryId)) {
            return null;
        }
        return mMenuCategoryMap.get(categoryId);
    }

    private void initializeMenuData() {
        MenuCategory sandwiches = new MenuCategory(1, "Sandwiches");
        mMenuCategoryMap.put(1, sandwiches);
        ArrayList<MenuItem> sandwichItems = new ArrayList<>();
        MenuItem grilledCheese = new MenuItem(1,R.drawable.grilledcheese,"Grilled Cheese", sandwiches, "The best grilled cheese ever.");
        sandwichItems.add(grilledCheese);
        mMenuItemsMap.put(1, grilledCheese);
        MenuItem hotDog = new MenuItem(2,R.drawable.hotdog,"Hot Dog", sandwiches, "All beef Hot Dog.");
        mMenuItemsMap.put(2, hotDog);
        sandwichItems.add(hotDog);
        MenuItem hamburger = new MenuItem(3,R.drawable.hamburger,"Hamburger", sandwiches, "Healthier than it looks.");
        mMenuItemsMap.put(3,hamburger);
        sandwichItems.add(hamburger);
        MenuItem chicken = new MenuItem(4,R.drawable.chicken,"Chicken", sandwiches, "A great chicken sandwich.");
        mMenuItemsMap.put(4, chicken);
        sandwichItems.add(chicken);
        mCategoryMenuItemsMap.put(1, sandwichItems);

        MenuCategory salads = new MenuCategory(2, "Salads");
        mMenuCategoryMap.put(2, salads);
        ArrayList<MenuItem> saladItems = new ArrayList<>();
        MenuItem caesar = new MenuItem(5,R.drawable.caesar,"Caesar Salad", salads, "Just a regular Ceasar Salad.");
        saladItems.add(caesar);
        mMenuItemsMap.put(5, caesar);
        MenuItem side = new MenuItem(6,R.drawable.sidesalad,"Side Salad", salads, "Not so bad.");
        saladItems.add(side);
        mMenuItemsMap.put(6, side);
        mCategoryMenuItemsMap.put(2, saladItems);

        MenuCategory sides = new MenuCategory(3, "Sides");
        mMenuCategoryMap.put(3, sides);
        ArrayList<MenuItem> sideItems = new ArrayList<>();
        MenuItem frenchFries = new MenuItem(7,R.drawable.frenchfries,"French Fries", sides, "Everyone loves French Fries.");
        sideItems.add(frenchFries);
        mMenuItemsMap.put(7, frenchFries);
        MenuItem bakedPotato = new MenuItem(8,R.drawable.bakedpotato,"Baked Potato", sides, "Good old baked potato.");
        sideItems.add(bakedPotato);
        mMenuItemsMap.put(8, bakedPotato);
        mCategoryMenuItemsMap.put(3, sideItems);
    }

    private DataManager() {}

}
