package com.example.android.android_bakingapp.ui.main;

import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Vicuko on 18/2/19.
 */
public class RecipesSummaryAdapter extends RecyclerView.Adapter<RecipesSummaryAdapter.RecipesSummaryViewHolder> {

    private List<Recipe> mRecipes;

    public class RecipesSummaryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public RecipesSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public RecipesSummaryAdapter.RecipesSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesSummaryAdapter.RecipesSummaryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
