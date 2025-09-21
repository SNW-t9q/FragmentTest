package com.example.fragmenttest.ViewPagerTest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.fragmenttest.Adapater.MyFragmentVPAdapter;
import com.example.fragmenttest.Fragment.MyFragmentVP;
import com.example.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentVPActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<MyFragmentVP> list;
    private MyFragmentVPAdapter myFragmentVPAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_vpactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewPager = findViewById(R.id.FragmentVP);
        initData();
        viewPager.setAdapter(myFragmentVPAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(FragmentVPActivity.this, "这是第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        MyFragmentVP myFragmentVP1 = MyFragmentVP.newInstance("这是Fragment1","");
        MyFragmentVP myFragmentVP2 = MyFragmentVP.newInstance("这是Fragment2","");
        MyFragmentVP myFragmentVP3 = MyFragmentVP.newInstance("这是Fragment3","");
        MyFragmentVP myFragmentVP4 = MyFragmentVP.newInstance("这是Fragment4","");
        MyFragmentVP myFragmentVP5 = MyFragmentVP.newInstance("这是Fragment5","");
        list = new ArrayList<>();
        list.add(myFragmentVP1);
        list.add(myFragmentVP2);
        list.add(myFragmentVP3);
        list.add(myFragmentVP4);
        list.add(myFragmentVP5);
        myFragmentVPAdapter = new MyFragmentVPAdapter(getSupportFragmentManager(),list);
    }
}