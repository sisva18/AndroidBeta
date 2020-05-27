package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMaxesActivityv extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button btnAddSqaut, btnAddBench, btnAddOhp, btnAddBRow, btnAddDeadlift;
    private EditText squatMax, benchMax, ohpMax, bbRowMax, deadliftMax;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_maxes_activityv);
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

        mDatabaseHelper = DatabaseHelper.getInstance(this);


        btnAddSqaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double newEntry = Double.parseDouble(squatMax.getText().toString());
                if (squatMax.length() != 0) {
                    if (newEntry % 1 == 0 || newEntry % 1 == 0.5) {
                        mDatabaseHelper.addEntry(newEntry.toString(), "name", "Squat");
                        squatMax.setText("");
                        //mDatabaseHelper.UpdateLatestMax(mDatabaseHelper.getLastEntry("Squat", "name")+2.5, "Squat", "name"); brug til at update dato
                    } else {
                        Toast.makeText(EditMaxesActivityv.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
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
                        mDatabaseHelper.addEntry(newEntry.toString(), "name", "Bench");
                        benchMax.setText("");
                    } else {
                        Toast.makeText(EditMaxesActivityv.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
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
                        mDatabaseHelper.addEntry(newEntry.toString(), "name", "OHP");
                        ohpMax.setText("");
                    } else {
                        Toast.makeText(EditMaxesActivityv.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
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
                        mDatabaseHelper.addEntry(newEntry.toString(), "name", "BBRow");
                        bbRowMax.setText("");
                    } else {
                        Toast.makeText(EditMaxesActivityv.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
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
                        mDatabaseHelper.addEntry(newEntry.toString(), "name", "Deadlift");
                        deadliftMax.setText("");
                    } else {
                        Toast.makeText(EditMaxesActivityv.this, "ERROR: Can only accept .5 kg", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
