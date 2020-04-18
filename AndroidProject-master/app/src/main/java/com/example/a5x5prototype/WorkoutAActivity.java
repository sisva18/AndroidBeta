package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WorkoutAActivity extends AppCompatActivity {

    private Button addFirst;
    private EditText editText2;
    private TextView textView;
    public int setsLeft, repsLeft;
    private String test = null;
    DatabaseHelper mDatabaseHelper;
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



        addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setsLeft--;

                textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft));



                 //mDatabaseHelper.getLastData();

                //textView.setText(mDatabaseHelper.getLastData());


                if(setsLeft==0){
                    textView.setText("Sqaut completed move on to next exercise");

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
