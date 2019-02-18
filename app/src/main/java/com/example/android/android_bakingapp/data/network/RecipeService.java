package com.example.android.android_bakingapp.data.network;

import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vicuko on 18/2/19.
 */
public interface RecipeService {
    @GET("baking.json")
    Call<List<Recipe>> getAllRecipes();
}
