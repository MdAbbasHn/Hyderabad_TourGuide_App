package com.examples.tourguideapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CategoriesFragmentAdapter extends FragmentStatePagerAdapter {
    public CategoriesFragmentAdapter(FragmentManager fm){
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new HistoricalFragment();
        }
        else if(position==1){
            return new FoodFragment();
        }
        else if(position==2){
            return new ShoppingFragment();
        }
        else{
            return new HotelFragment();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Historical Places";
        }
        else if(position==1){
            return "Food";
        }
        else if(position==2){
            return "Shopping Malls";
        }
        else{
            return "Hotels";
        }
    }
}
