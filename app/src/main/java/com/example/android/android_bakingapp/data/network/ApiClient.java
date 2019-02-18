package com.example.android.android_bakingapp.data.network;

import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Vicuko on 18/2/19.
 */
public class ApiClient {
    private static final String TAG = ApiClient.class.getSimpleName();
    private static final String BASE_URL =
            "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/";

    private static Retrofit retrofit = null;

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        RecipeService recipeService = retrofit.create(RecipeService.class);
        Call<List<Recipe>> call = recipeService.getAllRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                List<Recipe> recipes = response.body();
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Timber.d(t.toString());
            }
        });

    }
}
