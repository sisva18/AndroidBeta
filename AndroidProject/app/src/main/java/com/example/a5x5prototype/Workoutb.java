package com.example.a5x5prototype;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.viewpager.widget.ViewPager;

        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.widget.TextView;

public class Workoutb extends AppCompatActivity {
    private ViewPager viewPager;
    private WorkoutbAdapter adapter;
    private static TextView editTextInput;
    public static Boolean execueted =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutb);
        editTextInput = (TextView)findViewById(R.id.textView5);
        viewPager = findViewById(R.id.pager);
        adapter = new WorkoutbAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }

    public static void StartTimer(){
        new CountDownTimer(120000, 1000){


            public void onTick(long milisUntilFinished){

                editTextInput.setText(String.valueOf(" Rest "+milisUntilFinished/1000));
                execueted = true;


            }


            public void onFinish(){
                editTextInput.setText("Lift again");
                execueted = false;
            }
        }.start();

    }
}