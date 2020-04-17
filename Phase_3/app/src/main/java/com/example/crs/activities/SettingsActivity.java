package com.example.crs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.crs.R;

public class SettingsActivity extends AppCompatActivity {

    static String deviceInfo="Device Info:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        deviceInfo += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        deviceInfo += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        deviceInfo += "\n Device: " + android.os.Build.DEVICE;
        deviceInfo += "\n Model (Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
    }

    public void homebutton(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void bookmarkbutton(View view) {
        Intent intent=new Intent(this, BookmarkActivity.class);
        startActivity(intent);
    }

    public void AboutUsbutton(View view) {
        Intent intent=new Intent(this, Aboutus.class);
        startActivity(intent);
    }

    public void ContactusBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Saadalonyq@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "User NO. 2");
        intent.putExtra(Intent.EXTRA_TEXT, "\n \n *Do Not Write Under This* \n"+deviceInfo);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));

    }

    public void FeedbackBtn(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Saadalonyq@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "User NO. 2");
        intent.putExtra(Intent.EXTRA_TEXT, "\n \n *Do Not Write Under This* \n"+deviceInfo);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
}
