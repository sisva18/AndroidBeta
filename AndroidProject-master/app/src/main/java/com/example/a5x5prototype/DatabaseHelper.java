package com.example.a5x5prototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "progression_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Squat";
    private static final String COL3 = "Bench";
    private static final String COL4 = "Deadlift";
    private static final String COL5 = "Row";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +"TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, "Date "+ date +" Sqaut: "+ item +"Kg"); // just some info to give with the date + lift for database

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Return the last data from the database
     * @return
     */
   /* public String getLastData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{COL2};
        Cursor data = db.query(TABLE_NAME, columns, null,null,null,null,null) ;



        String result="";
        int colTwo=data.getColumnIndex(COL2);
        data.moveToLast();
        result = data.getString(colTwo);


        return result;

    }*/

    public Cursor getLast(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL2 + "  FROM " + TABLE_NAME + " ORDER "+ " BY "+ " ID " + " DESC LIMIT 1" ; //actually not buggin with the right query but ye still not getting how i can use it in my activity

        Cursor cursor = db.rawQuery(query, null);

        return cursor;


    }



    /**
     * Returns only the ID that matches the name passed in
     * @param name
     * @return
     */

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }


}

