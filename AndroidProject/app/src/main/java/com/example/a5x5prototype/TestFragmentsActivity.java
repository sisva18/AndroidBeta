package com.example.a5x5prototype;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;

public class TestFragmentsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentDemoAdapter adapter;
    private TextView editTextInput;
    public int counter =120;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragments);
    //    createNotificationChannel();

        editTextInput = (TextView)findViewById(R.id.textView5);

        viewPager = findViewById(R.id.pager);
        adapter = new FragmentDemoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        StartTimer();
    }

    public void StartTimer(){
        new CountDownTimer(120000, 1000){
            public void onTick(long milisUntilFinished){
                editTextInput.setText(String.valueOf(" Rest "+counter));
                counter--;
            }
            public void onFinish(){
                editTextInput.setText("done");
            }
        }.start();
    }
}
