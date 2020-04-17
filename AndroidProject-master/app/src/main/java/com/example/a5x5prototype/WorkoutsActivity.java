package com.example.a5x5prototype;

import android.content.Intent;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;


import android.view.View;
import android.widget.Button;

public class WorkoutsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        ((Button) findViewById(R.id.workoutA)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutIntent();
            }
        });

    }

    private void WorkoutIntent(){
        Intent intent=new Intent(this, WorkoutAActivity.class);
        startActivity(intent);
    }

}
