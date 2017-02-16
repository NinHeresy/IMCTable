package com.example.ramonlopes.imctable.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ramonlopes.imctable.fragmets.TableOne;
import com.example.ramonlopes.imctable.fragmets.TableThree;
import com.example.ramonlopes.imctable.fragmets.TableTwo;

/**
 * Created by Ramon Lopes on 10/02/2017.
 */

public class PageTabs extends FragmentPagerAdapter {
    private String[] mTabTitles;

    public PageTabs(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TableOne();
            case 1:
                return new TableTwo();
            case 2:
                return new TableThree();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
