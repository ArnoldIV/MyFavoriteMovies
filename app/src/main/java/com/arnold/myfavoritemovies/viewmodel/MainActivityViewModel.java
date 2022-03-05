package com.arnold.myfavoritemovies.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.arnold.myfavoritemovies.model.AppRepository;
import com.arnold.myfavoritemovies.model.Genre;
import com.arnold.myfavoritemovies.model.Movie;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    AppRepository appRepository;
    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> genreMovies;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
    }

    //add genres in LiveData list<Genre> through appRepository
    public LiveData<List<Genre>> getGenres() {

        genres = appRepository.getGenres();
        return genres;
    }

    //add movies in LiveData list<Movie> through appRepository
    public LiveData<List<Movie>> getGenreMovies(int genreId) {

        genreMovies = appRepository.getGenreMovies(genreId);
        return genreMovies;
    }

    //add new movie in appRepository
    public void addNewMovie(Movie movie) {
        appRepository.insertMovie(movie);
    }

    //update new movie in appRepository
    public void updateMovie(Movie movie) {
        appRepository.updateMovie(movie);
    }

    //delete movie in appRepository
    public void deleteMovie(Movie movie) {
        appRepository.deleteMovie(movie);
    }
}
