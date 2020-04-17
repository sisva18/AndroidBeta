package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_a_activity);
        addFirst = (Button) findViewById(R.id.addFirst);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        String parseInts=editText2.getText().toString();
        int value = 0;
        repsLeft = 5;
        setsLeft = 5;
        textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(setsLeft));
        addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}
