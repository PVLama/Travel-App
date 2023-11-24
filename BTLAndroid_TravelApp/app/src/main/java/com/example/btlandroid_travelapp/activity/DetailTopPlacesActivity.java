package com.example.btlandroid_travelapp.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.model.Favourite;
import com.example.btlandroid_travelapp.model.Places;
import com.example.btlandroid_travelapp.model.TopPlaces;

public class DetailTopPlacesActivity extends AppCompatActivity {

        TextView tenTopdiadanh, tenTopdiadiem, Topmota, tenTopdiadanh_mota;
        ImageView imageViewTopPlaces, im1, im2, im3;
        ScrollView TopscrollView;
        ImageView top_Fav_image;
        TopPlaces topPlaces;
        Places places;

        @Override
        protected void onCreate (@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Anhxa();
            getDetailTopPlaces();
            initConTrol();
        }

    private void initConTrol() {
        top_Fav_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (top_Fav_image.isClickable()){
                    top_Fav_image.setImageResource(R.drawable.ic_baseline_favorite_24);
                }else {
                    top_Fav_image.setImageResource(R.drawable.ic_outline_favorite_border_24);
                }

            }
        });
    }

    private void getDetailTopPlaces() {
        TopPlaces topPlaces = (TopPlaces) getIntent().getSerializableExtra("Topdetail");

        tenTopdiadanh.setText(topPlaces.getTendiadanh());
        tenTopdiadiem.setText(topPlaces.getTendiadiem());
        tenTopdiadanh_mota.setText(topPlaces.getTendiadanh());
        Topmota.setText(topPlaces.getMota());
        Glide.with(getApplicationContext()).load(topPlaces.getHinhanh()).into(imageViewTopPlaces);
        Glide.with(getApplicationContext()).load(topPlaces.getHinhanh1()).into(im1);
        Glide.with(getApplicationContext()).load(topPlaces.getHinhanh2()).into(im2);
        Glide.with(getApplicationContext()).load(topPlaces.getHinhanh3()).into(im3);
    }

    private void Anhxa() {
        tenTopdiadanh = findViewById(R.id.detail_Tendiadanh);
        tenTopdiadiem = findViewById(R.id.detail_Tendiadiem);
        tenTopdiadanh_mota = findViewById(R.id._tendiadanh);
        imageViewTopPlaces = findViewById(R.id.image_View_Item);
        im1 = findViewById(R.id.image1);
        im2 = findViewById(R.id.image2);
        im3 = findViewById(R.id.image3);
        TopscrollView = findViewById(R.id.scrollMota);
        Topmota = findViewById(R.id.textView_Mota);

        top_Fav_image = findViewById(R.id.image_fav);
    }
    public void callHomeScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.linear_Home_Back), "transition_backHome");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetailTopPlacesActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }
}
