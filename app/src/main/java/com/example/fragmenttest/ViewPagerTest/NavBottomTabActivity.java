package com.example.fragmenttest.ViewPagerTest;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.fragmenttest.Adapater.MyStaticFragmentAdapter;
import com.example.fragmenttest.Fragment.MyFragmentVP;
import com.example.fragmenttest.Fragment.NavBottomTabFragment;
import com.example.fragmenttest.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class NavBottomTabActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MyStaticFragmentAdapter myStaticFragmentAdapter;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nav_bottom_tab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0); // 👈 底部 padding 设为 0
            return insets;
        });
        View rootView = findViewById(R.id.main);
        rootView.requestLayout();
        viewPager = findViewById(R.id.FragmentVP);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        initData();
        viewPager.setAdapter(myStaticFragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(NavBottomTabActivity.this, "这是第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                setSelectedItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.menu_home){
                    viewPager.setCurrentItem(0);
                }else if(menuItem.getItemId() == R.id.menu_find){
                    viewPager.setCurrentItem(1);
                }else if(menuItem.getItemId() == R.id.menu_mine){
                    viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.menu_mine);
        badge.setNumber(1000);
        badge.setMaxCharacterCount(3);
    }

    private void setSelectedItem(int position) {
        switch (position){
            case 0 :
                bottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1 :
                bottomNavigationView.setSelectedItemId(R.id.menu_find);
                break;
            case 2 :
                bottomNavigationView.removeBadge(R.id.menu_mine);
                bottomNavigationView.setSelectedItemId(R.id.menu_mine);
                break;
        }
    }

    private void initData() {
        NavBottomTabFragment myFragmentVP1 = NavBottomTabFragment.newInstance("这是Fragment1","");
        MyFragmentVP myFragmentVP2 = MyFragmentVP.newInstance("这是Fragment2","");
        MyFragmentVP myFragmentVP3 = MyFragmentVP.newInstance("这是Fragment3","");
        list = new ArrayList<>();
        list.add(myFragmentVP1);
        list.add(myFragmentVP2);
        list.add(myFragmentVP3);
        myStaticFragmentAdapter = new MyStaticFragmentAdapter(getSupportFragmentManager(),list);
    }

}