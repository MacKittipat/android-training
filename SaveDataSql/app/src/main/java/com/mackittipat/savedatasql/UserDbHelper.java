package com.mackittipat.savedatasql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SaveDataSql.db";

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME_NAME = "name";

    private static final String SQL_CREATE_USER =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"  +
                    COLUMN_NAME_NAME + " TEXT" +
                    " )";


    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(this.getClass().toString(), "Creating table user");
        db.execSQL(SQL_CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
