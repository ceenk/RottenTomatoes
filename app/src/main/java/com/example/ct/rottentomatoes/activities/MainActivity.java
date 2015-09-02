package com.example.ct.rottentomatoes.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.adapters.MoviePagerAdapter;
import com.example.ct.rottentomatoes.slidingtab.SlidingTabLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.my_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.pager_movies)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        toolbar.setTitle("Rotten Tomatoes");
        setSupportActionBar(toolbar);

        MoviePagerAdapter moviePagerAdapter = new MoviePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(moviePagerAdapter);

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs_movies);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
