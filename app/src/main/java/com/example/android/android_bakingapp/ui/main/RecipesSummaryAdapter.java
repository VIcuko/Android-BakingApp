package com.example.android.android_bakingapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.android_bakingapp.R;
import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

/**
 * Created by Vicuko on 18/2/19.
 */
public class RecipesSummaryAdapter extends RecyclerView.Adapter<RecipesSummaryAdapter.RecipesSummaryViewHolder> {

    private List<Recipe> mRecipes;

    public class RecipesSummaryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final ImageView mRecipeBackgroundImage;
        private final TextView mRecipeNameText;

        public RecipesSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecipeBackgroundImage = (ImageView) itemView.findViewById(R.id.recipe_background_image);
            mRecipeNameText = (TextView) itemView.findViewById(R.id.recipe_name_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Timber.d("Item was clicked");
        }
    }

    @NonNull
    @Override
    public RecipesSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.activity_recipes_summary_element;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new RecipesSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesSummaryViewHolder holder, int position) {
        if (!(mRecipes == null)) {
//            TODO: Codigo para asignar valores a cada elemento en la lista
        }
    }

    @Override
    public int getItemCount() {
        if (mRecipes == null || mRecipes.isEmpty()) {
            return 0;
        }
        else {
            return mRecipes.size();
        }
    }

    public void setRecipesData(List<Recipe> recipes) {
        mRecipes = recipes;
        notifyDataSetChanged();
    }

}
