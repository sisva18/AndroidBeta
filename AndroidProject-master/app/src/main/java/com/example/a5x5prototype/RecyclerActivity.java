package com.example.a5x5prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerViewLift);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.lifts));
        adapter = new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
