package com.example.a5x5prototype;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class WorkoutAActivity extends AppCompatActivity {
    private static final String TAG = "WorkoutAActivity";
    private Button addFirst;
    private EditText editText2;
    private TextView textView;
    public int setsLeft, repsLeft;


    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_a_activity);
        addFirst = (Button) findViewById(R.id.addFirst);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.tView);

        repsLeft = 5;
        setsLeft = 5;



        ArrayList<Double> data = mDatabaseHelper.getLastEntry();
        double []arrX =  new double [data.size()];
        for(int j=0; j<data.size();j++) {
            double convert = data.get(j);
            arrX[j] = convert;

        }
        for(double d : arrX){
            Log.d(TAG, ""+d);
            textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
        }
        /*
         ArrayList<Double> data = mDatabaseHelper.getLastEntry();


        data = new ArrayList<>(Arrays.asList(data));
        double[] arr = data.stream().mapToDouble(Double::doubleValue).toArray();

*/










        addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setsLeft--;

               // textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) +"KG ");






                if(setsLeft==0){
                    textView.setText("Sqaut completed move on to next exercise");
                    setsLeft = 0;
                }
                if(repsLeft<repsLeft){
                    //deload 10% database update
                    //didnt make it

                }
                if(repsLeft>=6){
                    //to many reps
                }
                if(repsLeft==repsLeft){
                    //made the set
                }
            }
        });

    }

}
