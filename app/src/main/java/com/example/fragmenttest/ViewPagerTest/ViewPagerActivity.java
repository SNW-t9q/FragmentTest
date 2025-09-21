package com.example.fragmenttest.ViewPagerTest;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.fragmenttest.Adapater.MyViewPagerAdapater;
import com.example.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<ImageView> list;
    private MyViewPagerAdapater myViewPagerAdapater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_pager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewPager = findViewById(R.id.viewPager);
        initData();
        viewPager.setAdapter(myViewPagerAdapater);

    }

    private void initData() {
        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        ImageView imageView4 = new ImageView(this);
        ImageView imageView5 = new ImageView(this);
        imageView1.setImageResource(R.drawable.test1);
        imageView2.setImageResource(R.drawable.test2);
        imageView3.setImageResource(R.drawable.test3);
        imageView4.setImageResource(R.drawable.test4);
        imageView5.setImageResource(R.drawable.test5);
        list = new ArrayList<>();
        list.add(imageView1);
        list.add(imageView2);
        list.add(imageView3);
        list.add(imageView4);
        list.add(imageView5);
        myViewPagerAdapater = new MyViewPagerAdapater(list);
    }
}