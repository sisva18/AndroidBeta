package com.example.a5x5prototype;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private TextView workOut, maxes, firstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workOut = (TextView)findViewById(R.id.workout);
        workOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutIntent();
            }
        });

        maxes = (TextView)findViewById(R.id.Maxes);
        maxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaxesIntent();
            }
        });

        firstTime = (TextView)findViewById(R.id.FirstT);
        firstTime.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, EditMaxesActivityv.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
