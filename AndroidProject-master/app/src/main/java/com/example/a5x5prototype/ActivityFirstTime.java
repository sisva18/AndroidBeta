package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityFirstTime extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText firstTimer;
    MaxesActivity maxes;

    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
        btnAdd = (Button) findViewById(R.id.btnFirst);
        firstTimer = (EditText) findViewById(R.id.editText5);
        mDatabaseHelper = new DatabaseHelper(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = firstTimer.getText().toString();
                if (firstTimer.length() != 0) {
                    mDatabaseHelper.addData(newEntry);
                    firstTimer.setText("");
                    counter++;
                } else {
                    maxes.toastMessage("You must put something in the text field!");
                }
                if(counter!=0){
                    MainActivity();
                    // its kinda working still have to figure out how to show it first when it is new user
                }
            }
        });

    }




    private void MainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
