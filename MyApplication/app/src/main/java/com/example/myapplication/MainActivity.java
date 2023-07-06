//Name/Date:  Joseph Ermatinger 9/25/2019;
//Instructor: Hira Harrington;
//Course:     ISYS 221 VL;
//Purpose:    The purpose of this program is to act as a basic unit conversion utility, converting USD to JPY as well as JPY to USD. It's about bonsai since they are often valued in USD or JPY;
//Inputs:     This program accepts user input in the form of a number which they can enter using the soft keyboard as well as a radio button selection and a button click. Only numbers and (.) are allowed;
//Outputs:    TextView control with the resulting converted value will be output to the screen;
//Interfaces: N/A;
//Variables:  conversionRate; Double; hold value to perform conversions;
//            valueEntered; Double; hold user entered value;
//            convertedValue; Double; hold the converted value to display to user;
//Icon:       downloaded free launcher icon from https://www.flaticon.com/free-icons/bonsai
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;
import android.util.*;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //initialize and declare variables
    double conversionRate = .009264;
    double valueEntered = 0.0;
    double convertedValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //initialize activity and display content of activity_main.xml layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display action bar with custom icon launcher from resources
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //instantiate and reference needed classes to variables
        final EditText textValue = (EditText) findViewById(R.id.textValue);
        final RadioButton USDjpy = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton JPYusd = (RadioButton) findViewById(R.id.radioButton2);
        final TextView result = (TextView) findViewById(R.id.textResult);
        Button convert = (Button) findViewById(R.id.convertButton);

        //set on click listener
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            //on click listener with anonymous inner type even handler
            public void onClick(View v) {
                //catch exception to prevent app from crashing if nothing is entered
                try
                {
                    //convert and parse user input then store value in variable
                    valueEntered = Double.parseDouble(textValue.getText().toString());

                //use DecimalFormat class to format output
                DecimalFormat tenth = new DecimalFormat("#,###,##0.00");
                //if radiobutton USDjpy(first) is selected continue
                if (USDjpy.isChecked()) {
                    //if user input is in accepted range continue
                    if (valueEntered < 1000001 && valueEntered > 0) {
                        //perform calculation and display result in JPY
                        convertedValue = valueEntered / conversionRate;
                        result.setText(tenth.format(convertedValue) + " JPY");
                    }else{
                        //display toast to user to validate input
                        Toast.makeText(MainActivity.this, "Enter value between 1 & 1 million USD!", Toast.LENGTH_LONG).show();
                    }
                //if radiobutton JPYusd(second) is selected continue
                } else {
                    //if user input is in accepted range continue
                    if (valueEntered < 100000001 && valueEntered > 0) {
                        //perform calculation and display result in USD
                        convertedValue = valueEntered * conversionRate;
                        result.setText(tenth.format(convertedValue) + " USD");
                    } else {
                        //display toast to user to validate input
                        Toast.makeText(MainActivity.this, "Enter value between 1 & 100 million JPY!", Toast.LENGTH_LONG).show();
                    }
                }
                }
                   //catch exception to prevent app from crashing
                   catch (NumberFormatException e)
                {
                    //display toast to user to validate input
                    Toast.makeText(MainActivity.this, "Please enter value greater than 0!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}