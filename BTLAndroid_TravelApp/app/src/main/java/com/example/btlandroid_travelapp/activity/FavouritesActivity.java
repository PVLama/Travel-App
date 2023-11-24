package com.example.btlandroid_travelapp.activity;

import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.adapter.FavouriteAdapter;
import com.example.btlandroid_travelapp.adapter.PlacesAdapter;
import com.example.btlandroid_travelapp.model.Favourite;
import com.example.btlandroid_travelapp.model.Places;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class FavouritesActivity extends AppCompatActivity {
    private RecyclerView recyclerView_fav;
    FavouriteAdapter favouriteAdapter;
    ImageView favImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
            initView();
//            initConTrol();

    }

    private void initView() {
        recyclerView_fav = findViewById(R.id.recycler_favorite);

        recyclerView_fav.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this ,2);
        recyclerView_fav.setLayoutManager(layoutManager);
        if (Utils._favourites.size() == 0){

        }else {
            favouriteAdapter = new FavouriteAdapter(getApplicationContext(),Utils._favourites);
            recyclerView_fav.setAdapter(favouriteAdapter);
        }
    }

}
