package com.example.android.android_bakingapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import timber.log.Timber;

/**
 * Created by Vicuko on 14/2/19.
 */
@Database(version = 1, entities = {Recipe.class}, exportSchema = false)
//@TypeConverters(DataConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RecipesDao recipesDao();

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "recipes";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Timber.d("Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Timber.d("Getting the database instance");
        return sInstance;
    }


}
