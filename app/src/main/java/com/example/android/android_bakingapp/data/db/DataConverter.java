package com.example.android.android_bakingapp.data.db;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import androidx.room.TypeConverter;

/**
 * Created by Vicuko on 16/2/19.
 */
public class DataConverter {
    @TypeConverter
    public static LinkedHashMap fromStringToLinkedHashMap(String contentString) {
        Type linkedHashMapType = new TypeToken<LinkedHashMap>() {}.getType();
        return new Gson().fromJson(contentString,linkedHashMapType);
    }

    @TypeConverter
    public static String fromLinkedHashMaptoString(LinkedHashMap contentHashMap) {
        Gson gson = new Gson();
        String json = gson.toJson(contentHashMap);
        return json;
    }

    @TypeConverter
    public static ArrayList<String> fromStringtoArray(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListToString(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static byte[] fromBitmapToByteArray (Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] posterInByte = baos.toByteArray();
        return posterInByte;
    }

    @TypeConverter
    public static Bitmap fromByteArrayToBitmap (byte[] imageInByte){
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageInByte, 0, imageInByte.length);
        return bitmap;
    }
}
