package com.example.btlandroid_travelapp.activity;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.adapter.FoodsAdapter;
import com.example.btlandroid_travelapp.adapter.PlacesAdapter;
import com.example.btlandroid_travelapp.listener.ItemClickListener;
import com.example.btlandroid_travelapp.model.Favourite;
import com.example.btlandroid_travelapp.model.Foods;
import com.example.btlandroid_travelapp.model.Places;
import com.example.btlandroid_travelapp.model.TopPlaces;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.internal.Util;


public class DetailActivity extends AppCompatActivity {

    TextView tendiadanh, tendiadiem, mota, tendiadanh_mota, textViewFoods;
    ImageView imageViewPlaces, im1, im2, im3;
    ScrollView scrollView;
    ImageView fav_image;
    Places places;
    PlacesAdapter.MyViewHoder myViewHoder;
    ItemClickListener itemClickListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Anhxa();
        getDetailPlaces();
        initConTrol();
    }

    private void initConTrol() {
        fav_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav_image.isClickable()){
                    fav_image.setImageResource(R.drawable.ic_baseline_favorite_24);
                    themVaoListFav();
                }else {
                    fav_image.setImageResource(R.drawable.ic_outline_favorite_border_24);
                }
            }
        });
}

    private void themVaoListFav() {
        if (Utils._favourites.size() >0){
            boolean flag = false;
                for (int i = 0; i < Utils._favourites.size(); i++)
                {
                    if (Utils._favourites.get(i).getID() == places.getID()){
                        flag = true;
                    }

                }
                if (flag == false){
                    Favourite favourite = new Favourite();
                    favourite.setID(places.getID());
                    favourite.setHinhanh(places.getHinhanh());
                    favourite.setTendiadanh(places.getTendiadanh());
                    favourite.setTendiadiem(places.getTendiadiem());
                    Utils._favourites.add(favourite);
                }
        }else {

            Favourite favourite = new Favourite();
            favourite.setID(places.getID());
            favourite.setHinhanh(places.getHinhanh());
            favourite.setTendiadanh(places.getTendiadanh());
            favourite.setTendiadiem(places.getTendiadiem());
            Utils._favourites.add(favourite);
        }
    }


    private void getDetailPlaces() {
        places = (Places) getIntent().getSerializableExtra("detail");

        tendiadanh.setText(places.getTendiadanh());
        tendiadanh_mota.setText(places.getTendiadanh());
        tendiadiem.setText(places.getTendiadiem());
        mota.setText(places.getMota());
        Glide.with(getApplicationContext()).load(places.getHinhanh()).into(imageViewPlaces);
        Glide.with(getApplicationContext()).load(places.getHinhanh1()).into(im1);
        Glide.with(getApplicationContext()).load(places.getHinhanh2()).into(im2);
        Glide.with(getApplicationContext()).load(places.getHinhanh3()).into(im3);
    }

    private void Anhxa() {
        tendiadanh = findViewById(R.id.detail_Tendiadanh);
        tendiadiem = findViewById(R.id.detail_Tendiadiem);
        tendiadanh_mota = findViewById(R.id._tendiadanh);
        imageViewPlaces = findViewById(R.id.image_View_Item);
        im1 = findViewById(R.id.image1);
        im2 = findViewById(R.id.image2);
        im3 = findViewById(R.id.image3);
        scrollView = findViewById(R.id.scrollMota);
        mota = findViewById(R.id.textView_Mota);

        fav_image = findViewById(R.id.image_fav);

    }
    public void callHomeScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.linear_Home_Back), "transition_backHome");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetailActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }



}
