package com.example.ct.rottentomatoes.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.applications.MyApplication;
import com.example.ct.rottentomatoes.fragments.MovieDetailFragment;
import com.example.ct.rottentomatoes.models.Movie;
import com.example.ct.rottentomatoes.models.MovieDetail;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;


public class MovieDetailActivity extends BaseActivity {
    @InjectView(R.id.my_second_toolbar)
    Toolbar toolbar;
    @InjectView(R.id.my_second_frame)
    FrameLayout mySecondFrame;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MovieDetailActivity.class);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Rotten Tomatoes");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(savedInstanceState == null) {
            addFragment(R.id.my_second_frame, MovieDetailFragment.newInstance());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
