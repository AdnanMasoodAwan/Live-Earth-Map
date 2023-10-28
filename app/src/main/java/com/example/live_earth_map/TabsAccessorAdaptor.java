package com.example.live_earth_map;

import android.graphics.drawable.Icon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/** @noinspection ALL*/
public class TabsAccessorAdaptor extends FragmentPagerAdapter
{

    int[]   imagesList={R.drawable.home,R.drawable.location,R.drawable.sett};

    public TabsAccessorAdaptor(@NonNull FragmentManager fm)
    {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position)
    {

        switch (position)
        {
            case 0:
              HomeFragment   homeFragment = new HomeFragment();
                return homeFragment;


            case 1:
                MapToolsFragment mapToolsFragment = new MapToolsFragment();
                return mapToolsFragment;



            case 2:
               SettingFragment settingFragment = new SettingFragment();
                return settingFragment;



            default:
                return null;

        }


    }


    @Override
    public int getCount()
    {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {

        switch (position)
        {

            case 0:

                return "Home";

            case 1:

                return "MapsTools";


            case 2:
                return "Settings";



            default:
                return null;

        }

    }



}
