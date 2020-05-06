package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class TestFragmentsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentDemoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragments);
        viewPager = findViewById(R.id.pager);
        adapter = new FragmentDemoAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

    }
}
