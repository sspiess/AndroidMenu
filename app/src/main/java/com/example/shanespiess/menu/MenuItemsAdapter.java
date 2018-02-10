package com.example.shanespiess.menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by Shane Spiess on 2/9/18.
 */

public class MenuItemsAdapter extends ArrayAdapter<MenuItem> {

    private final Activity mContext;
    private final MenuItem[] mMenuItems;

    public MenuItemsAdapter(Activity context, MenuItem[] items) {
        super(context, R.layout.list_menu_item, items);

        this.mContext = context;
        this.mMenuItems = items;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_menu_item, null,true);

        TextView viewTitle = (TextView) rowView.findViewById(R.id.text_title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_item);

        viewTitle.setText(mMenuItems[position].getTitle());
        imageView.setImageResource(mMenuItems[position].getImageId());

        return rowView;
    };

}
