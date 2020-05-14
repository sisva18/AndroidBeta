package com.example.a5x5prototype;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentDemoAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    Context context;


    DatabaseHelper mDatabaseHelper;
    public FragmentDemoAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        DemoFragment demoFragment = new DemoFragment();
        BenchFragment benchFragment = new BenchFragment();
        BarbellRowFragment bbRowFragment = new BarbellRowFragment();
        switch (position)
        {
            case 0: return demoFragment;
            case 1:return benchFragment;
            case 2:return bbRowFragment;
            default:return demoFragment;
        }
    }





    @Override
    public int getCount() {
        return 3;
    }
}
