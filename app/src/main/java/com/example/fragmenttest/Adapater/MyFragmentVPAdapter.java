package com.example.fragmenttest.Adapater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fragmenttest.Fragment.MyFragmentVP;

import java.util.List;

public class MyFragmentVPAdapter extends FragmentPagerAdapter {
    private List<MyFragmentVP> list;

    public MyFragmentVPAdapter(@NonNull FragmentManager fm,List<MyFragmentVP> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }
}
