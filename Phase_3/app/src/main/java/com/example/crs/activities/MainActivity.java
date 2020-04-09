package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;
import com.stfalcon.pricerangebar.RangeBarWithChart;

import com.example.crs.R;

public class MainActivity extends AppCompatActivity {

    RadioButton Study,Gaming,Editing,Browes,Screen,Performance,Portability;
    RangeBar rangeBar;
    EditText SearchText;
    TextView minPrice,highPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchText=(EditText)findViewById(R.id.SearchText);
        minPrice=(TextView) findViewById(R.id.minPrice);
        highPrice=(TextView) findViewById((R.id.highPrice));

        Study = (RadioButton) findViewById(R.id.study_rad);
        Browes = (RadioButton) findViewById(R.id.browes_rad);
        Editing = (RadioButton) findViewById(R.id.editing_rad);
         Gaming = (RadioButton) findViewById(R.id.gaming_rad);
         Screen = (RadioButton) findViewById(R.id.screen_rad);
        Performance = (RadioButton) findViewById(R.id.performance_rad);
        Portability = (RadioButton) findViewById(R.id.portability_rad);

        Study.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Study.setChecked(true);
                Browes.setChecked(false);
                Editing.setChecked(false);
                Gaming.setChecked(false);
            }
        });

        Browes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Study.setChecked(false);
                Browes.setChecked(true);
                Editing.setChecked(false);
                Gaming.setChecked(false);
            }
        });

        Editing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Study.setChecked(false);
                Browes.setChecked(false);
                Editing.setChecked(true);
                Gaming.setChecked(false);
            }
        });

        Gaming.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Study.setChecked(false);
                Browes.setChecked(false);
                Editing.setChecked(false);
                Gaming.setChecked(true);
            }
        });

        Screen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Screen.setChecked(true);
                Performance.setChecked(false);
                Portability.setChecked(false);
            }
        });

        Performance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Screen.setChecked(false);
                Performance.setChecked(true);
                Portability.setChecked(false);
            }
        });

        Portability.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Screen.setChecked(false);
                Performance.setChecked(false);
                Portability.setChecked(true);
            }
        });

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




    }

    public void settingsButton(View view) {
        Intent intent =new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }

    public void bookmarkbutton(View view) {
        Intent intent=new Intent(this,BookmarkActivity.class);
        startActivity(intent);
    }
}
