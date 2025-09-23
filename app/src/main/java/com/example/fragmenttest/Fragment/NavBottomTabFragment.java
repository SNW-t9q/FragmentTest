package com.example.fragmenttest.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenttest.Adapater.MyFragmentVPTabAdapter;
import com.example.fragmenttest.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NavBottomTabFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private List<String> titles;

    private MyFragmentVPTabAdapter myFragmentVPTabAdapter;

    public NavBottomTabFragment() {
        // Required empty public constructor
    }

    public static NavBottomTabFragment newInstance(String param1, String param2) {
        NavBottomTabFragment fragment = new NavBottomTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_bottom_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.Tab);
        viewPager = view.findViewById(R.id.VP);
        initData();
        viewPager.setAdapter(myFragmentVPTabAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initData() {
        list = new ArrayList<>();
        list.add(MyFragmentVP.newInstance("推荐",""));
        list.add(MyFragmentVP.newInstance("关注",""));
        list.add(MyFragmentVP.newInstance("娱乐",""));
        list.add(MyFragmentVP.newInstance("汽车",""));
        list.add(MyFragmentVP.newInstance("历史",""));
        list.add(MyFragmentVP.newInstance("地理",""));

        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("关注");
        titles.add("娱乐");
        titles.add("汽车");
        titles.add("历史");
        titles.add("地理");

        myFragmentVPTabAdapter = new MyFragmentVPTabAdapter(getChildFragmentManager(),list,titles);
    }
}