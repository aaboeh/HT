package com.example.ht;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class TabPagerAdapter extends FragmentStateAdapter {

    private MainActivity mainActivity;

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity, MainActivity mainActivity) {
        super(fragmentActivity);
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            //Bundle data = new Bundle();
            //data.putString("dataID", mainActivity.getMunicipalityName());

            InfoFragment iFragment = new InfoFragment();
            //iFragment.setArguments(data);

            return iFragment;

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
