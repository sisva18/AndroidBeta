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
        deadliftEditText = (EditText) findViewById(R.id.editText4);
        textViewDeadlift = (TextView) findViewById(R.id.textView3);



        repsLeft = 5;
        repsLeftSquat = 5;
        setsLeftSquat = 5;
        repsBench = 5;
        setsBench = 5;
        deadliftReps = 5;
        setsDeadlift = 5;

         //getting last entry from squat
        ArrayList<Double> dataSquat = mDatabaseHelper.getLastSquatEntry();
        double []arrSquat =  new double [dataSquat.size()];
        for(int j=0; j<dataSquat.size();j++) {
            double convertSquat = dataSquat.get(j);
            arrSquat[j] = convertSquat;
        }
        // getting last entry from bench
        ArrayList<Double> dataBench = mDatabaseHelper.getLastBenchEntry();
        double []arrBench =  new double [dataBench.size()];
        for(int j=0; j<dataBench.size();j++) {
            double convertBench = dataBench.get(j);
            arrBench[j] = convertBench;
        }
        //last entry from deadssss
        ArrayList<Double> dataDeads = mDatabaseHelper.getLastDeadliftEntry();
        double []arrDeads =  new double [dataDeads.size()];
        for(int j=0; j<dataDeads.size();j++) {
            double convertDeads = dataDeads.get(j);
            arrDeads[j] = convertDeads;

        }
        for(double d : arrDeads){
            Log.d(TAG, ""+d);
            textViewDeadlift.setText("Sets left: "+Integer.toString(setsDeadlift)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
        }
        for(double d : arrBench){
            Log.d(TAG, ""+d);
            textViewBench.setText("Sets left: "+Integer.toString(setsBench)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
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
       addBenchReps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int currentRepsBench = Integer.parseInt(benchEditText.getText().toString());
                //if user fails take 10% of the remaining lifts in the given exercise
                if (currentRepsBench < repsLeft || failedBench==true && currentRepsBench >=5 ){
                    setsBench--;
                    repsBench--;
                    failedBench = true;
                    //if repsleft1 int is less than repsleft = 5 or if boolean failed = true and currentreps is 5 or bigger
                    if(repsBench<repsLeft || failedBench && currentRepsBench >=5){
                        for(double d : arrBench){
                            Log.d(TAG, ""+currentRepsBench);
                            textViewBench.setText("Sets left: "+Integer.toString(setsBench)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.7+"KG ");
                        }

                        if(setsBench==0 || setsBench <0){
                            textViewBench.setText("Bench press failed try again next time!");
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
                    setsBench--;
                    for(double d : arrBench){
                        Log.d(TAG, ""+currentRepsBench);
                        textViewBench.setText("Sets left: "+Integer.toString(setsBench)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
                    }

                    if(setsBench==0 || setsBench <= 0){
                        for(double d : arrBench){
                            Log.d(TAG, ""+d);
                            textViewBench.setText("Completed the lift will ad 2.5kg to next workout!");
                            // insert new max +2.5kg

                            setsBench = 0;
                            if(!dataWasSetBench)
                            {
                                mDatabaseHelper.UpdateBenchLatestMax(d+2.5);
                                dataWasSetBench=true;
                            }
                        }

                    }


                }


            }

        });

        addDeadliftReps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                int currentRepsDeads = Integer.parseInt(deadliftEditText.getText().toString());
                //if user fails take 10% of the remaining lifts in the given exercise
                if (currentRepsDeads < repsLeft || failedDeadlift && currentRepsDeads >=5 ){
                    setsDeadlift--;
                    deadliftReps--;
                    failedDeadlift = true;
                    //if repsleft1 int is less than repsleft = 5 or if boolean failed = true and currentreps is 5 or bigger
                    if(deadliftReps<repsLeft || failedDeadlift && currentRepsDeads >=5){
                        for(double d : arrDeads){
                            Log.d(TAG, ""+currentRepsDeads);
                            textViewDeadlift.setText("Sets left: "+Integer.toString(setsDeadlift)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.7+"KG ");
                        }

                        if(setsDeadlift==0 || setsDeadlift <0){
                            textViewDeadlift.setText("Deadlift failed try again next time!");
                            for(double d : arrBench){
                                Log.d(TAG, ""+currentRepsDeads);
                                //insert the same max
                                if(!dataWasSetDeadlift)
                                {
                                    mDatabaseHelper.UpdateDeadliftLatestMax(d);
                                    dataWasSetDeadlift=true;
                                }

                            }

                        }
                    }
                }
                //if user succeds given exercise it will increment the max with 2.5kg
                if(currentRepsDeads >= 5 && !failedDeadlift ){
                    setsDeadlift--;
                    for(double d : arrDeads){
                        Log.d(TAG, ""+currentRepsDeads);
                        textViewDeadlift.setText("Sets left: "+Integer.toString(setsDeadlift)+" Reps : "+Integer.toString(repsLeft) + " "+d*0.8+"KG ");
                    }

                    if(setsDeadlift==0 || setsDeadlift <= 0){
                        for(double d : arrDeads){
                            Log.d(TAG, ""+d);
                            textViewDeadlift.setText("Completed the lift will ad 2.5kg to next workout!");
                            // insert new max +2.5kg

                            setsDeadlift = 0;
                            if(!dataWasSetDeadlift)
                            {
                                mDatabaseHelper.UpdateDeadliftLatestMax(d+2.5);
                                dataWasSetDeadlift=true;
                            }
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