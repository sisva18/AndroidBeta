package com.example.a5x5prototype;

        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import android.os.CountDownTimer;
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
public class SquatFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    private TextView txtView, txtFeedBack, txtViewTimer;
    private Button setOne, setTwo, setThree, setFour, setFive;

    private boolean setOneCompleted = false;
    private boolean setTwoCompleted = false;
    private boolean setThreeCompleted = false;
    private boolean setFourCompleted = false;
    private boolean setFiveCompleted = false;

    public boolean dataWasSet = false;

    public SquatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            setOneCompleted = savedInstanceState.getBoolean("setOneCompleted");
            setTwoCompleted = savedInstanceState.getBoolean("setTwoCompleted");
            setThreeCompleted = savedInstanceState.getBoolean("setThreeCompleted");
            setFourCompleted = savedInstanceState.getBoolean("setFourCompleted");
            setFiveCompleted = savedInstanceState.getBoolean("setFiveCompleted");
            dataWasSet = savedInstanceState.getBoolean("dataWasSet");

        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("setOneCompleted",setOneCompleted);
        outState.putBoolean("setTwoCompleted",setTwoCompleted);
        outState.putBoolean("setThreeCompleted",setThreeCompleted);
        outState.putBoolean("setFourCompleted",setFourCompleted);
        outState.putBoolean("setFiveCompleted",setFiveCompleted);
        outState.putBoolean("dataWasSet",dataWasSet);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHelper db = new DatabaseHelper(getActivity());
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        txtView = view.findViewById(R.id.txt_Squat);

        txtFeedBack=view.findViewById(R.id.txt_feedBack);
        txtView.setText("Squat: 5x5: "+db.getLastEntry("Squat", "name")*0.8+"KG");

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
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }

                    } else {
                        setOne.setBackgroundResource(R.drawable.fail);
                        setTwo.setBackgroundResource(R.drawable.n2);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setOneCompleted = false;
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }


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
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }

                    } else {
                        setTwo.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setThree.setBackgroundResource(R.drawable.n3);
                        setTwoCompleted = false;

                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }
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
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }

                    } else {
                        setThree.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setFour.setBackgroundResource(R.drawable.n4);
                        setThreeCompleted = false;
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }
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

                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }
                    } else {
                        setFour.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        setFive.setBackgroundResource(R.drawable.n5);
                        setFourCompleted = false;
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }

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
                        txtFeedBack.setText("Congratulations, squat max increment 2.5Kg");
                        db.UpdateLatestMax(db.getLastEntry("Squat", "name")+2.5, "Squat", "name");
                        setFiveCompleted = true;
                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }
                    } else {
                        setFive.setBackgroundResource(R.drawable.fail);
                        txtFeedBack.setText("Lift failed, try again next time!");
                        db.UpdateLatestMax(db.getLastEntry("Squat", "name"), "Squat", "name");
                        setFiveCompleted = false;

                        if(TestFragmentsActivity.execueted==false){
                            TestFragmentsActivity.StartTimer();
                        }

                        
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
