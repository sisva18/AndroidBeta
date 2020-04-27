package com.example.a5x5prototype;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MaxesActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maxes);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaxesActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addSquatData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     * @param message
     */
    public void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
