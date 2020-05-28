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

    DatabaseHelper mDatabaseHelper;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        mDatabaseHelper = DatabaseHelper.getInstance(this);
        ImageView imageView = (ImageView) findViewById(R.id.wo1);
        GradientDrawable drawable = (GradientDrawable) getApplicationContext().getDrawable(R.drawable.roundcorner);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        ImageView imageView2 = (ImageView) findViewById(R.id.wo2);
        GradientDrawable drawable2 = (GradientDrawable) getApplicationContext().getDrawable(R.drawable.roundcorner);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        ((CardView) findViewById(R.id.fragmentTest)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frags();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                WorkoutB();
            }
        });

    }

    private void Frags(){
        Intent intent=new Intent(this, TestFragmentsActivity.class);
        startActivity(intent);
    }
    private void WorkoutB(){
        Intent intent=new Intent(this, Workoutb.class);
        startActivity(intent);
    }

}
