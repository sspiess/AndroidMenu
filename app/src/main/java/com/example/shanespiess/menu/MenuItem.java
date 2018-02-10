package com.example.shanespiess.menu;

/**
 * Created by Shane Spiess on 2/8/18.
 */

public final class MenuItem {
    private final int mItemId;
    private final int mImageId;
    private final String mTitle;
    private final MenuCategory mCategory;
    private final String mDescription;

    public MenuItem(Integer itemId, Integer imageId, String title,
                    MenuCategory category, String description) {
        this.mItemId = itemId;
        this.mImageId = imageId;
        this.mTitle = title;
        this.mCategory = category;
        this.mDescription = description;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public int getItemId() { return mItemId; }

    public int getImageId() { return mImageId; }

    public String getTitle() { return mTitle; }

    public String getDescription() { return mDescription; }
}

