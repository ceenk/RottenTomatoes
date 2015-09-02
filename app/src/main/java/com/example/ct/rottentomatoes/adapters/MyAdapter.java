package com.example.ct.rottentomatoes.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ct.rottentomatoes.R;
import com.example.ct.rottentomatoes.activities.MainActivity;
import com.example.ct.rottentomatoes.activities.MovieDetailActivity;
import com.example.ct.rottentomatoes.fragments.MyFragment;
import com.example.ct.rottentomatoes.models.Movie;
import com.example.ct.rottentomatoes.models.MovieDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private List<Movie> movies;

    public MyAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new MyHolder(v);

    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, final int position) {
        final Movie movie = movies.get(position);

        myHolder.title.setText(movie.getTitle());
        myHolder.synopsis.setText(movie.getSynopsis());
        Picasso.with(context).load(movie.getPosters().getThumbnail()).into(myHolder.poster);
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                EventBus.getDefault().post(new MyAdapter(context, movies));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.card_view) CardView cardView;
        @InjectView(R.id.title) TextView title;
        @InjectView(R.id.poster) ImageView poster;
        @InjectView(R.id.synopsis) TextView synopsis;
        public MyHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }
}
