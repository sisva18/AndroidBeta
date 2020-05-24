package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ListDataActivity extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = DatabaseHelper.getInstance(this);

        populateListView();
        PopUpMenu();

    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData("Squat");
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                //toastMessage("clicked on: " + name);
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getID("Squat", name); //get the id associated with that name
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    //toastMessage("id = " + itemID);
                    Intent editScreenIntent = new Intent(ListDataActivity.this, EditActivity.class);

                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name",name);
                    editScreenIntent.putExtra("table", "Squat");
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that name");
                }

            }

        });
    }

    public void PopUpMenu(){
        Button btn = (Button) findViewById(R.id.exlist);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ListDataActivity.this, v);
                popup.inflate(R.menu.pop_up);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ListDataActivity.this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.m1:
                                // do your code
                                BenchList();
                                return true;
                            case R.id.m2:
                                // do your code
                                OhpList();
                                return false;
                            case R.id.m3:
                                // do your code
                                RowList();
                                return true;
                            case R.id.m4:
                                // do your code
                                DeadliftList();
                                return false;
                            default:
                                return false;
                        }
                    }
                });
            }
        });

    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    private void BenchList(){
        Intent intent = new Intent(this, BenchListActivity.class);
        startActivity(intent);
    }

    private void OhpList(){
        Intent intent = new Intent(this, OhpListActivity.class);
        startActivity(intent);
    }
    private void RowList(){
        Intent intent = new Intent(this, RowListActivity.class);
        startActivity(intent);
    }

    private void DeadliftList(){
        Intent intent = new Intent(this, DeadliftActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(ListDataActivity.this, MainActivity.class));
    }
}
