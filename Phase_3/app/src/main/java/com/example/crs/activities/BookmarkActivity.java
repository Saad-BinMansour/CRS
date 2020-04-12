package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.crs.R;
import com.example.crs.database.ComputerDBHandler;
import com.example.crs.model.item.Item;
import com.example.crs.utility.CustomAdapter;

import java.util.List;

// This class handles the bookmark functionality
public class BookmarkActivity extends AppCompatActivity {
    private ListView listView;
    private ComputerDBHandler computerDBHandler;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        listView = findViewById(R.id.bookmark_listview);
        computerDBHandler = new ComputerDBHandler(this, null);
        customAdapter = new CustomAdapter(this, R.layout.product_view, computerDBHandler.getBookmarked());

        // Load all marked items from the database into the list view
        listView.setAdapter(customAdapter);
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
