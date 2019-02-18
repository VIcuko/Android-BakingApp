package com.example.android.android_bakingapp.ui.main;

import android.os.Bundle;

import com.example.android.android_bakingapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.widget.GridLayout.VERTICAL;

public class RecipesSummary extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecipesSummaryAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_summary);

//        TODO: Añadir la parte para refresh layout

        mRecyclerView = (RecyclerView) findViewById(R.id.main_content_recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2, VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecipesSummaryAdapter = new RecipesSummaryAdapter(this);
        mRecyclerView.setAdapter(mRecipesSummaryAdapter);
    }
}
