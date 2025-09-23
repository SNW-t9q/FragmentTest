package com.example.fragmenttest.Adapater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyFragmentVPTabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    private List<String> titles;
    public MyFragmentVPTabAdapter(@NonNull FragmentManager fm,List<Fragment> list,List<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? null : titles.get(position);
    }
}
