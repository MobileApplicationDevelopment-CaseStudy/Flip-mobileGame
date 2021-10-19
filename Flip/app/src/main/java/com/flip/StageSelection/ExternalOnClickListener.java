package com.flip.StageSelection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.flip.Constants;
import com.flip.Database.SQLiteDatabase;
import com.flip.GameActivity;
import com.flip.R;
import com.flip.Services.Background_Music;
import com.flip.Services.Game_Music;

public class ExternalOnClickListener implements View.OnClickListener {

    int row = 0, column = 0, stage = 0;
    boolean music = true;
    boolean nextEndlessLevel = true;

    Constants constX = new Constants();
    int[] btnIds = constX.getBtnIds();

    int isEndless, playNextStage;
    String openNextStage;

    public int getPlayNextStage() {
        return this.playNextStage;
    }
    public void setPlayNextStage(int playNextStage) {
        this.playNextStage = playNextStage;
    }

    public String getOpenNextStage() {
        return openNextStage;
    }
    public void setOpenNextStage(String openNextStage) {
        this.openNextStage = openNextStage;
    }

    public int getIsEndless() {
        return isEndless;
    }
    public void setIsEndless(int isEndless) {
        this.isEndless = isEndless;
    }

    //set row and column count -hardLevel is fixed
    public void HardsetRowCol(Intent hardLevelIntent) {
        hardLevelIntent.putExtra("hardStageCount", stage);
        hardLevelIntent.putExtra("rowCount", 6);
        hardLevelIntent.putExtra("colCount", 6);
        hardLevelIntent.putExtra("difficulty", 3);
        hardLevelIntent.putExtra("isEndless", getIsEndless());
        hardLevelIntent.putExtra("openNextStage", getOpenNextStage());
        hardLevelIntent.putExtra("playNextStage", getPlayNextStage());
    }

    //set row and column count -averageLevel is not fixed
    private void AveragesetRowCol(Intent averageLevelIntent) {
        averageLevelIntent.putExtra("averageStageCount", stage);
        averageLevelIntent.putExtra("rowCount", row);
        averageLevelIntent.putExtra("colCount", column);
        averageLevelIntent.putExtra("difficulty", 2);
        averageLevelIntent.putExtra("isEndless", getIsEndless());
        averageLevelIntent.putExtra("openNextStage", getOpenNextStage());
        averageLevelIntent.putExtra("playNextStage", getPlayNextStage());
    }

