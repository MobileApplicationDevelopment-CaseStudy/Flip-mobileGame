package com.flip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.flip.Database.SQLiteDatabase;
import com.flip.StageSelection.ExternalOnClickListener;
import com.flip.StageSelection.Level_Average;
import com.flip.StageSelection.Level_Easy;
import com.flip.StageSelection.Level_Hard;

public class Level_Selection extends AppCompatActivity {
    final int IMAGEBUTTON_COUNT = 5;
    ImageButton[] imgsButtons = new ImageButton[IMAGEBUTTON_COUNT];
    String[] imgBtnsString = {"btnEasy", "btnAverage", "btnHard", "btnEndless"};
    SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level__selection);

        this.imgsButtons[0] = findViewById(R.id.btnBack); //btnBack always the 1st element
        this.imgsButtons[1] = findViewById(R.id.btnEasy);
        this.imgsButtons[2] = findViewById(R.id.btnAverage);
        this.imgsButtons[3] = findViewById(R.id.btnHard);
        this.imgsButtons[4] = findViewById(R.id.btnEndless);


        //call the next 2 line of codes every after the assignment of button object like this
        conn = new SQLiteDatabase(this);
        displayUnlockButtons(conn); //handle all the buttons state of the level selection

        //Back Button
        imgsButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(imgsButtons[0]);
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });

        //Easy Button
        imgsButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(imgsButtons[1]);
                Intent easyStageSelectionIntent = new Intent(getApplicationContext(), Level_Easy.class);
                startActivity(easyStageSelectionIntent);
            }
        });

        //Average Button
        imgsButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(imgsButtons[2]);
                Intent aveStageSelectionIntent = new Intent(getApplicationContext(), Level_Average.class);
                startActivity(aveStageSelectionIntent);
            }
        });

        //Hard Button
        imgsButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(imgsButtons[3]);
                Intent hardStageSelectionIntent = new Intent(getApplicationContext(), Level_Hard.class);
                startActivity(hardStageSelectionIntent);
            }
        });

        //Endless Button
        imgsButtons[4].setOnClickListener(new ExternalOnClickListener());

    }

    private void displayUnlockButtons(SQLiteDatabase conn) {
        for (int i = 0; i < imgBtnsString.length; i++){
            if(!conn.getUnlocks().contains(imgBtnsString[i])){
                imgsButtons[i+1].setAlpha(0.5f); //+1 because btnBack is not included
                imgsButtons[i+1].setEnabled(false);
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Intent intent = new Intent(getApplicationContext(), Menu.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(intent);

        Intent intent = new Intent(getApplicationContext(), Menu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("EXIT", true);
        startActivity(intent);

        finish();
    }
}