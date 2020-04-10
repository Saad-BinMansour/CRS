package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.crs.R;
import com.example.crs.database.ComputerDBHandler;

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

    private void getSearchItems(String searchItem) {
        if (searchItem != null) {
            customAdapter =
                    new CustomAdapter(this, R.layout.product_view, computerDBHandler.findHandler(searchItem));
            listView.setAdapter(customAdapter);
        }
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
}
