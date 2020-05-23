package com.example.a5x5prototype;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {


    private static final String TAG = "DemoFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    int i=0;



    private TextView txtView, txtViewSet, txtFeedBack;
    private Button setOne, setTwo, setThree, setFour, setFive;

    private int counterOne = 3;
    private int counterTwo= 6;
    private int counterThree = 6;
    private int counterFour= 6;
    private int counterFive= 6;
    private int setsLeft = 5;

    private boolean setOneCompleted = false;
    private boolean setTwoCompleted = false;
    private boolean setThreeCompleted = false;
    private boolean setFourCompleted = false;
    private boolean setFiveCompleted = false;

    private String convertOne;
    private String convertTwo;
    private String convertThree;
    private String convertFour;
    private String convertFive;

    public boolean dataWasSet = false;

    public DemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setsLeft = 5;
        DatabaseHelper db = new DatabaseHelper(getActivity());
        // Inflate the layout for this fragment
        //db.UpdateSquatLatestMax(db.getLastSquatEntryDouble()+2.5); how to insert data into the db
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        txtView = view.findViewById(R.id.txt_Squat);
       // txtViewSet = view.findViewById(R.id. txt_SetsSquat);
        txtFeedBack=view.findViewById(R.id.txt_feedBack);
        txtView.setText("Squat: 5x5: "+db.getLastSquatEntryDouble()*0.8+"KG");

        setOne = view.findViewById(R.id.buttonSet1);
        setTwo=view.findViewById(R.id.buttonSet2);
        setThree=view.findViewById(R.id.buttonSet3);
        setFour=view.findViewById(R.id.buttonSet4);
        setFive=view.findViewById(R.id.buttonSet5);


        //txtViewSet.setText("Sets remaining 5");

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1-i;

                if(i==0){
                   // setOne.setVisibility(View.);
                    setOne.setBackgroundResource(R.drawable.success);
                    txtFeedBack.setText("Congratulations, complete the next 4 sets to increment max!");

                } else{
                    setOne.setBackgroundResource(R.drawable.fail);
                    txtFeedBack.setText("Lift failed, try again next time!");



                }


//                if(counterOne<=0 ){
//                    counterOne = 3;
//                }
//                if(counterOne>0) {
//                    counterOne--;
////                    convertOne = Integer.toString(counterOne);
////                    setOne.setText(convertOne);
//                }
//
//                if(counterOne >= 2  )
//                {
//                    txtFeedBack.setText("Congratulations, complete the next 4 sets to increment max!");
//                    setOneCompleted = true;
//                }
//                if(counterOne < 2 )
//                {
//                    txtFeedBack.setText("Lift failed, try again next time!");
//                }


            }
        });

        setTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1-i;

                if(i==0){
                    // setOne.setVisibility(View.);
                    setTwo.setBackgroundResource(R.drawable.success);
                    txtFeedBack.setText("Congratulations, complete the next 3 sets to increment max!");

                } else {
                    setTwo.setBackgroundResource(R.drawable.fail2);
                    txtFeedBack.setText("Lift failed, try again next time!");
                }

//                if(counterTwo<=0 ){
//                    counterTwo = 6;
//                }
//                if(counterTwo>0) {
//                    counterTwo--;
//                    convertTwo = Integer.toString(counterTwo);
//                    setTwo.setText(convertTwo);
//                }
//
//                if(counterTwo >= 5 )
//                {
//                    txtFeedBack.setText("Congratulations, complete the next 3 sets to increment max!");
//                    setTwoCompleted = true;
//                }
//                if(counterTwo < 5 )
//                {
//                    txtFeedBack.setText("Lift failed, try again next time!");
//                }

            }
        });

        setThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1-i;

                if(i==0){
                    // setOne.setVisibility(View.);
                    setThree.setBackgroundResource(R.drawable.success);
                    txtFeedBack.setText("Congratulations, complete the next 2 sets to increment max!");

                } else{
                    setThree.setBackgroundResource(R.drawable.fail);
                    txtFeedBack.setText("Lift failed, try again next time!");}

//                if(counterThree<=0 ){
//                    counterThree = 6;
//                }
//                if(counterThree>0) {
//                    counterThree--;
//                    convertThree = Integer.toString(counterThree);
//                    setThree.setText(convertThree);
//                }
//
//                if(counterThree >= 5)
//                {
//                    txtFeedBack.setText("Congratulations, complete the next 2 sets to increment max!");
//                    setThreeCompleted = true;
//                }
//                if(counterThree < 5 )
//                {
//                    txtFeedBack.setText("Lift failed, try again next time!");
//                }

            }
        });

        setFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1-i;

                if(i==0){
                    // setOne.setVisibility(View.);
                    setFour.setBackgroundResource(R.drawable.success);
                    txtFeedBack.setText("Congratulations, complete the next 1 sets to increment max!");

                } else{
                    setFour.setBackgroundResource(R.drawable.fail);
                    txtFeedBack.setText("Lift failed, try again next time!");}
//
//                if(counterFour<=0 ){
//                    counterFour = 6;
//                }
//                if(counterFour>0) {
//                    counterFour--;
//                    convertFour = Integer.toString(counterFour);
//                    setFour.setText(convertFour);
//                }
//
//                if(counterFour >= 5 )
//                {
//                    txtFeedBack.setText("Congratulations, complete the next 1 sets to increment max!");
//                    setFourCompleted = true;
//                }
//                if(counterFour < 5 )
//                {
//                    txtFeedBack.setText("Lift failed, try again next time!");
//                }

            }
        });

        setFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i=1-i;

                if(i==0){
                    // setOne.setVisibility(View.);
                    setFive.setBackgroundResource(R.drawable.success);
                    txtFeedBack.setText("Congratulations, squat max increment 2.5Kg");

                } else{
                    setFive.setBackgroundResource(R.drawable.fail);
                    txtFeedBack.setText("Lift failed, try again next time!");}

//                if(counterFive<=0 ){
//                    counterFive = 6;
//                }
//                if(counterFive>0) {
//                    counterFive--;
//                    convertFive = Integer.toString(counterFive);
//                    setFive.setText(convertFive);
//                }
//
//                if(counterFive >= 5 )
//                {
//                    txtFeedBack.setText("Nice you got the reps, you can do it next time!");
//                    setFiveCompleted = true;
//                }
//                if(counterFour < 5 )
//                {
//                    txtFeedBack.setText("Lift failed, try again next time!");
//                }
//                if(counterOne == 5 && counterTwo == 5 && counterThree == 5 && counterFour == 5 && counterFive == 5 )
//                {
//                    txtFeedBack.setText("Congratulations, squat max increment 2.5Kg");
//                    if(!dataWasSet)
//                    {
//                        db.UpdateSquatLatestMax(db.getLastSquatEntryDouble()+2.5);
//                        txtFeedBack.setText("Congratulations, squat max increment 2.5Kg");
//                        dataWasSet = true;
//                    }



              //  }

               if(dataWasSet){
                   setOne.setEnabled(false);
                   setTwo.setEnabled(false);
                   setThree.setEnabled(false);
                   setFour.setEnabled(false);
                   setFive.setEnabled(false);
               }

            }


        });


        return view;
    }


}
