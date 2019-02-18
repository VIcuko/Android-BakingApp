package com.example.android.android_bakingapp.data.network;

import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vicuko on 18/2/19.
 */
public class ApiClient {
    private static final String TAG = ApiClient.class.getSimpleName();
    private static final String BASE_URL =
            "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/";

    private static Retrofit retrofit = null;

    public Call<List<Recipe>> getRecipeApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        RecipeService recipeService = retrofit.create(RecipeService.class);
        Call<List<Recipe>> recipes = recipeService.getAllRecipes();
        return recipes;
    }
}
