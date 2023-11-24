package com.example.btlandroid_travelapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.LoginSignup.DetailProfile;
import com.example.btlandroid_travelapp.databinding.MenuHeaderBinding;
import com.example.btlandroid_travelapp.model.User;

public class MyProfileActivity extends AppCompatActivity {
    TextView txtTentaikhoan, txtInfor, tv_fav;
    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Anhxa();
//            initControl();
        initData();
    }

    private void initData() {
        txtTentaikhoan.setText(Utils.user_current.getTendangnhap());
    }


    private void Anhxa() {
        txtTentaikhoan = findViewById(R.id.profile_tentaikhoan);
        txtInfor = findViewById(R.id.profile_thongtincanhan);
        imageViewBack = findViewById(R.id.myprof_btnBack);
        tv_fav = findViewById(R.id.textView_fav);

        txtInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailProfile.class);
                startActivity(intent);
            }
        });

        tv_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FavouritesActivity.class);
                startActivity(intent);
            }
        });
    }

    public void callMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.myprof_btnBack), "transition_mypro_back");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MyProfileActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }
}