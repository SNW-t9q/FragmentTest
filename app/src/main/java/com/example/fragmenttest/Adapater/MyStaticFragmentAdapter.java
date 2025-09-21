package com.example.fragmenttest.Adapater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragmenttest.Fragment.MyFragmentVP;

import java.util.List;

public class MyStaticFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    public MyStaticFragmentAdapter(@NonNull FragmentManager fm,List<Fragment> list) {
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
