package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

import com.example.crs.R;
import com.example.crs.database.ComputerDBHandler;

// The main page of the software
public class MainActivity extends AppCompatActivity {
    private RangeBar rangeBar;
    private TextView minPrice,highPrice;
    private SearchView searchBar;
    private ComputerDBHandler computerDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computerDBHandler = new ComputerDBHandler(this, null);

        minPrice = findViewById(R.id.minPrice);
        highPrice = findViewById((R.id.highPrice));
        searchBar = findViewById(R.id.searchBar);

        rangeBar=findViewById(R.id.RangeBar);
        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                minPrice.setText(leftPinValue);
                highPrice.setText(rightPinValue);
            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {
            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {
            }
        });

        searchFunction();
    }

    // Opens the setting page
    public void settingsButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    // Opens the bookmark page
    public void bookmarkbutton(View view) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        startActivity(intent);
    }

    // Opens the result and parse a string from the search view's query
    private void searchFunction() {
        final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                String searchName = searchBar.getQuery().toString();
                intent.putExtra("SearchItemsName", searchName);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };

        searchBar.setOnQueryTextListener(queryTextListener);
    }
}
