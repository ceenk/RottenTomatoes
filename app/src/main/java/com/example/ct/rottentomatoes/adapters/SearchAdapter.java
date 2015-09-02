package com.example.ct.rottentomatoes.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.models.Movie;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by cT on 10.03.2015.
 */
public class SearchAdapter extends CursorAdapter {

    private List<Movie> movies;
    @InjectView(R.id.searchItem)
    TextView textView;

    public SearchAdapter(Context context, Cursor cursor, List<Movie> movies) {
        super(context, cursor, false);
        this.movies = movies;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lay_search, parent, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        textView.setText(movies.get(cursor.getPosition()).getTitle());
    }
}
