package com.flip;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.flip.Database.SQLiteDatabase;
import com.flip.GraphicSetting.Average_ButtonGraphicsSetting;
import com.flip.GraphicSetting.Easy_ButtonGraphicsSetting;
import com.flip.GraphicSetting.Hard_ButtonGraphicsSetting;
import com.flip.Services.Background_Music;
import com.flip.Services.Game_Music;
import com.flip.StageSelection.ExternalOnClickListener;
import com.flip.StageSelection.Level_Average;
import com.flip.StageSelection.Level_Easy;
import com.flip.StageSelection.Level_Hard;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private int ELEMENT_COUNT;
    private MemoryButton[] AllButtons;
    private MemoryButton selectedCard1;
    private MemoryButton selectedCard2;
    private boolean isBusy = false;
    private CountDownTimer countDownTimer;
    private final long EASY_TIME = 30000, AVERAGE_TIME = 60000, HARD_TIME = 120000;
    private boolean mTimerRunning;
    private long mTimerLeftInMillis;
    TextView TVtimer;

    private int[] buttonGraphicsLocation; //store random location
    private int[] buttonGraphics;

    private int difficulty, isEndless;
    private String nextStage;
    boolean alpha = true;

    Dialog pauseWindow;

    //for nextStage window
    Dialog nextStageWindow;
    ImageButton btnLevelSelection, btnNextStage, btnHomeMenu;
    TextView TVResult;
    private int idOfNextStage;

    public int getIdOfNextStage() {
        return idOfNextStage;
    }

    public void setIdOfNextStage(int idOfNextStage) {
        this.idOfNextStage = idOfNextStage;
    }

    SQLiteDatabase conn;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameboard);

        setIdOfNextStage(getIntent().getIntExtra("playNextStage", 0));
        difficulty = getIntent().getIntExtra("difficulty", 0);
        isEndless = getIntent().getIntExtra("isEndless", 0);
        nextStage = getIntent().getStringExtra("openNextStage");

        //Popup window

        ImageButton btnBurger = findViewById(R.id.btnBurger);

        pauseWindow = new Dialog(GameActivity.this);
        pauseWindow.setContentView(R.layout.settings);
        ImageButton btnClose = pauseWindow.findViewById(R.id.btnClose);
        ImageButton btnHome = pauseWindow.findViewById(R.id.btnHome);
        ImageButton btnMusic = pauseWindow.findViewById(R.id.btnMusic);
        ImageButton btnBack = pauseWindow.findViewById(R.id.btnBack);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pauseWindow.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }

        //Popup pause
        pauseWindow.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pauseWindow.setCancelable(false);
        pauseWindow.getWindow().getAttributes().windowAnimations = R.style.animation;

        // Popup pause window buttons

        btnBurger.setOnClickListener(v -> {
            pauseWindow.show();
            pauseTimer();
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseWindow.dismiss();
                resumeTimer();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                startActivity(new Intent(getApplicationContext(), Menu.class));
                startService(new Intent(getApplicationContext(), Background_Music.class));
                stopService(new Intent(getApplicationContext(), Game_Music.class));
                finish();
            }
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(btnMusic);
                setMusicOnAndOff(v, alpha);
            }
        });

        //*************************************************************
        // nextStageWindow

        nextStageWindow = new Dialog(GameActivity.this);
        nextStageWindow.setContentView(R.layout.next_stage);
        btnLevelSelection = nextStageWindow.findViewById(R.id.btnLevelSelection);
        btnNextStage = nextStageWindow.findViewById(R.id.btnNextStage);
        btnHomeMenu = nextStageWindow.findViewById(R.id.btnHome);
        TVResult = nextStageWindow.findViewById(R.id.TVResult);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            nextStageWindow.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }

        nextStageWindow.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nextStageWindow.setCancelable(false);
        nextStageWindow.getWindow().getAttributes().windowAnimations = R.style.animation;

        btnNextStage.setOnClickListener(new ExternalOnClickListener());

        btnHomeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(btnHomeMenu);
                countDownTimer.cancel();
                startActivity(new Intent(getApplicationContext(), Menu.class));
                startService(new Intent(getApplicationContext(), Background_Music.class));
                stopService(new Intent(getApplicationContext(), Game_Music.class));
                finish();
            }
        });

        btnLevelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStageWindow.dismiss();
                backToMenu();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMenu();
            }
        });

        //GridLayout
        GridLayout gridLayout = findViewById(R.id.cardsGridLayout);
        int rowCount = getIntent().getIntExtra("rowCount", 0);
        int columnCount = getIntent().getIntExtra("colCount", 0);

        ELEMENT_COUNT = rowCount * columnCount;

        this.AllButtons = new MemoryButton[ELEMENT_COUNT];
        this.buttonGraphics = new int[ELEMENT_COUNT / 2];

        // Difficulty 3 = Hard level
        if (difficulty == 3) {

            // Timer for Hard level
            mTimerLeftInMillis = HARD_TIME;
            startTimer(HARD_TIME);

            // Hard levels buttonGraphicsSetting
            int stageCount = getIntent().getIntExtra("hardStageCount", 0);
            Hard_ButtonGraphicsSetting hard_buttonGraphicsSetting = new Hard_ButtonGraphicsSetting();

            hard_buttonGraphicsSetting.setButtonGraphicsHard(stageCount, rowCount, columnCount);

            this.buttonGraphics = hard_buttonGraphicsSetting.getButtonGraphicsHard();
        }

        // Difficulty 2 = Average level
        if (difficulty == 2) {

            // Timer for Average level
            mTimerLeftInMillis = AVERAGE_TIME;
            startTimer(AVERAGE_TIME);

            // Average levels buttonGraphicsSetting
            int stageCount = getIntent().getIntExtra("averageStageCount", 0);
            Average_ButtonGraphicsSetting average_buttonGraphicsSetting = new Average_ButtonGraphicsSetting();

            average_buttonGraphicsSetting.setButtonGraphicsAve(stageCount, rowCount, columnCount);

            this.buttonGraphics = average_buttonGraphicsSetting.getButtonGraphicsAve();
        }

        // Difficulty 1 = Easy level
        if (difficulty == 1) {

            // Timer for Easy level 240000
            mTimerLeftInMillis = EASY_TIME;
            startTimer(EASY_TIME);

            // Easy levels buttonGraphicsSetting
            int stageCount = getIntent().getIntExtra("easyStageCount", 0);
            Easy_ButtonGraphicsSetting easy_buttonGraphicsSetting = new Easy_ButtonGraphicsSetting();

            easy_buttonGraphicsSetting.setButtonGraphicsEasy(stageCount, rowCount, columnCount);

            this.buttonGraphics = easy_buttonGraphicsSetting.getButtonGraphicsEasy();
        }

        this.buttonGraphicsLocation = new int[ELEMENT_COUNT];
        shuffleButtonGraphics(rowCount, columnCount);

        initeMemoryButtons(rowCount, columnCount, gridLayout);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initeMemoryButtons(int rowCount, int columnCount, GridLayout gridLayout) {
        try {
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    MemoryButton tempButtons = new MemoryButton(this, row, col, buttonGraphics[buttonGraphicsLocation[row * columnCount + col]]); //*
                    tempButtons.setId(View.generateViewId()); //**
                    tempButtons.setOnClickListener(this);
                    AllButtons[row * columnCount + col] = tempButtons;
                    gridLayout.addView(tempButtons);
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void shuffleButtonGraphics(int rowCount, int columnCount) {
        Random rand = new Random();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            this.buttonGraphicsLocation[i] = i % (ELEMENT_COUNT / 2);
        }
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            int temp = this.buttonGraphicsLocation[i];
            int swapIndex = rand.nextInt(rowCount * columnCount);
            buttonGraphicsLocation[i] = buttonGraphicsLocation[swapIndex];
            buttonGraphicsLocation[swapIndex] = temp;
        }
    }

    @Override
    public void onClick(View v) {

        if (isBusy) {
            return;
        }

        final MemoryButton button = (MemoryButton) v;
        if (button.isMatched) {
            return;
        }
        if (selectedCard1 == null) {
            selectedCard1 = button;
            selectedCard1.flip();
            return;
        }
        if (selectedCard1.getId() == button.getId()) {
            return;
        }
        if (selectedCard1.getFrontImageIDs() == button.getFrontImageIDs()) {
            button.flip();

            button.setMatched(true);

            selectedCard1.setAlpha(0);
            button.setAlpha(0);

            selectedCard1.setEnabled(false);
            button.setEnabled(false);


            selectedCard1 = null;
            if (checkIfDone()) {
                com.flip.GameActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TVResult.setText("Level Complete!");
                        countDownTimer.cancel(); // prevents the timer to continuing
                    }
                });
                if (isEndless == 1) {
                    finish();
                } else {
                    conn = new SQLiteDatabase(v.getContext());
                    conn.updateUnlocks(nextStage);
                    conn.setNextStagePlease(getIdOfNextStage());
                    conn.updateNextStage();

                    final View backGround = (View) findViewById(R.id.backGround);
                    backGround.bringToFront();
                    backGround.setVisibility(View.VISIBLE);
                    final com.airbnb.lottie.LottieAnimationView winAnimation = findViewById(R.id.star_levelComplete);
                    winAnimation.bringToFront();
                    winAnimation.setVisibility(View.VISIBLE);
                    final Handler handlerWin = new Handler();
                    handlerWin.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            winAnimation.setVisibility(View.INVISIBLE);
                            backGround.setVisibility(View.INVISIBLE);

                            int nextStageInt = conn.getNextStagePlease();
                            if((nextStageInt == 10) || (nextStageInt == 26) || (nextStageInt==43)){
                                btnNextStage.setEnabled(false); //disable last stage of each difficulty
                                btnNextStage.setAlpha(0.5f);
                                nextStageWindow.show();
                            }
                            else {
                                nextStageWindow.show();
                            }

                        }
                    }, 1000);

                }
            }
            return;
        } else {
            selectedCard2 = button;
            selectedCard2.flip();
            isBusy = true;

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedCard1.flip();
                    selectedCard2.flip();
                    selectedCard1 = null;
                    selectedCard2 = null;
                    isBusy = false;
                }
            }, 500);
        }
    }

    private boolean checkIfDone() {
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            if (AllButtons[i].isEnabled()) {
                return false;
            }
        }
        return true;

    }

    private void backToMenu() {
        startService(new Intent(this, Background_Music.class));
        stopService(new Intent(this, Game_Music.class));

        countDownTimer.cancel();
        if (difficulty == 3) {
            if (isEndless == 1) {
                backToLevelSelection(); // level endless is selected
            } else {
                Intent intent = new Intent(getApplicationContext(), Level_Hard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }
        if (difficulty == 2) {
            if (isEndless == 1) {
                backToLevelSelection();
            } else {
                Intent intent = new Intent(getApplicationContext(), Level_Average.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }
        if (difficulty == 1) {
            if (isEndless == 1) {
                backToLevelSelection();
            } else {
                Intent intent = new Intent(getApplicationContext(), Level_Easy.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }
    }

    // Timer methods
    private void startTimer(long TimerLeftInMillis) {
        countDownTimer = new CountDownTimer(mTimerLeftInMillis , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                final View backGround = (View) findViewById(R.id.backGround);
                backGround.bringToFront();
                backGround.setVisibility(View.VISIBLE);
                final com.airbnb.lottie.LottieAnimationView loseAnimation = findViewById(R.id.times_up);
                loseAnimation.bringToFront();
                loseAnimation.setVisibility(View.VISIBLE);
                final Handler handlerLose = new Handler();
                handlerLose.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loseAnimation.setVisibility(View.INVISIBLE);
                        backGround.setVisibility(View.INVISIBLE);
                        backToMenu();
                    }
                }, 2000);
                mTimerRunning = false;
            }
        }.start();

        mTimerRunning = true;
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        mTimerRunning = false;
    }

    private void resumeTimer() {
        startTimer(mTimerLeftInMillis);
    }

    private void updateCountdownText() {
        TextView TVtimer = findViewById(R.id.TVTimer);
        int minutes = (int) (mTimerLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimerLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        TVtimer.setText(timeLeftFormatted);
    }

    // setting the alpha of buttons
    public void setMusicOnAndOff(View v, Boolean alpha) {
        if (alpha) {
            v.setAlpha(0.5f);
            this.alpha = false;
            stopService(new Intent(this, Game_Music.class));
        } else {
            v.setAlpha(1f);
            this.alpha = true;
            startService(new Intent(this, Game_Music.class));
        }
    }

    private void backToLevelSelection() {
        Intent intent = new Intent(getApplicationContext(), Level_Selection.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToMenu();
    }

}
