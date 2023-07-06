//Name/Date:  Joseph Ermatinger 10/10/2019;
//Instructor: Hira Harrington;
//Course:     ISYS 221 VL;
//Purpose:    The purpose of this program is to act as a basic list manager for bonsai trees;
//Inputs:     This program accepts user input in the form of an item click on any one of the list items.
//Outputs:    Multiple TextView controls displayed as a list and a detail view containing an ImageView & TextView along with a Toast will be output to the screen;
//Interfaces: N/A;
//Variables:  attraction;  String[]; hold Strings for list items;
//            itemClicked; String;   hold String of chosen list item;
//            position;    int;      hold position value of item clicked;
//Icon:       downloaded free launcher icon from https://www.flaticon.com/free-icons/bonsai
package com.example.myapplication;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize activity
        super.onCreate(savedInstanceState);

        //initialize String array with list items
        String[] attraction = {"Japanese Maple", "Chinese Hackberry", "Korean Hornbeam", "Weeping Fig", "Chinese Quince", "Japanese Elm"};

        //set custom adapter using specific layout file, TextViewResourceID, and list objects stored in attraction array
        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_main, R.id.bonsai, attraction));
    }
    //onListItemClick listener with anonymous inner type event handler
    protected void onListItemClick(ListView l, View v, int position, long id){

        //store string of which item is clicked in variable to show toast notification
        String itemClicked = String.valueOf(l.getItemAtPosition(position));
        Toast.makeText(MainActivity.this, "You selected: " + itemClicked, Toast.LENGTH_LONG).show();

        //determine which item(0-5) is clicked to start new activity with the appropriate layout/class file
        switch(position){
            case 0:
                startActivity(new Intent(MainActivity.this, Maple.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Hackberry.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Hornbeam.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, Ficus.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, Quince.class));
                break;
            case 5:
                startActivity(new Intent(MainActivity.this, Zelkova.class));
                break;
        }
    }
}
