package com.example.android.android_bakingapp.ui.main;

import android.app.Application;

import com.example.android.android_bakingapp.data.RecipeRepository;
import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by Vicuko on 18/2/19.
 */
public class RecipesViewModel extends AndroidViewModel {

    private RecipeRepository mRecipeRepository;
    private LiveData<List<Recipe>> mAllRecipes;


    public RecipesViewModel(@NonNull Application application) {
        super(application);
        mRecipeRepository = new RecipeRepository(application);
        mAllRecipes = mRecipeRepository.getAllRecipes();
    }

    public LiveData<List<Recipe>> getAllRecipes() { return mAllRecipes; }

    public void insert(Recipe recipe) { mRecipeRepository.insert(recipe); }
}
