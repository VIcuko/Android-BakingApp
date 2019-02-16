package com.example.android.android_bakingapp.data;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Vicuko on 15/2/19.
 */
@Entity(tableName = "recipe")
public class Recipe {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients;

    @Ignore
    @SerializedName("steps")
    @Expose
    private List<Step> steps;

    @SerializedName("servings")
    @Expose
    private long servings;

    @SerializedName("image")
    @Expose
    private String image;

    public Recipe() {
    }

    @Ignore
    protected Recipe(Parcel in) {
        id = in.readLong();
        name = in.readString();
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        steps = in.createTypedArrayList(Step.CREATOR);
        servings = in.readLong();
        image = in.readString();
    }


}
