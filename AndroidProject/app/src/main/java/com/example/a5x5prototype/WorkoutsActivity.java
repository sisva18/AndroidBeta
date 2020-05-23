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

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        mDatabaseHelper = DatabaseHelper.getInstance(this);
        ((Button) findViewById(R.id.workoutA)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutIntent();
            }
        });

        ((Button) findViewById(R.id.deleteAll)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        ((Button) findViewById(R.id.fragmentTest)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frags();
            }
        });

    }

    private void WorkoutIntent(){
        Intent intent=new Intent(this, WorkoutAActivity.class);
        startActivity(intent);
    }
    private void Frags(){
        Intent intent=new Intent(this, TestFragmentsActivity.class);
        startActivity(intent);
    }

    private void delete(){
        mDatabaseHelper.deleteALl();
    }

}
