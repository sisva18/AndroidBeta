package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class Workoutb extends AppCompatActivity {
    private ViewPager viewPager;
    private WorkoutbAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutb);

        viewPager = findViewById(R.id.pager);
        adapter = new WorkoutbAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }
}
