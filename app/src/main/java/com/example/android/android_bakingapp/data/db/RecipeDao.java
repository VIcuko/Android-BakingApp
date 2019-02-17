package com.example.android.android_bakingapp.data.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Vicuko on 14/2/19.
 */
@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe ORDER BY name ASC")
    LiveData<List<Recipe>> loadAllRecipes();

    @Query("SELECT * FROM recipe WHERE id = :id")
    LiveData<Recipe> loadRecipeById(int id);

    @Insert
    void insertRecipe(Recipe recipe);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateRecipe(Recipe recipe);

    @Delete
    void deleteRecipe(Recipe recipe);

    @Query("DELETE FROM recipe")
    void deleteAllRecipesg();
}
