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
    public int setsLeft, repsLeft, repsLeft1;
    public double d;
    public boolean failed=false;

    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_a_activity);
        addFirst = (Button) findViewById(R.id.addFirst);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.tView);
        editText2 = (EditText) findViewById(R.id.editText2);
        repsLeft = 5;
        repsLeft1 = 5;
        setsLeft = 5;



         //getting last entry
        ArrayList<Double> data = mDatabaseHelper.getLastEntry();
        double []arrX =  new double [data.size()];
        for(int j=0; j<data.size();j++) {
            double convert = data.get(j);
            arrX[j] = convert;

        }
        //converting to double from Double
        for(double d : arrX){
            Log.d(TAG, ""+d);
            textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
        }

        Log.d(TAG, mDatabaseHelper.getAll().toString() );
        addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int currentReps = Integer.parseInt(editText2.getText().toString());
                //if user fails take 10% of the remaining lifts in the given exercise
                if (currentReps < repsLeft || failed==true && currentReps >=5 ){
                    setsLeft--;
                    repsLeft1--;
                    failed = true;
                    //if repsleft1 int is less than repsleft = 5 or if boolean failed = true and currentreps is 5 or bigger
                    if(repsLeft1<repsLeft || failed==true && currentReps >=5){
                        for(double d : arrX){
                            Log.d(TAG, ""+currentReps);
                            textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.7+"KG ");
                        }

                        if(setsLeft==0 || setsLeft <0){
                            textView.setText("Sqaut failed try again next time!");
                            for(double d : arrX){
                                Log.d(TAG, ""+currentReps);
                                //insert the same max
                                mDatabaseHelper.updateLatestMax(d);
                            }

                        }
                    }
                }
                //if user succeds given exercise it will increment the max with 2.5kg
                if(currentReps >= 5 && failed == false ){
                    setsLeft--;
                    for(double d : arrX){
                        Log.d(TAG, ""+currentReps);
                        textView.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
                    }

                    if(setsLeft==0 || setsLeft <= 0){
                        for(double d : arrX){
                            Log.d(TAG, ""+d);
                            textView.setText("Completed the lift will ad 2.5kg to next workout!");
                            // insert new max +2.5kg
                            mDatabaseHelper.updateLatestMax(d+2.5);
                            setsLeft = 0;
                        }

                    }


                }


            }
        });

    }

}





  /*
        ArrayList<Double> data = mDatabaseHelper.getLastEntry();
        data = new ArrayList<>(Arrays.asList(data));
        double[] arr = data.stream().mapToDouble(Double::doubleValue).toArray();
*/