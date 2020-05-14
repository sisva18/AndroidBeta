package com.example.a5x5prototype;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutsActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        ImageView imageView = (ImageView) findViewById(R.id.wo1);
        GradientDrawable drawable = (GradientDrawable) getApplicationContext().getDrawable(R.drawable.roundcorner);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        ImageView imageView2 = (ImageView) findViewById(R.id.wo2);
        GradientDrawable drawable2 = (GradientDrawable) getApplicationContext().getDrawable(R.drawable.roundcorner);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

//        ((Button) findViewById(R.id.workoutA)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WorkoutIntent();
//            }
//        });

//        ((Button) findViewById(R.id.deleteAll)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                delete();
//            }
//        });
        ((CardView) findViewById(R.id.fragmentTest)).setOnClickListener(new View.OnClickListener() {
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
        mDatabaseHelper.deletaALl();
    }

}
