package com.example.avion.gamesnewsp2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.avion.gamesnewsp2.fragments.*;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    int numTabs;


    public FragmentPagerAdapter(FragmentManager fm, int numeroDeTabs) {
        super(fm);
        this.numTabs = numeroDeTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Generals tab1 = new Generals();
                return tab1;
            case 1:
                TopPlayers tab2 = new TopPlayers();
                return tab2;
            case 2:
                Images tab3 = new Images();
                return tab3;
            default:
                return null;
        }//switch
    }



    @Override
    public int getCount() {
        return numTabs;
    }
}
