package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutAActivity extends AppCompatActivity {
    private static final String TAG = "WorkoutAActivity";
    private Button addFirst;
    private EditText editText2;
    private TextView textView;
    public int setsLeft, repsLeft;


    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_a_activity);
        addFirst = (Button) findViewById(R.id.addFirst);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.tView);

        repsLeft = 5;
        setsLeft = 5;
        //textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft));


        ArrayList<String> data = mDatabaseHelper.getAll();
        Log.d(TAG, data.toString());


        addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setsLeft--;

               // textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft));






                if(setsLeft==0){
                    textView.setText("Sqaut completed move on to next exercise");
                    setsLeft = 0;
                }
                if(repsLeft<repsLeft){
                    //deload 10% database update
                    //didnt make it

                }
                if(repsLeft>=6){
                    //to many reps
                }
                if(repsLeft==repsLeft){
                    //made the set
                }
            }
        });

    }

}
