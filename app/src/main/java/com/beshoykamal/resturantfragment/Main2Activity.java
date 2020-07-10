package com.beshoykamal.resturantfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beshoykamal.resturantfragment.fragment.PageFragment1;
import com.beshoykamal.resturantfragment.fragment.PageFragment2;
import com.beshoykamal.resturantfragment.fragment.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ViewPager pager;
    Button skip;
    PagerAdapter pagerAdapter;
    private Context PageFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        List<Fragment> list= new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);


    }
}
