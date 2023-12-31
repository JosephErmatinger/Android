package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] attraction= {"Art Institute of Chicago", "Magnificent Mile", "Willis Tower", "Navy Pier", "Water Tower", "Bonsai"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.travel, attraction));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){

        String itemClicked = String.valueOf(l.getItemAtPosition(position));
        Toast.makeText(MainActivity.this, itemClicked, Toast.LENGTH_LONG).show();

        switch(position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com")));
            break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://yahoo.com")));
            break;
            case 2:
                startActivity(new Intent(MainActivity.this, Willis.class));
            break;
            case 3:
                startActivity(new Intent(MainActivity.this, Pier.class));
            break;
            case 4:
                startActivity(new Intent(MainActivity.this, Water.class));
            break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://bonsaioutlet.com")));
            break;
        }
    }
}
