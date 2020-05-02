package com.example.a5x5prototype;

import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Boolean firstTime = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("firstTime", true);
        if(firstTime){
            startActivity(new Intent(MainActivity.this, ActivityFirstTime.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }

        getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit()
                .putBoolean("firstTime", false).commit();

                //First time app open not working atm
       */

        ((Button) findViewById(R.id.workouts)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutIntent();
            }
        });
        ((Button) findViewById(R.id.maxes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxesIntent();
            }
        });

        ((Button) findViewById(R.id.testFirst)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });




    }

    private void WorkoutIntent(){
        Intent intent=new Intent(this, WorkoutsActivity.class);
        startActivity(intent);
    }
    private void MaxesIntent(){
        Intent intent = new Intent(this, ListDataActivity.class);
        startActivity(intent);
    }
    private void test(){
        Intent intent = new Intent(this, ActivityFirstTime.class);
        startActivity(intent);
    }



    private void finishActivity(){
        finish();
    }
}
