package com.example.retrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import com.example.retrofitex1.databinding.ActivityMovieDetailsBinding;
import com.example.retrofitex1.model.Movie;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

       ActivityMovieDetailsBinding activityMovieDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details);

       String movieTitle = getIntent().getStringExtra("movieTitle");
       String overview = getIntent().getStringExtra("overview");
       String image = getIntent().getStringExtra("image");
       String backdropPath = getIntent().getStringExtra("backdropPath");
       String releaseDate = getIntent().getStringExtra("releaseDate");
       String originalLanguage = getIntent().getStringExtra("originalLanguage");
       String originalTitle =  getIntent().getStringExtra("originalTitle");

       Movie movie = new Movie();

       movie.setTitle(movieTitle);
       movie.setOverview(overview);
       movie.setPosterPath(image);
       movie.setBackdropPath(backdropPath);
       movie.setReleaseDate(releaseDate);
       movie.setOriginalLanguage(originalLanguage);
       movie.setOriginalTitle(originalTitle);

       activityMovieDetailsBinding.setMovie(movie);
       activityMovieDetailsBinding.executePendingBindings();
    }
}