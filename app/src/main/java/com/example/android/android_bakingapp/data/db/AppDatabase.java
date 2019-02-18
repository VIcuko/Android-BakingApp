package com.example.android.android_bakingapp.data.db;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.android_bakingapp.data.network.ApiClient;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import timber.log.Timber;

/**
 * Created by Vicuko on 14/2/19.
 */
@Database(version = 1, entities = {Recipe.class}, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RecipeDao recipeDao();

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "recipes";
    private static volatile AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Timber.d("Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .addCallback(sRoomDatabaseCallback)
                        .build();
            }
        }
        Timber.d("Getting the database instance");
        return sInstance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(sInstance).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final RecipeDao mDao;

        PopulateDbAsync(AppDatabase db) {
            mDao = db.recipeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            ApiClient apiClient = new ApiClient();
            List<Recipe> recipes = apiClient.connectAndGetApiData();
            Timber.d("Database informed the following recipes: " + recipes);
            if (!recipes.isEmpty()) {
                for (Recipe recipe : recipes) {
                    mDao.insertRecipe(recipe);
                }
            }
            return null;
        }
    }
}
