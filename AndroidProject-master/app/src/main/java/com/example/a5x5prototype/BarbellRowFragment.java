package com.example.a5x5prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BarbellRowFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    private TextView txtView, txtViewSet, txtFeedBack;
    private Button setOne, setTwo, setThree, setFour, setFive, finish;
    private EditText editTextInput;

    private int counterOne = 6;
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

    private boolean dataWasSet = false;

    public BarbellRowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setsLeft = 5;
        DatabaseHelper db = new DatabaseHelper(getActivity());
        // Inflate the layout for this fragment
        //db.UpdateSquatLatestMax(db.getLastSquatEntryDouble()+2.5); how to insert data into the db
        View view = inflater.inflate(R.layout.fragment_bbrow, container, false);
        txtView = view.findViewById(R.id.txt_Squat);
        // txtViewSet = view.findViewById(R.id. txt_SetsSquat);
        txtFeedBack=view.findViewById(R.id.txt_feedBack);

        txtView.setText("Row: 5x5: "+db.getLastRowEntry()*0.8+"KG");

        setOne = view.findViewById(R.id.buttonSet1);
        setTwo=view.findViewById(R.id.buttonSet2);
        setThree=view.findViewById(R.id.buttonSet3);
        setFour=view.findViewById(R.id.buttonSet4);
        setFive=view.findViewById(R.id.buttonSet5);
//        finish=view.findViewById(R.id.finish);
//        editTextInput=view.findViewById(R.id.edit_input_txt);


        //txtViewSet.setText("Sets remaining 5");

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterOne<=0 ){
                    counterOne = 6;
                }
                if(counterOne>0) {
                    counterOne--;
                    convertOne = Integer.toString(counterOne);
                    setOne.setText(convertOne);
                }

                if(counterOne >= 5  )
                {
                    txtFeedBack.setText("Congratulations, complete the next 4 sets to increment max!");
                    setOneCompleted = true;
                }
                if(counterOne < 5 )
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }


            }
        });

        setTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterTwo<=0 ){
                    counterTwo = 6;
                }
                if(counterTwo>0) {
                    counterTwo--;
                    convertTwo = Integer.toString(counterTwo);
                    setTwo.setText(convertTwo);
                }

                if(counterTwo >= 5 )
                {
                    txtFeedBack.setText("Congratulations, complete the next 3 sets to increment max!");
                    setTwoCompleted = true;
                }
                if(counterTwo < 5 )
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }

            }
        });

        setThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterThree<=0 ){
                    counterThree = 6;
                }
                if(counterThree>0) {
                    counterThree--;
                    convertThree = Integer.toString(counterThree);
                    setThree.setText(convertThree);
                }

                if(counterThree >= 5)
                {
                    txtFeedBack.setText("Congratulations, complete the next 2 sets to increment max!");
                    setThreeCompleted = true;
                }
                if(counterThree < 5 )
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }

            }
        });

        setFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterFour<=0 ){
                    counterFour = 6;
                }
                if(counterFour>0) {
                    counterFour--;
                    convertFour = Integer.toString(counterFour);
                    setFour.setText(convertFour);
                }

                if(counterFour >= 5 )
                {
                    txtFeedBack.setText("Congratulations, complete the next 1 sets to increment max!");
                    setFourCompleted = true;
                }
                if(counterFour < 5 )
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }

            }
        });

        setFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counterFive<=0 ){
                    counterFive = 6;
                }
                if(counterFive>0) {
                    counterFive--;
                    convertFive = Integer.toString(counterFive);
                    setFive.setText(convertFive);
                }

                if(counterFive >= 5 )
                {
                    txtFeedBack.setText("Nice you got the reps, you can do it next time!");
                    setFiveCompleted = true;
                }
                if(counterFour < 5 )
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }
                if(counterOne == 5 && counterTwo == 5 && counterThree == 5 && counterFour == 5 && counterFive == 5 )
                {
                    txtFeedBack.setText("Congratulations, squat max increment 2.5Kg");
                    if(!dataWasSet)
                    {
                        db.UpdateRowLatestMax(db.getLastRowEntry()+2.5);
                        txtFeedBack.setText("Congratulations, row max increment 2.5Kg");
                        dataWasSet = true;
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

//        finish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                main();
//            }
//        });

        return view;
    }
//
//    public void startSerivce(View v){
//        String input = editTextInput.getText().toString();
//
//        Intent serviceIntent = new Intent(getActivity(),ExampleService.class);
//        serviceIntent.putExtra("inputExtra", input);
//
//        getActivity().startService(new Intent(serviceIntent));
//
//
//    }
//
//    public void stopSerivce(View v){
//        Intent serviceIntent = new Intent(getActivity(),ExampleService.class);
//
//        getActivity().stopService(new Intent(serviceIntent));
//
//    }

    private void main(){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
