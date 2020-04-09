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
import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.item.ItemType;
import com.example.crs.model.laptop.ComputerItem;

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

        /*ComputerItem laptop = new ComputerItem("MSI GE65 Raider-432", "GE65 Raider-432",
                "https://www.newegg.com/global/sa-en/aluminum-black-msi-ge-series-ge65-raider-" +
                        "432-gaming-entertainment/p/N82E16834155331?Item=N82E16834155331&Description" +
                        "=PPSSBFRVZMCFNQ&cm_re=PPSSBFRVZMCFNQ-_-34-155-331-_-Product&quicklink=true",
                4760.69f, ItemType.NOTEBOOK, "https://c1.neweggimages.com/NeweggImage/ProductImageCompressAll1280/34-155-331-V21.jpg");
        laptop.setCpu(new CPU("Intel Core i7 9th Gen", null, null, 0, ItemType.CPU, null));
        laptop.setGpu(new GPU("NVIDIA GeForce GTX 1660 Ti", null, null, 0, ItemType.GPU, null));
        computerDBHandler.addHandler(laptop);*/

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

    public void searchFunction(View view) {

    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void bookmarkbutton(View view) {
        Intent intent = new Intent(this, BookmarkActivity.class);
        startActivity(intent);
    }

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
