package com.example.shanespiess.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shane Spiess on 2/7/18.
 */

public class DataManager {
    private static DataManager ourInstance = null;
    private List<MenuCategory> mCategories = new ArrayList<>();
    private List<MenuItem> mMenuItems = new ArrayList<>();
    private HashMap<Integer,List<MenuItem>> mCategoryMenuItems = new HashMap<>();

    public static DataManager getInstance(){
        if (ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeMenuData();
        }
        return ourInstance;
    }

    public List<MenuCategory> getMenuCategories() {
        return mCategories;
    }

    public List<MenuItem> getMenuItems(Integer categoryId) {
        return mCategoryMenuItems.get(categoryId);
    }

    public MenuItem getMenuItem(int itemId) {
        MenuItem menuItem = null;

        for (MenuItem item : mMenuItems) {
            if (item.getItemId() == itemId) {
                menuItem = item;
                break;
            }
        }

        return menuItem;
    }

    public MenuCategory getMenuCategory(int categoryId) {
        MenuCategory menuCategory = null;

        for (MenuCategory category : mCategories) {
            if (category.getMenuCategoryId() == categoryId) {
                menuCategory = category;
                break;
            }
        }

        return menuCategory;
    }

    private void initializeMenuData() {
        MenuCategory sandwiches = new MenuCategory(1, "Sandwiches");
        mCategories.add(sandwiches);
        List<MenuItem> sandwichItems = new ArrayList<>();
        sandwichItems.add(new MenuItem(1,R.drawable.grilledcheese,"Grilled Cheese", sandwiches, "The best grilled cheese ever."));
        sandwichItems.add(new MenuItem(2,R.drawable.hotdog,"Hot Dog", sandwiches, "All beef Hot Dog."));
        sandwichItems.add(new MenuItem(3,R.drawable.hamburger,"Hamburger", sandwiches, "Healthier than it looks."));
        sandwichItems.add(new MenuItem(4,R.drawable.chicken,"Chicken", sandwiches, "A great chicken sandwich."));
        mCategoryMenuItems.put(sandwiches.getMenuCategoryId(), sandwichItems);
        mMenuItems.addAll(sandwichItems);

        MenuCategory salads = new MenuCategory(2, "Salads");
        mCategories.add(salads);
        List<MenuItem> saladItems = new ArrayList<>();
        saladItems.add(new MenuItem(5,R.drawable.caesar,"Caesar Salad", salads, "Just a regular Ceasar Salad."));
        saladItems.add(new MenuItem(6,R.drawable.sidesalad,"Side Salad", salads, "Not so bad."));
        mCategoryMenuItems.put(salads.getMenuCategoryId(), saladItems);
        mMenuItems.addAll(saladItems);

        MenuCategory sides = new MenuCategory(3, "Sides");
        mCategories.add(sides);
        List<MenuItem> sideItems = new ArrayList<>();
        sideItems.add(new MenuItem(7,R.drawable.frenchfries,"French Fries", sides, "Everyone loves French Fries."));
        sideItems.add(new MenuItem(8,R.drawable.bakedpotato,"Baked Potato", sides, "Good old baked potato."));
        mCategoryMenuItems.put(sides.getMenuCategoryId(), sideItems);
        mMenuItems.addAll(sideItems);
    }

    private DataManager() {}

}
