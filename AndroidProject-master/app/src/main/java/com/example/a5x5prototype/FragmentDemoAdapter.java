package com.example.a5x5prototype;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentDemoAdapter extends FragmentPagerAdapter {
    public FragmentDemoAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        position = position +1;
        bundle.putString("message", "hello from page:"+position);
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
