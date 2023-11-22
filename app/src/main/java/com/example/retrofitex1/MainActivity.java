package com.example.retrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.retrofitex1.databinding.ActivityMainBinding;
import com.example.retrofitex1.model.Movie;
import com.example.retrofitex1.view.MovieAdapter;
import com.example.retrofitex1.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    ArrayList<Movie> movieArrayList;
    MovieViewModel viewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);



        getPopularMovies();

        swipeRefreshLayout = activityMainBinding.swiperefresh;
        swipeRefreshLayout.setColorSchemeColors(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();

            }
        });

    }

    private void getPopularMovies() {

        viewModel.getAllMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movieArrayList = (ArrayList<Movie>) moviesFromLiveData;

                displayMovieInRecyclerView();


            }
        });
    }

    private void displayMovieInRecyclerView() {

        recyclerView = activityMainBinding.recyclerview;

        movieAdapter = new MovieAdapter(this , movieArrayList);
        recyclerView.setAdapter(movieAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));

        movieAdapter.notifyDataSetChanged();
    }
}