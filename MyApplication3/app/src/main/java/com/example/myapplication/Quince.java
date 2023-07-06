package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Quince extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize activity and display content of activity_quince.xml layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quince);

        //display action bar with custom icon launcher from resources
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
