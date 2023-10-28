package com.example.live_earth_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{

    private ViewPager mVeiwPager;
    private TabLayout mTabLayout;
    private Toolbar toolBar;
    private TabsAccessorAdaptor tabsAccessorAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolBar=(Toolbar) findViewById(R.id.main_page_Toolbar);
        setSupportActionBar(toolBar);

        getSupportActionBar().setTitle("Live Earth Map");


        mVeiwPager = (ViewPager) findViewById(R.id.View_Pager);
        tabsAccessorAdaptor = new TabsAccessorAdaptor(getSupportFragmentManager());
        mVeiwPager.setAdapter(tabsAccessorAdaptor);


        mTabLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mVeiwPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.location);
        mTabLayout.getTabAt(2).setIcon(R.drawable.sett);



    }

}