package com.example.ct.rottentomatoes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.models.Movie;
import com.example.ct.rottentomatoes.models.MovieDetail;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;


public class MovieDetailFragment extends Fragment {

    @InjectView(R.id.dPoster)
    ImageView dPoster;
    @InjectView(R.id.dTitle)
    TextView dTitle;
    @InjectView(R.id.criticsScore)
    TextView criticsScore;
    @InjectView(R.id.audienceScore)
    TextView audienceScore;
    @InjectView(R.id.dCast)
    TextView dCast;
    @InjectView(R.id.dReviews)
    Button dReviews;

    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }

    public void onEvent(Movie movie) {
        Picasso.with(getActivity()).load(movie.getPosters().getDetailed()).into(dPoster);
        dTitle.setText(movie.getTitle());
        criticsScore.setText(movie.getRatings().getCriticsScore());
        audienceScore.setText(movie.getRatings().getAudienceScore());
        dCast.setText(movie.getAbridgedCast().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_details, container, false);
        ButterKnife.inject(this, v);
        EventBus.getDefault().register(this);

        return v;
    }


}
