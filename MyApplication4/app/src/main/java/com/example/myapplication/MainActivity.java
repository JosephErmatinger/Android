//Name/Date:  Joseph Ermatinger 10/25/2019;
//Instructor: Hira Harrington;
//Course:     ISYS 221 VL;
//Purpose:    The purpose of this program is to act as a basic reservation application so people can create an appointment to get their dogs walked;
//Inputs:     This program accepts user input in the form of a radio button selection and a button click which results in date selection via datePicker.
//Outputs:    A TextView control with the resulting output of date selected via datePicker and radioButton selection including values total cost & number of dogs will be output to the screen;
//Interfaces: N/A;
//Variables:  result;  TextView;    class variable for final result;
//            radio1;  RadioButton; hold selection;
//            radio2;  RadioButton; hold selection;
//            radio3;  RadioButton; hold selection;
//            radio4;  RadioButton; hold selection;
//            numDogs; Int;         hold value for number of dogs;
//            total;   Int;         hold value for total cost;
//Icon:       downloaded free launcher icon from https://www.flaticon.com/free-icons/dog
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //global variable declarations
    private TextView result;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    int numDogs = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize activity and display content of activity_main.xml layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display action bar with custom icon launcher from resources
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //reference & instantiate needed controls
        final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton radio4 = (RadioButton) findViewById(R.id.radioButton4);
        result = (TextView)findViewById(R.id.txtResult);
        Button btnDate = (Button)findViewById(R.id.btnDate);

        //set onClickListener for btnDate to launch DatePickerDialog when clicked
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            //display datePicker dialog after user clicks button
            public void onClick(View v) {
                //show the device's system year, month, and day of month in datePicker
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

                //determine what radioButton is selected to assign appropriate values to variables and show toast
                if(radio1.isChecked()){
                    numDogs = 1;
                    total   = 15;
                    Toast.makeText(MainActivity.this,"You have " + numDogs + " dog that needs walked!", Toast.LENGTH_LONG).show();
                }
                if(radio2.isChecked()){
                    numDogs = 2;
                    total   = 30;
                    Toast.makeText(MainActivity.this,"You have " + numDogs + " dogs that need walked!", Toast.LENGTH_LONG).show();
                }
                if(radio3.isChecked()){
                    numDogs = 3;
                    total   = 45;
                    Toast.makeText(MainActivity.this,"You have " + numDogs + " dogs that need walked!", Toast.LENGTH_LONG).show();
                }
                if(radio4.isChecked()){
                    numDogs = 4;
                    total   = 60;
                    Toast.makeText(MainActivity.this,"You have " + numDogs + " dogs that need walked!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //create instance of calendar class
    Calendar c = Calendar.getInstance();
    // set default format of the date and convert into string value
    DateFormat fmtDate = DateFormat.getDateInstance();
    //create onDateSetListener d which listens for callback to indicate user is done
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        //
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            //set the year, month, and day of month with user selection
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,monthOfYear);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            //display selected date and variable values in the result TextView object
            result.setText("Your reservation is " + fmtDate.format(c.getTime()) + ", and your total is $" + total + " for " + numDogs + " dog(s).");
        }
    };
}