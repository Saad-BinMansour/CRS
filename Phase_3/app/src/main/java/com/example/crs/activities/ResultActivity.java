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
import com.example.crs.utility.RadioButtonID;
import com.example.crs.utility.ResultProcess;

import java.util.ArrayList;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    private CustomAdapter customAdapter;
    private ComputerDBHandler computerDBHandler;
    private ListView listView;
    private ListView innerListView;
    private ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        listView = findViewById(R.id.result_listview);
        computerDBHandler = new ComputerDBHandler(this, null);

        Intent intent = getIntent();
        String searchName = Objects.requireNonNull(intent.getExtras()).getString("SearchItemsName");
        ArrayList<Integer> ids = intent.getExtras().getIntegerArrayList("DesktopID");

        if (searchName != null) { // List items that match the search string
            customAdapter = new CustomAdapter(this, R.layout.product_view, computerDBHandler.findHandler(searchName));
        } else if (ids != null) { // List items that matches the user preference
            itemArrayList = new ArrayList<>();
            for (Integer id : ids) {
                itemArrayList.add(computerDBHandler.findHandler(id));
            }
            customAdapter = new CustomAdapter(this, R.layout.product_view, itemArrayList);
        } else {
            int minPrice = intent.getExtras().getInt("Minimum price");
            int maxPrice = intent.getExtras().getInt("Maximum price");
            RadioButtonID useForID = RadioButtonID.getTypeById(intent.getExtras().getInt("Use for"));
            RadioButtonID matterMostID = RadioButtonID.getTypeById(intent.getExtras().getInt("Matter most"));
            boolean laptopIsChecked = intent.getExtras().getBoolean("Laptop check");
            boolean desktopIsChecked = intent.getExtras().getBoolean("Desktop check");

            itemArrayList = ResultProcess.getResult(computerDBHandler.loadHandler(),
                    minPrice, maxPrice, useForID, matterMostID, laptopIsChecked, desktopIsChecked);

            customAdapter = new CustomAdapter(this, R.layout.product_view, itemArrayList);
        }

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position) instanceof DesktopItem) {
                    DesktopItem desktopItem = (DesktopItem) itemArrayList.get(position);
                    Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);
                    ArrayList<Integer> ids = new ArrayList<>();
                    ids.add(desktopItem.getCpu().getId());
                    ids.add(desktopItem.getaCase().getId());
                    ids.add(desktopItem.getGpu().getId());
                    ids.add(desktopItem.getRam().getId());
                    ids.add(desktopItem.getHdd().getId());
                    ids.add(desktopItem.getPowerSupply().getId());
                    ids.add(desktopItem.getMotherboard().getId());
                    intent1.putExtra("DesktopID", ids);
                    startActivity(intent1);
                }
            }
        });
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
