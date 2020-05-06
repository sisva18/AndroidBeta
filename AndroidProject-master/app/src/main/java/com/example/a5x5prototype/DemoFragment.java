package com.example.a5x5prototype;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private TextView txtView;
    public DemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHelper db = new DatabaseHelper(getActivity());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        txtView = view.findViewById(R.id.txt_display);
        String message = getArguments().getString("message");
        txtView.setText(db.getLastSquatEntryDouble()*0.8+"KG");


        return view;
    }
}
