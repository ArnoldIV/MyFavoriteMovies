package com.arnold.myfavoritemovies.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insert(Movie movie);

    @Update
    void update(Movie movie);

    @Delete
    void delete(Movie movie);

    //query to get all movies from movies table
    @Query("select * from movies_table")
    LiveData<List<Movie>> getAllMovies();

    //query to get movies of selected genre
    @Query("select * from movies_table where genre_id==:genreId")
    LiveData<List<Movie>> getGenreMovies(int genreId);
}
