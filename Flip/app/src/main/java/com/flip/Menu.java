package com.flip;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.flip.Database.SQLiteDatabase;
import com.flip.Services.Background_Music;

public class Menu extends AppCompatActivity {

    SQLiteDatabase conn;
    Boolean alpha = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton btnPlay = findViewById(R.id.btnplay);
        ImageButton btnSettings = findViewById(R.id.btnsettings);
        ImageButton btnLboard = findViewById(R.id.btnlboard);

        Dialog Settings = new Dialog(Menu.this);
        Settings.setContentView(R.layout.settings);
        ImageButton btnClose = Settings.findViewById(R.id.btnClose);
        ImageButton btnHome = Settings.findViewById(R.id.btnHome);
        ImageButton btnMusic = Settings.findViewById(R.id.btnMusic);
        ImageButton btnBack = Settings.findViewById(R.id.btnBack);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.dismiss();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Settings.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }

        Settings.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Settings.setCancelable(false);
        Settings.getWindow().getAttributes().windowAnimations = R.style.animation;

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(btnPlay); // For animation
                startActivity(new Intent(getApplicationContext(), Level_Selection.class));
            }
        });

        btnSettings.setOnClickListener(v -> {
            YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(btnSettings);
            Settings.show();
            btnHome.setEnabled(false);
            btnBack.setEnabled(false);
            btnHome.setVisibility(View.INVISIBLE);
            btnBack.setVisibility(View.INVISIBLE);
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(btnMusic);
                setMusicOnAndOff(v , alpha);
            }
        });

        conn =  new SQLiteDatabase(this);
        initializeButtons(conn);

    }

    private void initializeButtons(SQLiteDatabase conn) {
        //to avoid continuous row increment
        if(conn.getNumberOfTableButtonsRows() >= 47){
            return;
        }
        else{
            if(conn.setInitializeTableButtons() && conn.setInitializeNextStage()){
                //Toast.makeText(getApplicationContext(), "DB READY", Toast.LENGTH_SHORT).show();
            }
            else {
                //Toast.makeText(getApplicationContext(), "DB FAILED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // setting the alpha of buttons
    public void setMusicOnAndOff(View v , Boolean alpha) {
        if(alpha){
            v.setAlpha(0.5f);
            this.alpha = false;
            stopService(new Intent(this, Background_Music.class));
        }
        else {
            v.setAlpha(1f);
            this.alpha = true;
            startService(new Intent(this, Background_Music.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, Background_Music.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onStop();
        onDestroy();
    }

}