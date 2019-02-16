package com.example.android.android_bakingapp.data;

import java.util.LinkedHashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Vicuko on 15/2/19.
 */
@Entity(tableName = "recipe")
public class Recipe {

    final static String ID = "id";
    final static String NAME = "name";
    final static String INGREDIENTS = "ingredients";
    final static String STEPS = "steps";
    final static String SERVINGS = "servings";
    final static String IMAGE = "image";

    @NonNull
    @PrimaryKey
    private int id;
    private String name;
    private List<LinkedHashMap> ingredients;
    private List<LinkedHashMap> steps;
    private int servings;
    private byte[] image;
    public Recipe() {
    }

    @Ignore
    protected Recipe(LinkedHashMap hashMap) {
        id = (int) hashMap.get(ID);
        name = (String) hashMap.get(NAME);
        ingredients = (List<LinkedHashMap>) hashMap.get(INGREDIENTS);
        steps = (List<LinkedHashMap>) hashMap.get(STEPS);
        servings = (int) hashMap.get(SERVINGS);
        image = (byte[]) hashMap.get(IMAGE);
    }


}
