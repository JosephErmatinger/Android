//Name/Date:  Joseph Ermatinger 11/18/2019;
//Instructor: Hira Harrington;
//Course:     ISYS 221 VL;
//Purpose:    The purpose of this program is to display images of your favorite game in action by using frame & tween animations.
//Inputs:     This program accepts user input in the form of a button selection which results in starting either a frame animation or a tween animation.
//Outputs:    A frame animation or tween animation via an ImageView control will be output to the screen when a button is selected;
//Interfaces: N/A;
//Variables:  gameAnimation;  AnimationDrawable;  assign animationDrawable object;
//            imgFrame;       ImageView;          assign animation to ImageView;
//            button1;        Button;             hold selection;
//            button2;        Button;             hold selection;
package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //global variable declarations
    AnimationDrawable gameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize activity and display content of activity_main.xml layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate ImageView control imgFrame that accesses imgGame in XML file
        ImageView imgFrame = (ImageView)findViewById(R.id.imgGame);
        //set the backgroundResource of imgFrame with animation-list animation.xml file
        imgFrame.setBackgroundResource(R.drawable.animation);
        //access gameAnimation AnimationDrawable object by getting view object
        gameAnimation = (AnimationDrawable) imgFrame.getBackground();
        //instantiate both button controls
        Button button1 = (Button)findViewById(R.id.btnStart);
        Button button2 = (Button)findViewById(R.id.btnStop);
        //set onClickListener for button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start frame animation
                gameAnimation.start();
            }
        });
        //set onClickListener for button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop frame animation
                gameAnimation.stop();
                //launch new activity using Tween class file
                startActivity(new Intent(MainActivity.this, Tween.class));
            }
        });
    }
}
