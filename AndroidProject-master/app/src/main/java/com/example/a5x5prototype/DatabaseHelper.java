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

    private static final String TAG = "DatabaseHelper";
    public static String PROGRESSION_OVERALL = "ProgressionData";// using this to initiate the whole database static so only one instance of database
    private static final String TABLE_SQUAT = "Sqaut";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";

    private static final String TABLE_BENCHPRESS = "Bench";
    private static final String COL3 = "ID";
    private static final String COL4 = "name";

    private static final String TABLE_OHP = "OHP";
    private static final String COL5 = "ID";
    private static final String COL6 = "name";

    private static final String TABLE_BBROW = "BBROW";
    private static final String COL7 = "ID";
    private static final String COL8 = "name";

    private static final String TABLE_DEADLIFT = "DEADLIFT";
    private static final String COL9 = "ID";
    private static final String COL10 = "name";


    public DatabaseHelper(Context context) {
        super(context, PROGRESSION_OVERALL , null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createSquatTable = "CREATE TABLE " + TABLE_SQUAT + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";
        String createBenchTable = "CREATE TABLE " + TABLE_BENCHPRESS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL4 +" TEXT)";
        String createOHPTable = "CREATE TABLE " + TABLE_OHP + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL6 +" TEXT)";
        String createRowTable = "CREATE TABLE " + TABLE_BBROW + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL8 +" TEXT)";
        String createDeadliftTable = "CREATE TABLE " + TABLE_DEADLIFT + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL10 +" TEXT)";


        db.execSQL(createSquatTable);
        db.execSQL(createBenchTable);
        db.execSQL(createOHPTable);
        db.execSQL(createRowTable);
        db.execSQL(createDeadliftTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BENCHPRESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SQUAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OHP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BBROW);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEADLIFT);
        onCreate(db);
    }

    public ArrayList<Double> getLastSquatEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_SQUAT, new String[]{COL2},null, null, null, null, null);
        Double add = null;
        while(cursor.moveToNext()){
            if(cursor.moveToLast()){
                add=cursor.getDouble(0);
                data.add(add);
            }
        }
        cursor.close();
        return data;
    }

    public ArrayList<String> getAllFromSquat(){
        ArrayList<String> data = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_SQUAT, new String[]{COL2},null, null, null, null, null);
        String add = null;
        while(cursor.moveToNext()){

                add=cursor.getString(0);
                data.add(add);

        }
        cursor.close();
        return data;
    }



    public boolean addSquatData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_SQUAT);
        long result = db.insert(TABLE_SQUAT, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addBenchData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_BENCHPRESS);
        long result = db.insert(TABLE_BENCHPRESS, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addOhpData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_OHP);
        long result = db.insert(TABLE_OHP, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addRowData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_BBROW);
        long result = db.insert(TABLE_BBROW, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addDeadliftData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_DEADLIFT);
        long result = db.insert(TABLE_DEADLIFT, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }




    public boolean UpdateSquatLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, newMax);
        long result = db.insert(TABLE_SQUAT, null, contentValues);
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
    public Cursor getSquatData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SQUAT;

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getBenchData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BENCHPRESS;

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getOhpData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_OHP;

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getRowData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BBROW;

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getDeadliftData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DEADLIFT;

        Cursor data = db.rawQuery(query, null);
        return data;
    }


    /**
     * Returns only the ID that matches the name passed in
     * @param item
     * @return
     */
    public Cursor getSquatID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_SQUAT +
                " WHERE " + COL2 + " = '" + item + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getBenchID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL3 + " FROM " + TABLE_BENCHPRESS +
                " WHERE " + COL4 + " = '" + item + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getOhpID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL5 + " FROM " + TABLE_OHP +
                " WHERE " + COL6 + " = '" + item + "'";
        Cursor data = db.rawQuery(query, null);
        return data;

    }

    public Cursor getRowID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL7 + " FROM " + TABLE_BBROW +
                " WHERE " + COL8 + " = '" + item + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getDeadliftID(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL9 + " FROM " + TABLE_DEADLIFT +
                " WHERE " + COL10 + " = '" + item + "'";
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
        String query = "UPDATE " + TABLE_SQUAT + " SET " + COL2 +
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
        String query = "DELETE FROM " + TABLE_SQUAT + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }


}

