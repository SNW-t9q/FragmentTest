package com.example.fragmenttest;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmenttest.Fragment.BlankStaticFragment;

public class BlankDynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blank_dynamic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //当手机旋转时，会重新创建fragment
        Log.d("tag","---------" + savedInstanceState + "--------------");
        //因此需要做一个优化
        if(savedInstanceState == null){
            //1.首先获取当前页面的FragmentManager
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            //2.获取处理事务对象
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            //3.为事务添加操作
            fragmentTransaction.add(R.id.fragment, BlankStaticFragment.class,null)
                    .setReorderingAllowed(true)//允许顺序被改变，一种优化
//                    .addToBackStack(null)//添加这个fragment进入栈，相当于退出这个fragment不是退出页面而是返回上一个fragment
                    .commit();
            //
        }

    }
}