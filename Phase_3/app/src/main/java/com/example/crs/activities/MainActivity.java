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
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.Ports;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.item.ItemType;
import com.example.crs.model.laptop.ComputerItem;
import com.example.crs.model.laptop.Display;
import com.example.crs.model.laptop.DisplayResolution;
import com.example.crs.model.laptop.ScreenType;

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
                4532.99f, ItemType.NOTEBOOK, "https://c1.neweggimages.com/NeweggImage/ProductImageCompressAll1280/34-155-331-V21.jpg");

        laptop.setCpu(new CPU());
        laptop.getCpu().setName("Intel Core i7 9th Gen 9750H (2.60 GHz) ");
        laptop.getCpu().setOperatingFrequency(2.6f);
        laptop.getCpu().setNumberOfCores(6);
        laptop.getCpu().setNumberOfThreads(12);
        laptop.getCpu().setMaxTurboBoost(4.50f);

        laptop.setGpu(new GPU());
        laptop.getGpu().setName("GeForce GTX 1660 Ti 6 GB GDDR6 ");
        laptop.getGpu().setMemorySize(6);

        laptop.setRam(new RAM());
        laptop.getRam().setName("16 GB DDR4 2666 8 GB x 2");
        laptop.getRam().setCapacity(16);
        laptop.getRam().setSpeed(2666);

        laptop.setDisplay(new Display());
        laptop.getDisplay().setSize(15.6f);
        laptop.getDisplay().setDisplayResolution(DisplayResolution.D1920x1080);
        laptop.getDisplay().setScreenType(ScreenType.IPS);
        laptop.getDisplay().setHertz(144);
        laptop.getDisplay().setMs(3);
        laptop.getDisplay().setNtsc(72);
        laptop.getDisplay().setsRGB(100);

        laptop.setPorts(new Ports());
        laptop.getPorts().addPort(Ports.PortType.Mini_DisplayPort, 1);
        laptop.getPorts().addPort(Ports.PortType.USB_3_2_Gen_2_Type_C, 1);
        laptop.getPorts().addPort(Ports.PortType.USB_3_2_Gen_1, 2);
        laptop.getPorts().addPort(Ports.PortType.USB_3_2_Gen_2, 1);

        laptop.setDimensions(357.63f, 247.90f, 26.92f);
        laptop.setWeight(2.27f);

        laptop.setNVMeSSD(512);
        laptop.getNVMeSSD().setName("NVMe SSD");

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
