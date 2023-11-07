package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DB_Name = "Userbase.db";
    private static final int DB_Version = 1;
    private static final String tableName = "USERDATA";
    private static final String id = "id";
    private static final String email = "email";
    private static final String username = "username";
    private static final String password = "password";
    private static final String fullName = "fullName";

    public Database(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + tableName + " (" +
                id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                email + " TEXT NOT NULL, " +
                username + " TEXT NOT NULL, " +
                password + " TEXT NOT NULL, " +
                fullName + " TEXT NOT NULL " + ");";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }

    public boolean dataPush(String Email, String Username, String Password, String FullName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(email, Email);
        values.put(username, Username);
        values.put(password, Password);
        values.put(fullName, FullName);
        long result = db.insert(tableName, null, values);
        return result != -1;
    }

    public Cursor dataPull() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(tableName, new String[] {id, email, username, password, fullName},
                null, null, null, null, null);
    }
}
