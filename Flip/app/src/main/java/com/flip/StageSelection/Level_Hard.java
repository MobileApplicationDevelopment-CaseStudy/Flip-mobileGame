package com.flip.StageSelection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.flip.Database.SQLiteDatabase;
import com.flip.GameActivity;
import com.flip.Level_Selection;
import com.flip.R;

public class Level_Hard extends AppCompatActivity {

    final int IMAGEBUTTON_COUNT = 18;
    ImageButton[] imgsButtons = new ImageButton[IMAGEBUTTON_COUNT];
    String[] imgsBtnsString = {
            "btnHard1", "btnHard2", "btnHard3", "btnHard4", "btnHard5", "btnHard6", "btnHard7",
            "btnHard8", "btnHard9", "btnHard10", "btnHard11", "btnHard12", "btnHard13", "btnHard14", "btnHard15",
            "btnHard16", "btnHard17",
    };
    SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level__hard);

        this.imgsButtons[0] = findViewById(R.id.btnBack);
        this.imgsButtons[1] = findViewById(R.id.btnHard1);
        this.imgsButtons[2] = findViewById(R.id.btnHard2);
        this.imgsButtons[3] = findViewById(R.id.btnHard3);
        this.imgsButtons[4] = findViewById(R.id.btnHard4);
        this.imgsButtons[5] = findViewById(R.id.btnHard5);
        this.imgsButtons[6] = findViewById(R.id.btnHard6);
        this.imgsButtons[7] = findViewById(R.id.btnHard7);
        this.imgsButtons[8] = findViewById(R.id.btnHard8);
        this.imgsButtons[9] = findViewById(R.id.btnHard9);
        this.imgsButtons[10] = findViewById(R.id.btnHard10);
        this.imgsButtons[11] = findViewById(R.id.btnHard11);
        this.imgsButtons[12] = findViewById(R.id.btnHard12);
        this.imgsButtons[13] = findViewById(R.id.btnHard13);
        this.imgsButtons[14] = findViewById(R.id.btnHard14);
        this.imgsButtons[15] = findViewById(R.id.btnHard15);
        this.imgsButtons[16] = findViewById(R.id.btnHard16);
        this.imgsButtons[17] = findViewById(R.id.btnHard17);

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
        imgsButtons[11].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[12].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[13].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[14].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[15].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[16].setOnClickListener(new ExternalOnClickListener());
        imgsButtons[17].setOnClickListener(new ExternalOnClickListener());

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