    //set row and column count -easyLevel is not fixed
    private void EasysetRowCol(Intent easyLevelIntent) {
        easyLevelIntent.putExtra("easyStageCount", stage);
        easyLevelIntent.putExtra("rowCount", row);
        easyLevelIntent.putExtra("colCount", column);
        easyLevelIntent.putExtra("difficulty", 1);
        easyLevelIntent.putExtra("isEndless", getIsEndless());
        easyLevelIntent.putExtra("openNextStage", getOpenNextStage());
        easyLevelIntent.putExtra("playNextStage", getPlayNextStage());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(v);

        Context context = v.getContext();
        context.stopService(new Intent(context, Background_Music.class));

        //Easy Level intent
        Intent easyLevelIntent = new Intent(context, GameActivity.class);
        EasysetRowCol(easyLevelIntent);

        //Average levels intent
        Intent averageLevelIntent = new Intent(context, GameActivity.class);
        AveragesetRowCol(averageLevelIntent);

        //Hard levels intent
        Intent hardLevelIntent = new Intent(context, GameActivity.class);
        HardsetRowCol(hardLevelIntent);

        switch (v.getId()) {

            //========================= for easy levels =========================\\
            case R.id.btnEasy1:
                stage = 1;
                row = 2;
                column = 2;
                applyMusic(music , context);
                setOpenNextStage("btnEasy2");
                setPlayNextStage(1);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy2:
                stage = 2;
                row = 2;
                column = 3;
                applyMusic(music , context);
                setOpenNextStage("btnEasy3");
                setPlayNextStage(2);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy3:
                stage = 3;
                row = 2;
                column = 3;
                applyMusic(music , context);
                setOpenNextStage("btnEasy4");
                setPlayNextStage(3);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy4:
                stage = 4;
                row = 2;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnEasy5");
                setPlayNextStage(4);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy5:
                stage = 5;
                row = 2;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnEasy6");
                setPlayNextStage(5);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy6:
                stage = 6;
                row = 2;
                column = 4;
                nextEndlessLevel = false;
                applyMusic(music , context);
                setOpenNextStage("btnEasy7");
                setPlayNextStage(6);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy7:
                stage = 7;
                row = 2;
                column = 5;
                applyMusic(music , context);
                setOpenNextStage("btnEasy8");
                setPlayNextStage(7);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy8:
                stage = 8;
                row = 2;
                column = 5;
                applyMusic(music , context);
                setOpenNextStage("btnEasy9");
                setPlayNextStage(8);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy9:
                stage = 9;
                row = 2;
                column = 5;
                applyMusic(music , context);
                setOpenNextStage("btnEasy10");
                setPlayNextStage(9);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;
            case R.id.btnEasy10:
                stage = 10;
                row = 2;
                column = 5;
                applyMusic(music , context);
                setOpenNextStage("btnAverage");
                setPlayNextStage(10);
                EasysetRowCol(easyLevelIntent);
                context.startActivity(easyLevelIntent);
                break;

            //========================= for average levels =========================\\
            case R.id.btnAverage1:
                stage = 1;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage2");
                setPlayNextStage(11);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage2:
                stage = 2;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage3");
                setPlayNextStage(12);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage3:
                stage = 3;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage4");
                setPlayNextStage(13);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage4:
                stage = 4;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage5");
                setPlayNextStage(14);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage5:
                stage = 5;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage6");
                setPlayNextStage(15);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage6:
                stage = 6;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage7");
                setPlayNextStage(16);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage7:
                stage = 7;
                row = 4;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage8");
                setPlayNextStage(17);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage8:
                stage = 8;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage9");
                setPlayNextStage(18);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage9:
                stage = 9;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage10");
                setPlayNextStage(19);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage10:
                stage = 10;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage11");
                setPlayNextStage(20);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage11:
                stage = 11;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage12");
                setPlayNextStage(21);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage12:
                stage = 12;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage13");
                setPlayNextStage(22);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage13:
                stage = 13;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage14");
                setPlayNextStage(23);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage14:
                stage = 14;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage15");
                setPlayNextStage(24);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage15:
                stage = 15;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnAverage16");
                setPlayNextStage(25);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;
            case R.id.btnAverage16:
                stage = 16;
                row = 5;
                column = 4;
                applyMusic(music , context);
                setOpenNextStage("btnHard");
                setPlayNextStage(26);
                AveragesetRowCol(averageLevelIntent);
                context.startActivity(averageLevelIntent);
                break;

            //========================= for hard levels =========================\\
            case R.id.btnHard1:
                stage = 1;
                applyMusic(music , context);
                setOpenNextStage("btnHard2");
                setPlayNextStage(27);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard2:
                stage = 2;
                applyMusic(music , context);
                setOpenNextStage("btnHard3");
                setPlayNextStage(28);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard3:
                stage = 3;
                applyMusic(music , context);
                setOpenNextStage("btnHard4");
                setPlayNextStage(29);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard4:
                stage = 4;
                applyMusic(music , context);
                setOpenNextStage("btnHard5");
                setPlayNextStage(30);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard5:
                stage = 5;
                applyMusic(music , context);
                setOpenNextStage("btnHard6");
                setPlayNextStage(31);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard6:
                stage = 6;
                applyMusic(music , context);
                setPlayNextStage(32);
                setOpenNextStage("btnHard7");
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard7:
                stage = 7;
                applyMusic(music , context);
                setOpenNextStage("btnHard8");
                setPlayNextStage(33);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard8:
                stage = 8;
                applyMusic(music , context);
                setOpenNextStage("btnHard9");
                setPlayNextStage(34);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard9:
                stage = 9;
                applyMusic(music , context);
                setOpenNextStage("btnHard10");
                setPlayNextStage(35);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard10:
                stage = 10;
                applyMusic(music , context);
                setOpenNextStage("btnHard11");
                setPlayNextStage(36);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard11:
                stage = 11;
                applyMusic(music , context);
                setOpenNextStage("btnHard12");
                setPlayNextStage(37);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard12:
                stage = 12;
                applyMusic(music , context);
                setOpenNextStage("btnHard13");
                setPlayNextStage(38);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard13:
                stage = 13;
                applyMusic(music , context);
                setOpenNextStage("btnHard14");
                setPlayNextStage(39);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard14:
                stage = 14;
                applyMusic(music , context);
                setOpenNextStage("btnHard15");
                setPlayNextStage(40);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard15:
                stage = 15;
                applyMusic(music , context);
                setOpenNextStage("btnHard16");
                setPlayNextStage(41);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard16:
                stage = 16;
                applyMusic(music , context);
                setOpenNextStage("btnHard17");
                setPlayNextStage(42);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;
            case R.id.btnHard17:
                stage = 17;
                applyMusic(music , context);
                setOpenNextStage("btnEndless");
                setPlayNextStage(43);
                HardsetRowCol(hardLevelIntent);
                context.startActivity(hardLevelIntent);
                break;

            //For Endless
            case R.id.btnEndless:
                YoYo.with(Techniques.RubberBand).duration(600).repeat(1).playOn(v);
                music = false;
                applyMusic(music, context);
                context.startService(new Intent(context, Game_Music.class));
                setIsEndless(1);
                showEndless(v);
                break;

            // For nextStage Window
            case R.id.btnNextStage:
                context.stopService(new Intent(context, Game_Music.class));
                SQLiteDatabase conn = new SQLiteDatabase(v.getContext());
                nextStagePlease(v, conn);
                break;
        }
    }

    private void nextStagePlease(View v, SQLiteDatabase conn) {
        v.setId(btnIds[conn.nextStagePlease]);
        onClick(v);
    }

    private void showEndless(View v) { //uses a recursive function
        for (int i = btnIds.length-1; i >= 0; i--) {
                v.setId(btnIds[i]);
                onClick(v);
        }
    }

    private void applyMusic(boolean music , Context c) {
        if(music) {
            c.startService(new Intent(c, Game_Music.class));
        }
    }


}
