package com.example.shanespiess.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MenuItemsActivity extends AppCompatActivity {

    public static final String Menu_Category = "com.example.shanespiess.Menu.Menu_Category";
    private MenuItem[] mMenuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menuitems);
        setSupportActionBar(toolbar);

        initializeItems();
    }

    private void initializeItems() {
        Intent intent = getIntent();
        int categoryId = intent.getIntExtra(Menu_Category, 1);
        DataManager data = DataManager.getInstance();
        List<MenuItem> items = data.getMenuItems(categoryId);
        mMenuItems = items.toArray(new MenuItem[items.size()]);
        MenuCategory category = data.getMenuCategory(categoryId);
        this.setTitle(category.getTitle());

        MenuItemsAdapter adapter = new MenuItemsAdapter(this, this.mMenuItems);
        ListView viewItems = (ListView) findViewById(R.id.list_menu_items);
        viewItems.setAdapter(adapter);

        viewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MenuItemsActivity.this, MenuItemActivity.class);
                MenuItem item = mMenuItems[i];
                intent.putExtra(MenuItemActivity.Menu_Item, item.getItemId());
                startActivity(intent);
            }
        });

    }

}
