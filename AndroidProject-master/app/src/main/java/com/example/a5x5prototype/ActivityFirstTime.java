package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Double newEntry = Double.parseDouble(squatMax.getText().toString());
                if (squatMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addSquatData(newEntry.toString());
                        squatMax.setText("");
                    } else {
                        Toast.makeText(ActivityFirstTime.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        btnAddBench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double newEntry = Double.parseDouble(benchMax.getText().toString());
                if (benchMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addBenchData(newEntry.toString());
                        benchMax.setText("");
                    } else {
                        Toast.makeText(ActivityFirstTime.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        btnAddOhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double newEntry = Double.parseDouble(ohpMax.getText().toString());
                if (ohpMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addOhpData(newEntry.toString());
                        ohpMax.setText("");
                    } else {
                    Toast.makeText(ActivityFirstTime.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnAddBRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double newEntry = Double.parseDouble(bbRowMax.getText().toString());
                if (bbRowMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addRowData(newEntry.toString());
                        bbRowMax.setText("");
                    } else {
                        Toast.makeText(ActivityFirstTime.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnAddDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double newEntry = Double.parseDouble(deadliftMax.getText().toString());
                if (deadliftMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addDeadliftData(newEntry.toString());
                        deadliftMax.setText("");
                    } else {
                        Toast.makeText(ActivityFirstTime.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }




    private void MainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
