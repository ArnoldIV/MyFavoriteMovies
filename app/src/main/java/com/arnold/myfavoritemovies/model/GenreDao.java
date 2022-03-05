package com.arnold.myfavoritemovies.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GenreDao {

    @Insert
    void insert(Genre genre);

    @Update
    void update(Genre genre);

    @Delete
    void delete(Genre genre);
    //query to get all genre from genre table
    @Query("select * from genres_table")
    LiveData<List<Genre>> getAllGenres();
}
