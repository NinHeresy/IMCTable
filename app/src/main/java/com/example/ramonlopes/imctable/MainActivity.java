package com.example.ramonlopes.imctable;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.ramonlopes.imctable.adapter.PageTabs;

public class MainActivity extends AppCompatActivity {

    public ViewPager mViewPage;
    public TabLayout mTabLayout;
    public Toolbar mToobar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToobar = (Toolbar) findViewById(R.id.my_tooblar);
        mToobar.setTitle("Indice de Massa Corporal");
        setSupportActionBar(mToobar);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPage = (ViewPager) findViewById(R.id.view_page);



        mViewPage.setAdapter(new PageTabs(getSupportFragmentManager(), getResources().getStringArray(R.array.title_tabs)));
        mTabLayout.setTabTextColors(ContextCompat.getColorStateList(this,R.color.tab_colors));
        mTabLayout.setupWithViewPager(mViewPage);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_child) {
            return true;
        }
        if (id == R.id.to_tutorial) {
            return true;
        }
        if (id == R.id.old_man) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}