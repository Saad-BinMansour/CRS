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
import com.example.crs.utility.RadioButtonID;
import com.example.crs.utility.ResultProcess;

import java.util.ArrayList;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    private CustomAdapter customAdapter;
    private ComputerDBHandler computerDBHandler;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        listView = findViewById(R.id.result_listview);
        computerDBHandler = new ComputerDBHandler(this, null);


        Intent intent = getIntent();
        String searchName = Objects.requireNonNull(intent.getExtras()).getString("SearchItemsName");

        if (searchName != null) { // List items that match the search string
            customAdapter = new CustomAdapter(this, R.layout.product_view, computerDBHandler.findHandler(searchName));
        } else { // List items that matches the user preference
            int minPrice = intent.getExtras().getInt("Minimum price");
            int maxPrice = intent.getExtras().getInt("Maximum price");
            RadioButtonID useForID = RadioButtonID.getTypeById(intent.getExtras().getInt("Use for"));
            RadioButtonID matterMostID = RadioButtonID.getTypeById(intent.getExtras().getInt("Matter most"));
            boolean laptopIsChecked = intent.getExtras().getBoolean("Laptop check");
            boolean desktopIsChecked = intent.getExtras().getBoolean("Desktop check");

            ArrayList<Item> itemArrayList = ResultProcess.getResult(computerDBHandler.loadHandler(),
                    minPrice, maxPrice, useForID, matterMostID, laptopIsChecked, desktopIsChecked);

            customAdapter = new CustomAdapter(this, R.layout.product_view, itemArrayList);
        }

        listView.setAdapter(customAdapter);
    }

    public void homebutton(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void settingsButton(View view) {
        Intent intent=new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void bookmarkbutton(View view) {
        Intent intent=new Intent(this,BookmarkActivity.class);
        startActivity(intent);
    }

    // When the activity resumes notify that data is changed
    @Override
    public void onResume() {
        super.onResume();

        // Refresh activity when returns form other activity
        if (customAdapter != null) {
            customAdapter.notifyDataSetChanged();
        }
    }
}
