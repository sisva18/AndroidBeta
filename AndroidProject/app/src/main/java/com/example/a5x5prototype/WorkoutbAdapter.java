package com.example.a5x5prototype;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WorkoutbAdapter extends FragmentPagerAdapter {
    public WorkoutbAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        SquatFragment demoFragment = new SquatFragment();
        OhpFragment ohpFragment = new OhpFragment();
        DeadliftFragment deadliftFragment = new DeadliftFragment();
        switch (position)
        {
            case 0: return demoFragment;
            case 1:return ohpFragment;
            case 2:return deadliftFragment;
            default:return demoFragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
