package com.example.android.android_bakingapp.ui.main;

import android.os.Bundle;

import com.example.android.android_bakingapp.R;
import com.example.android.android_bakingapp.data.RecipeRepository;
import com.example.android.android_bakingapp.data.db.Recipe;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipesSummary extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecipesSummaryAdapter mRecipesSummaryAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Recipe> mRecipes;
    private RecipeRepository mRecipeRepository;

    private RecipesViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_summary);

//        TODO: Añadir parte para la carga de datos normal nada más abrir la actividad

//        TODO: Añadir la parte para refresh layout

        mRecyclerView = (RecyclerView) findViewById(R.id.main_content_recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        TODO: Añadir "this" como parametro al adaptador cuando implemente el onclick en el adaptador
        mRecipesSummaryAdapter = new RecipesSummaryAdapter();
        mRecyclerView.setAdapter(mRecipesSummaryAdapter);

        mWordViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);

        mWordViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                mRecipesSummaryAdapter.setRecipes(recipes);
            }
        });
    }
}
