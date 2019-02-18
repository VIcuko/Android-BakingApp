package com.example.android.android_bakingapp.data.db;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import androidx.annotation.Nullable;
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

    @PrimaryKey
    private int id;
    private String name;
    private ArrayList<LinkedHashMap> ingredients;
    private ArrayList<LinkedHashMap> steps;
    private int servings;
    private String image;
    @Nullable
    private byte[] additionalImage;

    public Recipe() {
    }

    @Ignore
    protected Recipe(LinkedHashMap hashMap) {
        id = (int) hashMap.get(ID);
        name = (String) hashMap.get(NAME);
        ingredients = (ArrayList<LinkedHashMap>) hashMap.get(INGREDIENTS);
        steps = (ArrayList<LinkedHashMap>) hashMap.get(STEPS);
        servings = (int) hashMap.get(SERVINGS);
        image = (String) hashMap.get(IMAGE);
        additionalImage = (byte[]) hashMap.get(IMAGE);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<LinkedHashMap> getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList<LinkedHashMap> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<LinkedHashMap> getSteps() {
        return steps;
    }
    public void setSteps(ArrayList<LinkedHashMap> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }
    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

    public byte[] getAdditionalImage() {
        return additionalImage;
    }
    public void setAdditionalImage(byte[] image) {
        this.additionalImage = additionalImage;
    }
}
