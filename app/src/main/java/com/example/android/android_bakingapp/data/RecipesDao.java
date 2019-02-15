package com.example.android.android_bakingapp.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

/**
 * Created by Vicuko on 14/2/19.
 */
public interface RecipesDao {

    @Query("SELECT * FROM movies")
    LiveData<List<MovieEntry>> loadAllTasks();

    @Query("SELECT * FROM movies WHERE id = :id")
    LiveData<MovieEntry> loadMovieById(int id);

    @Insert
    void insertMovie(MovieEntry movieEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(MovieEntry movieEntry);

    @Delete
    void deleteMovie(MovieEntry movieEntry);
}
