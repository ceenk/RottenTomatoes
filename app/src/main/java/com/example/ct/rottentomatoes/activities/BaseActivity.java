package com.example.ct.rottentomatoes.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;


public abstract class BaseActivity extends ActionBarActivity {

    protected void addFragment(int containerId, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(containerId, fragment);
        ft.commit();
    }

}
