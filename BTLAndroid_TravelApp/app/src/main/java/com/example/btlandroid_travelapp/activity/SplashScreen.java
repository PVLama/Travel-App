package com.example.btlandroid_travelapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.activity.LoginSignup.Login;

import io.paperdb.Paper;
import pl.droidsonroids.gif.GifImageView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    ImageView imageView, imageViewTravel;

    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        imageView = findViewById(R.id.imageView_item);
        imageViewTravel = findViewById(R.id.image_goTravel);

        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        imageView.setAnimation(sideAnim);
        imageViewTravel.setAnimation(sideAnim);

        imageView.setAnimation(bottomAnim);
        imageViewTravel.setAnimation(bottomAnim);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
//                finish();
//            }
//        },SPLASH_TIMER);


        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception ex) {

                } finally {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                }
            }
    }
    ;thread.start();
}
}