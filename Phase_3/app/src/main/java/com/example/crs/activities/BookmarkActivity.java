package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.crs.R;
import com.example.crs.database.ComputerDBHandler;
import com.example.crs.model.desktop.DesktopItem;
import com.example.crs.model.item.Item;
import com.example.crs.utility.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

// This class handles the bookmark functionality
public class BookmarkActivity extends AppCompatActivity {
    private ListView listView;
    private ComputerDBHandler computerDBHandler;
    private CustomAdapter customAdapter;
    private ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        listView = findViewById(R.id.bookmark_listview);
        computerDBHandler = new ComputerDBHandler(this, null);
        itemArrayList = computerDBHandler.loadHandler();
        customAdapter = new CustomAdapter(this, R.layout.product_view, itemArrayList);

        // Load all marked items from the database into the list view
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position) instanceof DesktopItem) {
                    DesktopItem desktopItem = (DesktopItem) parent.getItemAtPosition(position);
                    Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);
                    ArrayList<Integer> ids = new ArrayList<>();
                    ids.add(desktopItem.getCpu().getId());
                    ids.add(desktopItem.getaCase().getId());
                    ids.add(desktopItem.getGpu().getId());
                    ids.add(desktopItem.getRam().getId());
                    ids.add(desktopItem.getPowerSupply().getId());
                    ids.add(desktopItem.getMotherboard().getId());
                    intent1.putExtra("DesktopID", ids);
                    startActivity(intent1);
                }
            }
        });
    }

    // opens the home page
    public void homebutton(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    // opens the settings page
    public void settingsButton(View view) {
        Intent intent =new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh activity when returns form other activity
        if (customAdapter != null) {
            customAdapter = new CustomAdapter(this, R.layout.product_view, computerDBHandler.getBookmarked());
            listView.setAdapter(customAdapter);
        }
    }
}
