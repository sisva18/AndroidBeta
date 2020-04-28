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
    private Button addSquatReps, addBenchReps, addDeadliftReps;
    private EditText squatEditText, benchEditText, deadliftEditText;
    private TextView textViewSquat, textViewBench, textViewDeadlift;
    public int setsLeftSquat, repsLeft, repsLeftSquat, repsBench, setsBench, repsCheck, deadliftReps, setsDeadlift;

    public boolean failedSquat=false;
    public boolean dataWasSetSquat=false;
    public boolean failedBench = false;
    public boolean dataWasSetBench = false;
    public boolean failedDeadlift=false;
    public boolean dataWasSetDeadlift = false;


    DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_a_activity);
        addSquatReps = (Button) findViewById(R.id.addFirst);
        squatEditText = (EditText) findViewById(R.id.editText2);
        textViewSquat = (TextView) findViewById(R.id.tView);

        addBenchReps = (Button) findViewById(R.id.benchP);
        benchEditText = (EditText) findViewById(R.id.editText3);
        textViewBench = (TextView) findViewById(R.id.textView2);

        addDeadliftReps = (Button) findViewById(R.id.deadliftBtn);
        benchEditText = (EditText) findViewById(R.id.editText4);
        textViewBench = (TextView) findViewById(R.id.textView3);



        repsLeft = 5;
        repsLeftSquat = 5;
        setsLeftSquat = 5;



         //getting last entry from squat
        ArrayList<Double> dataSquat = mDatabaseHelper.getLastSquatEntry();
        double []arrSquat =  new double [dataSquat.size()];
        for(int j=0; j<dataSquat.size();j++) {
            double convert = dataSquat.get(j);
            arrSquat[j] = convert;
        }
        // getting last entry from bench
        ArrayList<Double> dataBench = mDatabaseHelper.getLastBenchEntry();
        double []arrBench =  new double [dataBench.size()];
        for(int j=0; j<dataBench.size();j++) {
            double convert = dataBench.get(j);
            arrBench[j] = convert;
        }


        //converting to double from Double
        for(double d : arrSquat){
            Log.d(TAG, ""+d);
            textViewSquat.setText("Sets left: "+Integer.toString(setsLeftSquat)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
        }

        Log.d(TAG, mDatabaseHelper.getAllFromSquat().toString() );
        addSquatReps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int currentReps = Integer.parseInt(squatEditText.getText().toString());
                //if user fails take 10% of the remaining lifts in the given exercise
                if (currentReps < repsLeft || failedSquat==true && currentReps >=5 ){
                    setsLeftSquat--;
                    repsLeftSquat--;
                    failedSquat = true;
                    //if repsleft1 int is less than repsleft = 5 or if boolean failed = true and currentreps is 5 or bigger
                    if(repsLeftSquat<repsLeft || failedSquat && currentReps >=5){
                        for(double d : arrSquat){
                            Log.d(TAG, ""+currentReps);
                            textViewSquat.setText("Sets left: "+Integer.toString(setsLeftSquat)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.7+"KG ");
                        }

                        if(setsLeftSquat==0 || setsLeftSquat <0){
                            textViewSquat.setText("Sqaut failed try again next time!");
                            for(double d : arrSquat){
                                Log.d(TAG, ""+currentReps);
                                //insert the same max
                                if(!dataWasSetSquat)
                                {
                                    mDatabaseHelper.UpdateSquatLatestMax(d);
                                    dataWasSetSquat=true;
                                }

                            }

                        }
                    }
                }
                //if user succeds given exercise it will increment the max with 2.5kg
                if(currentReps >= 5 && failedSquat == false ){
                    setsLeftSquat--;
                    for(double d : arrSquat){
                        Log.d(TAG, ""+currentReps);
                        textViewSquat.setText("Sets left: "+Integer.toString(setsLeftSquat)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
                    }

                    if(setsLeftSquat==0 || setsLeftSquat <= 0){
                        for(double d : arrSquat){
                            Log.d(TAG, ""+d);
                            textViewSquat.setText("Completed the lift will ad 2.5kg to next workout!");
                            // insert new max +2.5kg

                            setsLeftSquat = 0;
                            if(!dataWasSetSquat)
                            {
                                mDatabaseHelper.UpdateSquatLatestMax(d+2.5);
                                dataWasSetSquat=true;
                            }
                        }

                    }


                }


            }

        });
       /* addBenchReps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int currentRepsBench = Integer.parseInt(benchEditText.getText().toString());
                //if user fails take 10% of the remaining lifts in the given exercise
                if (currentRepsBench < repsLeft || failedBench==true && currentRepsBench >=5 ){
                    setsLeft--;
                    repsLeftSquat--;
                    failedBench = true;
                    //if repsleft1 int is less than repsleft = 5 or if boolean failed = true and currentreps is 5 or bigger
                    if(repsLeftSquat<repsLeft || failedBench && currentRepsBench >=5){
                        for(double d : arrBench){
                            Log.d(TAG, ""+currentRepsBench);
                            textViewSquat.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.7+"KG ");
                        }

                        if(setsLeft==0 || setsLeft <0){
                            textViewSquat.setText("Sqaut failed try again next time!");
                            for(double d : arrBench){
                                Log.d(TAG, ""+currentRepsBench);
                                //insert the same max
                                if(!dataWasSetBench)
                                {
                                    mDatabaseHelper.UpdateBenchLatestMax(d);
                                    dataWasSetBench=true;
                                }

                            }

                        }
                    }
                }
                //if user succeds given exercise it will increment the max with 2.5kg
                if(currentRepsBench >= 5 && failedBench == false ){
                    setsLeft--;
                    for(double d : arrBench){
                        Log.d(TAG, ""+currentRepsBench);
                        textViewSquat.setText("Sets left: "+Integer.toString(setsLeft)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
                    }

                    if(setsLeft==0 || setsLeft <= 0){
                        for(double d : arrBench){
                            Log.d(TAG, ""+d);
                            textViewSquat.setText("Completed the lift will ad 2.5kg to next workout!");
                            // insert new max +2.5kg

                            setsLeft = 0;
                            if(!dataWasSetBench)
                            {
                                mDatabaseHelper.UpdateBenchLatestMax(d+2.5);
                                dataWasSetBench=true;
                            }
                        }

                    }


                }


            }

        });*/


    }

}





  /*
        ArrayList<Double> data = mDatabaseHelper.getLastEntry();
        data = new ArrayList<>(Arrays.asList(data));
        double[] arr = data.stream().mapToDouble(Double::doubleValue).toArray();
*/