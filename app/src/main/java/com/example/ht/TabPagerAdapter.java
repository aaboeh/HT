package com.example.ht;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new InfoFragment();
        } else if (position == 1) {
            return new CompareFragment();
        } else if (position == 2) {
            return new QuizFragment();
        } else {
            return new InfoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
