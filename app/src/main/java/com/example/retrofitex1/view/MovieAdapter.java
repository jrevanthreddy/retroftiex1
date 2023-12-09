package com.example.retrofitex1.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitex1.MovieDetails;
import com.example.retrofitex1.R;
import com.example.retrofitex1.databinding.MoviesItemListBinding;
import com.example.retrofitex1.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;
    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MoviesItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movies_item_list, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.moviesItemListBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MoviesItemListBinding moviesItemListBinding;

        public MovieViewHolder(MoviesItemListBinding moviesItemListBinding) {
            super(moviesItemListBinding.getRoot());
            this.moviesItemListBinding = moviesItemListBinding;

            moviesItemListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Movie clickedMovie = movieArrayList.get(position);
                        navigateToMovieDetails(clickedMovie);
                    }
                }
            });
        }
    }
    private void navigateToMovieDetails(Movie movie){
        Intent intent = new Intent(context, MovieDetails.class);

        intent.putExtra("image",movie.getPosterPath());
        intent.putExtra("movieTitle",movie.getTitle());
        intent.putExtra("overview",movie.getOverview());
        intent.putExtra("backdropPath",movie.getBackdropPath());
        intent.putExtra("releaseDate",movie.getReleaseDate());
        intent.putExtra("originalLanguage",movie.getOriginalLanguage());
        intent.putExtra("voteAverage",movie.getOriginalTitle());

        context.startActivity(intent);
    }
}
