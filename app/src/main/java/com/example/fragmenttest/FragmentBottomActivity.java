package com.example.fragmenttest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmenttest.Fragment.BottomFragment;

public class FragmentBottomActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout llHome,llFind,llMine;
    private TextView tvHome,tvFine,tvMine;
    private ImageView ivHome, ivFind,ivMine;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_bottom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        initEvent();
    }

    private void initView() {
        llHome = findViewById(R.id.ll_home);
        llFind = findViewById(R.id.ll_find);
        llMine = findViewById(R.id.ll_mine);

        tvHome = findViewById(R.id.tv_home);
        tvFine = findViewById(R.id.tv_find);
        tvMine = findViewById(R.id.tv_mine);

        ivHome = findViewById(R.id.iv_home);
        ivFind = findViewById(R.id.iv_find);
        ivMine = findViewById(R.id.iv_mine);
    }

    private void initEvent() {
        llHome.setOnClickListener(this);
        llFind.setOnClickListener(this);
        llMine.setOnClickListener(this);
        Log.d("tag","----click----");

    }


    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if(viewId == R.id.ll_home){
            BottomFragment bottomFragment = BottomFragment.newInstance("这是首页","");
            fragmentManager.beginTransaction().replace(R.id.fragment,bottomFragment).commit();
            tvHome.setTextColor(getResources().getColor(R.color.green_home,getTheme()));
            ivHome.setSelected(true);
            ivFind.setSelected(false);
            ivMine.setSelected(false);
            tvMine.setTextColor(getResources().getColor(R.color.black,getTheme()));
            tvFine.setTextColor(getResources().getColor(R.color.black,getTheme()));

        }else if(viewId == R.id.ll_find){
            BottomFragment bottomFragment = BottomFragment.newInstance("这是发现页","");
            fragmentManager.beginTransaction().replace(R.id.fragment,bottomFragment).commit();
            tvFine.setTextColor(getResources().getColor(R.color.green_home,getTheme()));
            ivHome.setSelected(false);
            ivFind.setSelected(true);
            ivMine.setSelected(false);
            tvMine.setTextColor(getResources().getColor(R.color.black,getTheme()));
            tvHome.setTextColor(getResources().getColor(R.color.black,getTheme()));

        } else if (viewId == R.id.ll_mine) {
            BottomFragment bottomFragment = BottomFragment.newInstance("这是个人页","");
            fragmentManager.beginTransaction().replace(R.id.fragment,bottomFragment).commit();
            tvMine.setTextColor(getResources().getColor(R.color.green_home,getTheme()));
            ivHome.setSelected(false);
            ivFind.setSelected(false);
            ivMine.setSelected(true);
            tvHome.setTextColor(getResources().getColor(R.color.black,getTheme()));
            tvFine.setTextColor(getResources().getColor(R.color.black,getTheme()));

        }

    }
}