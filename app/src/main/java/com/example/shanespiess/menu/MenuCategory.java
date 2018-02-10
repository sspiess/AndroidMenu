package com.example.shanespiess.menu;

/**
 * Created by Shane Spiess on 2/7/18.
 */

public final class MenuCategory {
    private final int mMenuCategoryId;
    private final String mTitle;

    public MenuCategory(int categoryId, String title) {
        this.mMenuCategoryId = categoryId;
        this.mTitle = title;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public int getMenuCategoryId() { return mMenuCategoryId; }

    public String getTitle() { return mTitle; }
}
