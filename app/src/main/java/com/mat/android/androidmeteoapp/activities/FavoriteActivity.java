package com.mat.android.androidmeteoapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.mat.android.androidmeteoapp.R;
import com.mat.android.androidmeteoapp.adapters.FavoriteAdapter;
import com.mat.android.androidmeteoapp.databinding.ActivityFavoriteBinding;
import com.mat.android.androidmeteoapp.models.City;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private ActivityFavoriteBinding binding;
    private TextView textViewMessage;
    private ArrayList<City> mCities;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d("TAG", "FavoriteActivity : onCreate()");


        /*Bundle extras = getIntent().getExtras();
        String str = extras.getString("msg");
        textViewMessage = (TextView) findViewById(R.id.text_view_message);
        textViewMessage.setText("Message :" + str);*/

        /**
         * Init cities list
         */
        mCities = new ArrayList<>();
        City city1 = new City("Fondettes", "Pluie", "12", 1);
        City city2 = new City("Lyon", "Soleil", "22", 1);
        City city3 = new City("Nice", "Soleil", "26", 1);
        City city4 = new City("Brest", "Pluie", "10", 1);

        mCities.add(city1);
        mCities.add(city2);
        mCities.add(city3);
        mCities.add(city4);

        /**
         * Recycler view
         */
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        /**
         * Adaptaters
         */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new FavoriteAdapter(mContext, mCities);
        recyclerView.setAdapter(mAdapter);
        
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "FavoriteActivity : onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "FavoriteActivity : onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "FavoriteActivity : onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "FavoriteActivity : onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "FavoriteActivity : onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "FavoriteActivity : onDestroy()");
    }
}