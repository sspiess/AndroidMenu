package com.example.shanespiess.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuItemActivity extends AppCompatActivity {

    public static final String Menu_Item = "com.example.shanespiess.Menu.Menu_Item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menuitem);
        setSupportActionBar(toolbar);

        initializeItem();
    }

    private void initializeItem() {
        Intent intent = getIntent();
        int itemId = intent.getIntExtra(Menu_Item, 1);
        MenuItem item = DataManager.getInstance().getMenuItem(itemId);

        TextView title = findViewById(R.id.text_item_title);
        title.setText(item.getTitle());
        TextView description = findViewById(R.id.text_description);
        description.setText(item.getDescription());
        ImageView image = findViewById(R.id.image_item);
        image.setImageResource(item.getImageId());
    }

}
