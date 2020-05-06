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

    DatabaseHelper mDatabaseHelper;
    private TextView txtView, txtViewSet, txtFeedBack;
    private Button setOne;
    private int counter = 6;
    private String convert;
    public DemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHelper db = new DatabaseHelper(getActivity());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        txtView = view.findViewById(R.id.txt_Squat);
       // txtViewSet = view.findViewById(R.id. txt_SetsSquat);
        txtFeedBack=view.findViewById(R.id.txt_feedBack);

        setOne = view.findViewById(R.id.buttonSet1);
        txtView.setText("Squat: 5x5: "+db.getLastSquatEntryDouble()*0.8+"KG");
        //txtViewSet.setText("Sets remaining 5");

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<=0){
                    counter = 6;
                }
                if(counter>0) {
                    counter--;
                    convert = Integer.toString(counter);
                    setOne.setText(convert);
                }

                if(counter >= 5 )
                {
                    txtFeedBack.setText("Congratulations, complete the next 4 sets to increment max!");
                }
                if(counter < 5)
                {
                    txtFeedBack.setText("Lift failed, try again next time!");
                }
            }
        });
        return view;
    }


}
