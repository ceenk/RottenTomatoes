package com.example.ct.rottentomatoes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.adapters.LinearListMovieAdapter;
import com.example.ct.rottentomatoes.adapters.MoviePagerAdapter;
import com.example.ct.rottentomatoes.adapters.MyAdapter;
import com.example.ct.rottentomatoes.applications.MyApplication;
import com.example.ct.rottentomatoes.models.Movie;
import com.example.ct.rottentomatoes.models.Movies;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.WaspError;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MyFragment extends Fragment implements CallBack<Movies> {
    public static final String ARG_PAGE = "ARG_PAGE";

    private MoviePagerAdapter.PAGES page;
    private int pageLimit = 16;
    private int limit = 16;
    private int currentPosition = 0;

    @InjectView(R.id.movieList)
    RecyclerView recyclerView;

    public static MyFragment newInstance(MoviePagerAdapter.PAGES page){
        Bundle args = new Bundle();
        args.putSerializable(ARG_PAGE, page);
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = (MoviePagerAdapter.PAGES) getArguments().getSerializable(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lay_fragment, container, false);
        ButterKnife.inject(this, v);
        switch (page) {
            case BOX_OFFICE:
            case UPCOMING:
                GridLayoutManager myGrid = new GridLayoutManager(getActivity().getBaseContext(), 2);
                myGrid.setOrientation(GridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(myGrid);
                break;
            case IN_THEATERS:
            case OPENING:
            default:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                break;
        }
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromNetwork();
        if(savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("currentFragment", 0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentFragment", currentPosition);
    }

    private void getDataFromNetwork() {
        switch (page) {
            case BOX_OFFICE:
                MyApplication.getService().getBoxOffice(limit, this);
                break;
            case UPCOMING:
                MyApplication.getService().getUpcoming(pageLimit, this);
                break;
            case IN_THEATERS:
                MyApplication.getService().getInTheaters(pageLimit, this);
                break;
            case OPENING:
                MyApplication.getService().getOpening(limit, this);
                break;
            default:
                break;
        }
    }

    private void setAdapter(List<Movie> movies) {
        switch (page) {
            case BOX_OFFICE:
            case UPCOMING:
                MyAdapter myAdapter = new MyAdapter(getActivity(), movies);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);
                break;
            case IN_THEATERS:
            case OPENING:
                LinearListMovieAdapter linearListMovieAdapter = new LinearListMovieAdapter(getActivity(), movies);
                recyclerView.setAdapter(linearListMovieAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);
                break;
        }

    }

    @Override
    public void onSuccess(Movies movies) {
        setAdapter(movies.getMovies());
    }

    @Override
    public void onError(WaspError error) {
        Toast.makeText(getActivity(), "There was an error while getting the movie list", Toast.LENGTH_SHORT).show();
    }

}
