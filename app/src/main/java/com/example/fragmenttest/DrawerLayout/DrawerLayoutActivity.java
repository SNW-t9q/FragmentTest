package com.example.fragmenttest.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fragmenttest.Fragment.MyFragmentVP;
import com.example.fragmenttest.R;
import com.google.android.material.navigation.NavigationView;

public class DrawerLayoutActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drawer_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
//      同步ActionBarDrawerToggle注册为DrawerLayout的监听器，以便在抽屉状态改变时得到通知
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//      同步ActionBarDrawerToggle的状态，确保HomeAsUpIndicator图标正确显示当前抽屉状态
        actionBarDrawerToggle.syncState();

        setHomeFragment();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_home) {
                    setHomeFragment();
                } else if (menuItem.getItemId() == R.id.menu_find) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment, MyFragmentVP.newInstance("发现",""))
                            .commit();
                    toolbar.setTitle("发现");
                } else if (menuItem.getItemId() == R.id.menu_mine) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment, MyFragmentVP.newInstance("个人",""))
                            .commit();
                    toolbar.setTitle("个人");
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, MyFragmentVP.newInstance("首页",""))
                .commit();
        toolbar.setTitle("首页");
        navigationView.setCheckedItem(R.id.menu_home);
    }
}