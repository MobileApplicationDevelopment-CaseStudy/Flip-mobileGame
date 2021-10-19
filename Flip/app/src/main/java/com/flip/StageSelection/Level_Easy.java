package com.flip.StageSelection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.flip.Database.SQLiteDatabase;
import com.flip.GameActivity;
import com.flip.Level_Selection;
import com.flip.R;

public class Level_Easy extends AppCompatActivity {
    final int IMAGEBUTTON_COUNT = 11;
    ImageButton[] imgsButtons = new ImageButton[IMAGEBUTTON_COUNT];
    String[] imgsBtnsString = {
            "btnEasy1", "btnEasy2", "btnEasy3", "btnEasy4", "btnEasy5", "btnEasy6",
            "btnEasy7", "btnEasy8", "btnEasy9", "btnEasy10",
    };
    SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level__easy);

        this.imgsButtons[0] = findViewById(R.id.btnBack);
        this.imgsButtons[1] = findViewById(R.id.btnEasy1);
        this.imgsButtons[2] = findViewById(R.id.btnEasy2);
        this.imgsButtons[3] = findViewById(R.id.btnEasy3);
        this.imgsButtons[4] = findViewById(R.id.btnEasy4);
        this.imgsButtons[5] = findViewById(R.id.btnEasy5);
        this.imgsButtons[6] = findViewById(R.id.btnEasy6);
        this.imgsButtons[7] = findViewById(R.id.btnEasy7);
        this.imgsButtons[8] = findViewById(R.id.btnEasy8);
        this.imgsButtons[9] = findViewById(R.id.btnEasy9);
        this.imgsButtons[10] = findViewById(R.id.btnEasy10);

        conn =  new SQLiteDatabase(this);
        displayUnlockButtons(conn);

        imgsButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Level_Selection.class);
                startActivity(intent);
            }
        });

        imgsButtons[1].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[2].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[3].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[4].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[5].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[6].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[7].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[8].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[9].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[10].setOnClickListener(new ExternalOnClickListener());

    }

    private void displayUnlockButtons(SQLiteDatabase conn) {

        for (int i = 0; i < imgsBtnsString.length; i++){
            if (!conn.getUnlocks().contains(imgsBtnsString[i])){
                imgsButtons[i+1].setAlpha(0.5f); //+1 because btnBack is not included
                imgsButtons[i+1].setEnabled(false);
            }
        }

    }


}