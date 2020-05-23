package com.example.a5x5prototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private static final String TAG = "DatabaseHelper";
    private static final String PROGRESSION_OVERALL = "ProgressionData";

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public DatabaseHelper(Context context) {
        super(context, PROGRESSION_OVERALL , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Squat(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("CREATE TABLE Bench(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("CREATE TABLE OHP(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("CREATE TABLE BBRow(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("CREATE TABLE Deadlift(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Squat");
        db.execSQL("DROP TABLE IF EXISTS Bench");
        db.execSQL("DROP TABLE IF EXISTS OHP");
        db.execSQL("DROP TABLE IF EXISTS BBRow");
        db.execSQL("DROP TABLE IF EXISTS Deadlift");
        onCreate(db);
    }

    public boolean addEntry(String item, String col, String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col, item);
        Log.d(TAG, "addData: Adding " + item + " to " + table);
        long result = db.insert(table, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public double getLastEntry(String table, String col) {
        double data = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table, new String[]{col},null, null, null, null, null);

        while(cursor.moveToNext()){
            if(cursor.moveToLast()){

                data =cursor.getDouble(0);
            }
        }
        cursor.close();
        return data;
    }

    public void UpdateLatestMax(double value, String table, String col){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col, value);
        long result = db.insert(table, null, contentValues);
    }

    //Returns all the data from database
    public Cursor getData(String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + table;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //Returns only the ID that matches the name passed in
    public Cursor getID(String table, String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT ID FROM " + table + " WHERE name = '" + item + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //Updates the name field
    public void updateName(String table, String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + table + " SET name = '" + newName + "' WHERE ID = '" + id + "'" + " AND name = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    //Delete from database
    public void deleteName(String table, int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + table + " WHERE ID = '" + id + "'" + " AND name = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

    public void deleteALl(){
        SQLiteDatabase db = this.getWritableDatabase();
        String squat = "DELETE FROM Squat";
        String row = "DELETE FROM BBRow";
        String bench = "DELETE FROM Bench";
        String ohp = "DELETE FROM OHP";
        String deadlift = "DELETE FROM Deadlift";
        db.execSQL(squat);
        db.execSQL(row);
        db.execSQL(bench);
        db.execSQL(ohp);
        db.execSQL(deadlift);
    }

}

