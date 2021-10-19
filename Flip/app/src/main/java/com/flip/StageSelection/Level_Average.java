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

public class Level_Average extends AppCompatActivity {

    final int IMAGEBUTTON_COUNT = 17;
    ImageButton[] imgsButtons = new ImageButton[IMAGEBUTTON_COUNT];
    String[] imgsBtnsString = {
            "btnAverage1", "btnAverage2", "btnAverage3", "btnAverage4", "btnAverage5",
            "btnAverage6", "btnAverage7", "btnAverage8", "btnAverage9", "btnAverage10", "btnAverage11",
            "btnAverage12", "btnAverage13", "btnAverage14", "btnAverage15", "btnAverage16",
    };
    SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level__average);

        this.imgsButtons[0] = findViewById(R.id.btnBack);
        this.imgsButtons[1] = findViewById(R.id.btnAverage1);
        this.imgsButtons[2] = findViewById(R.id.btnAverage2);
        this.imgsButtons[3] = findViewById(R.id.btnAverage3);
        this.imgsButtons[4] = findViewById(R.id.btnAverage4);
        this.imgsButtons[5] = findViewById(R.id.btnAverage5);
        this.imgsButtons[6] = findViewById(R.id.btnAverage6);
        this.imgsButtons[7] = findViewById(R.id.btnAverage7);
        this.imgsButtons[8] = findViewById(R.id.btnAverage8);
        this.imgsButtons[9] = findViewById(R.id.btnAverage9);
        this.imgsButtons[10] = findViewById(R.id.btnAverage10);
        this.imgsButtons[11] = findViewById(R.id.btnAverage11);
        this.imgsButtons[12] = findViewById(R.id.btnAverage12);
        this.imgsButtons[13] = findViewById(R.id.btnAverage13);
        this.imgsButtons[14] = findViewById(R.id.btnAverage14);
        this.imgsButtons[15] = findViewById(R.id.btnAverage15);
        this.imgsButtons[16] = findViewById(R.id.btnAverage16);

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