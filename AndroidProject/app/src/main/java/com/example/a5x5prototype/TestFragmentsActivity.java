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
    private Button button;
    private String description;
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
        StartTimer();
      //  CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
      //  indicator.setViewPager(viewPager);

        //        editTextInput=(EditText)findViewById(R.id.edit_input_txt);

/*
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.pager, new BenchFragment());
*/
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

//    public void startService(View view) {
//        String input = editTextInput.getText().toString();
//
//        Intent serviceIntent = new Intent(this ,ExampleService.class);
//        serviceIntent.putExtra("inputExtra", input);
//
//        startService(serviceIntent);
//
//        //ContextCompat.startForegroundService(this,serviceIntent);
//    }
//
//
//    public void stopService(View view) {
//        Intent serviceIntent = new Intent(this,ExampleService.class);
//
//        stopService(serviceIntent);
//    }

/*
    public void Alarm(View view) {
        Toast.makeText(this,"Reminder set!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(TestFragmentsActivity.this, ReminderBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(TestFragmentsActivity.this,0,intent,0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long timeAtBtn = System.currentTimeMillis();
        long tenSecInMills = 1000*5;

        alarmManager.set(AlarmManager.RTC_WAKEUP,
                timeAtBtn+tenSecInMills,
                pendingIntent);

    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNotificationChannel(){

            CharSequence name = "ReminderChannel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel("notify", name, importance);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel.setDescription(description);
            }

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


    }*/
}

/*
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".TestFragmentsActivity">


    <androidx.viewpager.widget.ViewPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="650dp">

    </androidx.viewpager.widget.ViewPager>

    <me.relex.circleindicator.CircleIndicator
        android:id="@+id/indicator"
        app:ci_drawable="@drawable/circlebutton2"
        app:ci_height="7dp"
        app:ci_width="7dp"
        app:ci_margin="4dp"
        android:layout_width="match_parent"
        android:layout_height="48dp" />

    <ImageView
        android:layout_gravity="center"
        android:src="@drawable/alarm"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:id="@+id/alarm"
        android:onClick="Alarm"/>


</LinearLayout>

    <!--    <EditText-->
    <!--        android:id="@+id/edit_input_txt"-->
    <!--        android:layout_width="match_parent"-->
    <!--        android:layout_height="wrap_content"-->
    <!--        android:hint="Input"-->
    <!--        tools:ignore="MissingConstraints" />-->

    <!--    <Button-->
    <!--        android:layout_width="match_parent"-->
    <!--        android:layout_height="wrap_content"-->
    <!--        android:text="start Service"-->
    <!--        android:onClick="startService"/>-->
    <!--    <Button-->
    <!--        android:layout_width="match_parent"-->
    <!--        android:layout_height="wrap_content"-->
    <!--        android:text="stop Service"-->
    <!--        android:onClick="stopService"/>-->
 */
