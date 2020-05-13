package com.example.a5x5prototype;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private static final String TAG = "DatabaseHelper";
    private static final String PROGRESSION_OVERALL = "ProgressionData";
    /*
    private static final String TABLE_SQUAT = "Squat";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    */
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

    public ArrayList<Double> getLastSquatEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Squat", new String[]{"name"},null, null, null, null, null);
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
    public ArrayList<Double> getLastBenchEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BENCHPRESS, new String[]{COL4},null, null, null, null, null);
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

    public ArrayList<Double> getLastOhpEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_OHP, new String[]{COL6},null, null, null, null, null);
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
    public ArrayList<Double> getLastRowEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BBROW, new String[]{COL8},null, null, null, null, null);
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
    public ArrayList<Double> getLastDeadliftEntry(){
        ArrayList<Double> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DEADLIFT, new String[]{COL10},null, null, null, null, null);
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
        Cursor cursor = db.query("Squat", new String[]{"name"},null, null, null, null, null);
        String add = null;
        while(cursor.moveToNext()){

                add=cursor.getString(0);
                data.add(add);

        }
        cursor.close();
        return data;
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
    /*
    public boolean addSquatData(String item) {
        // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// date pattern
        //w  String date = sdf.format(new Date()); //stringify and format new date = current date
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);// only adding the item for now since I want to use it for calculations maybe figure out a way to add the date and so on later.
        //contentValues.put(COL2, "Date: "+ date+ "Squat: " + item);
        Log.d(TAG, "addData: Adding " + item + " to " + "Squat");
        long result = db.insert("Squat", null, contentValues);
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
    */

    public boolean UpdateSquatLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", newMax);
        long result = db.insert("Squat", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateBenchLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, newMax);
        long result = db.insert(TABLE_BENCHPRESS, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateOhpLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, newMax);
        long result = db.insert(TABLE_OHP, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateRowLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL8, newMax);
        long result = db.insert(TABLE_BBROW, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean UpdateDeadliftLatestMax(double newMax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL10, newMax);
        long result = db.insert(TABLE_DEADLIFT, null, contentValues);
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
        String query = "SELECT * FROM " + "Squat";

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
        String query = "SELECT " + "ID" + " FROM " + "Squat" +
                " WHERE " + "name" + " = '" + item + "'";
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
        String query = "UPDATE " + "Squat" + " SET " + "name" +
                " = '" + newName + "' WHERE " + "ID" + " = '" + id + "'" +
                " AND " + "name" + " = '" + oldName + "'";
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
        String query = "DELETE FROM " + "Squat" + " WHERE "
                + "ID" + " = '" + id + "'" +
                " AND " + "name" + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }


}

