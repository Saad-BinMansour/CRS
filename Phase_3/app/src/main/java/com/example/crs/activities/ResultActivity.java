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
        getSearchItems(searchName);
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

    @Override
    public void onResume() {
        super.onResume();

        // Refresh activity when returns form other activity
        if (customAdapter != null) {
            customAdapter.notifyDataSetChanged();
        }
    }

    private void getSearchItems(String searchItem) {
        if (searchItem != null) {
            customAdapter = new CustomAdapter(this, R.layout.product_view, computerDBHandler.findHandler(searchItem));
            listView.setAdapter(customAdapter);
        }
    }
}
