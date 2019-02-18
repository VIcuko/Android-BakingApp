package com.example.android.android_bakingapp.data;

import android.app.Application;
import android.os.AsyncTask;

import com.example.android.android_bakingapp.data.db.AppDatabase;
import com.example.android.android_bakingapp.data.db.Recipe;
import com.example.android.android_bakingapp.data.db.RecipeDao;
import com.example.android.android_bakingapp.data.network.ApiClient;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Created by Vicuko on 17/2/19.
 */
public class RecipeRepository {
    private RecipeDao mRecipeDao;
    private LiveData<List<Recipe>> mAllRecipes;

    public RecipeRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        mRecipeDao = db.recipeDao();
        mAllRecipes = mRecipeDao.getAllRecipes();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return mAllRecipes;
    }

    public void requestRecipesOnlineUpdate(RecipeRepository recipeRepository){
        ApiClient apiClient = new ApiClient();
        apiClient.connectAndGetApiData(recipeRepository);
    }

    public void updateRecipes(List<Recipe> onlineRecipes){
        if (!onlineRecipes.isEmpty()) {
            for (Recipe recipe: onlineRecipes){
                insert(recipe);
            }
            mAllRecipes = mRecipeDao.getAllRecipes();
        }
    }

    public void insert(Recipe recipe) {
        new insertAsyncTask(mRecipeDao).execute(recipe);
    }

    private static class insertAsyncTask extends AsyncTask<Recipe, Void, Void> {

        private RecipeDao mAsyncTaskDao;

        insertAsyncTask(RecipeDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Recipe... params) {
            mAsyncTaskDao.insertRecipe(params[0]);
            return null;
        }
    }
}

