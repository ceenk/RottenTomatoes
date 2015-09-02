package com.example.ct.rottentomatoes.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.adapters.SearchAdapter;
import com.example.ct.rottentomatoes.models.Movie;

import java.util.List;

/**
 * Created by cT on 10.03.2015.
 */
public class SearchResultActivity extends Activity {

    private List<Movie> movies;
    private Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                loadData(query);
                return true;
            }
        });

        return true;
    }

    private void loadData(String query) {
        String[] columns =  new String[] {"_id", "title"};
        Object[] temp = new Object[] {0, "default"};

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for(int i = 0; i < movies.size(); i++) {
            temp[0] = i;
            temp[1] = movies.get(i);
            matrixCursor.addRow(temp);
        }

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSuggestionsAdapter(new SearchAdapter(this, matrixCursor, movies));
    }
}
