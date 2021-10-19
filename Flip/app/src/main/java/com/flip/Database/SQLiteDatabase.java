package com.flip.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;

import com.flip.Constants;

import java.util.HashSet;

public class SQLiteDatabase extends SQLiteOpenHelper {

    Constants constX = new Constants();
    public String[] buttonNames = constX.getBUTTON_DB_NAMES();
    public static HashSet<String> unlocks = new HashSet<>(); //storing the names no (hashset is for unique elements)
    public static int nextStagePlease;

    public static final String DATABASE_NAME = "Records.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_BUTTONS = "Buttons";
    public static final String TABLE_NEXTSTAGE = "NextStage";

    //columns for TABLE_BUTTONS
    public final String BUTTONS_ID = "btnIds";
    public final String BUTTON_NAME = "btnNames";
    public final String IS_UNLOCK = "btnIsUnlock";

    //columns for NEXT_STAGE
    public final String NEXTSTAGE_ID = "nxtStgID";
    public final String NEXTSTAGE_INT = "nxtStgInt";

    public ContentValues contentValues;
    public Cursor cursor;

    public SQLiteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase conn) {
        String createTableButtons = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER)", TABLE_BUTTONS, BUTTONS_ID, BUTTON_NAME, IS_UNLOCK);
        conn.execSQL(createTableButtons);

        String createNextStageTable = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER)", TABLE_NEXTSTAGE, NEXTSTAGE_ID, NEXTSTAGE_INT);
        conn.execSQL(createNextStageTable);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase conn, int oldVersion, int newVersion) {
        conn.execSQL("DROP TABLE IF EXISTS " + TABLE_BUTTONS);
        onCreate(conn);

        conn.execSQL("DROP TABLE IF EXISTS " + TABLE_NEXTSTAGE);
        onCreate(conn);
    }

    //========================= FOR THE TABLE OF BUTTONS =========================\\
    public boolean setInitializeTableButtons() {
        android.database.sqlite.SQLiteDatabase conn = this.getWritableDatabase();
        contentValues = new ContentValues();
        for (int i = 0; i < buttonNames.length; i++) {
            contentValues.put(BUTTON_NAME, buttonNames[i]);

            //initialSettings of Buttons
            if ((i <= 1) || (i == 12) || (i == 29)) {
                contentValues.put(IS_UNLOCK, 1);
            }
            else {
                contentValues.put(IS_UNLOCK, 0);
            }

            //unlock all
//            contentValues.put(IS_UNLOCK, 1);

            conn.insert(TABLE_BUTTONS, null, contentValues);
        }
        return true;
    }

    public long getNumberOfTableButtonsRows() {
        android.database.sqlite.SQLiteDatabase conn = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(conn, TABLE_BUTTONS);
        conn.close();
        return count;
    }


    public HashSet<String> getUnlocks() {
        setUnlocks();
        return unlocks;
    }

    public void setUnlocks() {
        android.database.sqlite.SQLiteDatabase conn = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_BUTTONS;
        cursor = conn.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int i = cursor.getInt(cursor.getColumnIndex(IS_UNLOCK));
            if (i == 1) {
                unlocks.add(cursor.getString(cursor.getColumnIndex(BUTTON_NAME)));
            }
        }
    }

    public void updateUnlocks(String btnName) {
        android.database.sqlite.SQLiteDatabase conn = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_BUTTONS + " SET " + IS_UNLOCK + " = " + 1 + " WHERE " + BUTTON_NAME + " ='" + btnName + "'";
        conn.execSQL(query);
    }


    //========================= FOR THE NEXT STAGE TABLE =========================\\
    public boolean setInitializeNextStage() {
        android.database.sqlite.SQLiteDatabase conn = this.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(NEXTSTAGE_INT, 1);
        conn.insert(TABLE_NEXTSTAGE, null, contentValues);
        return true;
    }

    public int getNextStagePlease() {
        return nextStagePlease;
    }

    public void setNextStagePlease(int nextStagePlease) {
        SQLiteDatabase.nextStagePlease = nextStagePlease;
    }

    public void updateNextStage(){
        android.database.sqlite.SQLiteDatabase conn = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NEXTSTAGE + " SET " + NEXTSTAGE_INT + " = " + getNextStagePlease() + " WHERE " + NEXTSTAGE_ID + " ='" + 1 + "'";
        conn.execSQL(query);
    }
}
