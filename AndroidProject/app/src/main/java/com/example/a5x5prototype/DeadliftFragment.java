package com.example.a5x5prototype;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DeadliftFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TextView txtView, txtFeedBack;
    private Button setOne, setTwo, setThree, setFour, setFive;

    private boolean setOneCompleted = false;
    private boolean setTwoCompleted = false;
    private boolean setThreeCompleted = false;
    private boolean setFourCompleted = false;
    private boolean setFiveCompleted = false;

    public boolean dataWasSet = false;

    public DeadliftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHelper db = new DatabaseHelper(getActivity());
        View view = inflater.inflate(R.layout.fragment_deadlift, container, false);
        txtView = view.findViewById(R.id.txt_Squat);
        txtFeedBack=view.findViewById(R.id.txt_feedBack);
        txtView.setText("Deadlift: 5x5: "+db.getLastEntry("Deadlift", "name")*0.8+"KG");

        setOne = view.findViewById(R.id.buttonSet1);
        setTwo=view.findViewById(R.id.buttonSet2);
        setThree=view.findViewById(R.id.buttonSet3);
        setFour=view.findViewById(R.id.buttonSet4);
        setFive=view.findViewById(R.id.buttonSet5);

        setOneCompleted = false;
        setTwoCompleted = false;
        setThreeCompleted = false;
        setFourCompleted = false;
        setFiveCompleted = false;

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!setTwoCompleted) {
                    if (!setOneCompleted) {
                        // setOne.setVisibility(View.);
                        setOne.setBackgroundResource(R.drawable.success);
                        txtFeedBack.setText("Congratulations, complete the next 4 sets to increment max!");
                        setOneCompleted = true;
                    } else {
                        setOne.setBackgroundResource(R.drawable.fail);
                        setTwo.setBackgroundResource(R.drawable.n2);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setOneCompleted = false;
                    }
                }
            }
        });

        setTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (setOneCompleted && !setThreeCompleted) {
                    if (!setTwoCompleted) {
                        // setOne.setVisibility(View.);
                        setTwo.setBackgroundResource(R.drawable.success);
                        txtFeedBack.setText("Congratulations, complete the next 3 sets to increment max!");
                        setTwoCompleted = true;
                    } else {
                        setTwo.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setThree.setBackgroundResource(R.drawable.n3);
                        setTwoCompleted = false;
                    }
                }
            }
        });

        setThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setTwoCompleted && !setFourCompleted) {
                    if (!setThreeCompleted) {
                        // setOne.setVisibility(View.);
                        setThree.setBackgroundResource(R.drawable.success);
                        txtFeedBack.setText("Congratulations, complete the next 2 sets to increment max!");
                        setThreeCompleted = true;
                    } else {
                        setThree.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setFour.setBackgroundResource(R.drawable.n4);
                        setThreeCompleted = false;
                    }
                }
            }
        });

        setFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setThreeCompleted && ! setFiveCompleted) {
                    if (!setFourCompleted) {
                        // setOne.setVisibility(View.);
                        setFour.setBackgroundResource(R.drawable.success);
                        txtFeedBack.setText("Congratulations, complete the next 1 sets to increment max!");
                        setFourCompleted = true;
                    } else {
                        setFour.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setFive.setBackgroundResource(R.drawable.n5);
                        setFourCompleted = false;
                    }
                }
            }
        });

        setFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setFourCompleted) {
                    if (!setFiveCompleted) {
                        // setOne.setVisibility(View.);
                        setFive.setBackgroundResource(R.drawable.success);
                        txtFeedBack.setText("Congratulations, deadlift max increment 2.5Kg");
                        db.UpdateLatestMax(db.getLastEntry("Deadlift", "name")+2.5, "Deadlift", "name");
                        setFiveCompleted = true;
                    } else {
                        setFive.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        db.UpdateLatestMax(db.getLastEntry("Deadlift", "name"), "Deadlift", "name");
                        setFiveCompleted = false;
                    }
                }

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
