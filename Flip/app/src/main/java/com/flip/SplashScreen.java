package com.flip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.flip.Services.*;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent music = new Intent(getApplicationContext(), Background_Music.class);
        music.putExtra("location" , "menu");
        startService(music);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(com.flip.SplashScreen.this,Menu.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}