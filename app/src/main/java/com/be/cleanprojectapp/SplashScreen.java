package com.be.cleanprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.be.cleanprojectapp.Activities.LoginScreen;


public class SplashScreen extends AppCompatActivity {
      private ImageView imageView;
      private Animation top_animation,bottom_animation;
      private TextView text_string ;
      private Handler handler ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        operationdoing();
        startanimation();
        nextMove();

    }

    private void nextMove() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LoginScreen.class));
                finish();
            }
        },3000);

    }

    private void startanimation() {
        imageView.setAnimation(top_animation);
        text_string.setAnimation(bottom_animation);
    }

    private void operationdoing() {
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        text_string = findViewById(R.id.splash_text_view);
        imageView = findViewById(R.id.splash_screen_image);
        handler = new Handler();
    }
}