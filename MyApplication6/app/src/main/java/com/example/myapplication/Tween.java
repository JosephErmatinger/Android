package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.animation.AnimationUtils;

public class Tween extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize activity and display content of activity_tween.xml layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        //instantiate ImageView control
        ImageView imgTween = (ImageView)findViewById(R.id.imgTween);

        //load animation in imgTween using tween.xml
        imgTween.startAnimation(AnimationUtils.loadAnimation(this, R.anim.tween));
    }
}
