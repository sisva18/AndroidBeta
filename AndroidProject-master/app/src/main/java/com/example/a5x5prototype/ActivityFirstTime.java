package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityFirstTime extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private Button btnAddSqaut, btnAddBench, btnAddOhp, btnAddBRow, btnAddDeadlift;
    private EditText squatMax, benchMax, ohpMax, bbRowMax, deadliftMax;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
        btnAddSqaut = (Button) findViewById(R.id.btnFirst);
        squatMax = (EditText) findViewById(R.id.editText5);

        btnAddBench = (Button) findViewById(R.id.btnFirst1);
        benchMax = (EditText) findViewById(R.id.editText6);

        btnAddOhp = (Button) findViewById(R.id.btnFirst2);
        ohpMax = (EditText) findViewById(R.id.editText7);

        btnAddBRow = (Button) findViewById(R.id.btnFirst3);
        bbRowMax = (EditText) findViewById(R.id.editText8);

        btnAddDeadlift = (Button) findViewById(R.id.btnFirst4);
        deadliftMax = (EditText) findViewById(R.id.editText9);

        mDatabaseHelper = new DatabaseHelper(this);


        btnAddSqaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = squatMax.getText().toString();
                if (squatMax.length() != 0) {
                    mDatabaseHelper.addSquatData(newEntry);

                    squatMax.setText("");

                }

            }
        });


        btnAddBench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = benchMax.getText().toString();
                if (benchMax.length() != 0) {
                    mDatabaseHelper.addBenchData(newEntry);
                    benchMax.setText("");

                }

            }
        });

        btnAddOhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = ohpMax.getText().toString();
                if (ohpMax.length() != 0) {
                    mDatabaseHelper.addOhpData(newEntry);
                    ohpMax.setText("");

                }

            }
        });

        btnAddBRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = bbRowMax.getText().toString();
                if (bbRowMax.length() != 0) {
                    mDatabaseHelper.addRowData(newEntry);
                    bbRowMax.setText("");

                }

            }
        });

        btnAddDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = deadliftMax.getText().toString();
                if (deadliftMax.length() != 0) {
                    mDatabaseHelper.addDeadliftData(newEntry);
                    deadliftMax.setText("");

                }

            }
        });

    }




    private void MainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
