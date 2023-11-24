package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.MyProfileActivity;
import com.google.gson.Gson;

public class DetailProfile extends AppCompatActivity {

    TextView email, sodienthoai, tentaikhoan;
    ImageView imageViewBack;
    Button btn_update_prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile);
        Anhxa();
        initData();
//        initConTrol();
    }

//    private void initConTrol() {
//        btn_update_prof.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), UpdateUser.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void initData() {
        email.setText(Utils.user_current.getEmail());
        tentaikhoan.setText(Utils.user_current.getTendangnhap());
        sodienthoai.setText(Utils.user_current.getSodienthoai());
    }

    private void Anhxa() {
        email = findViewById(R.id.prof_email);
        tentaikhoan = findViewById(R.id.prof_tentaikhoan);
        sodienthoai = findViewById(R.id.prof_sodienthoai);
        imageViewBack = findViewById(R.id.detail_Prof_back);
        btn_update_prof = findViewById(R.id.updateUser_btn);
    }

    public void callMyProfileActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(findViewById(R.id.detail_Prof_back), "transition_detailpro_back");
        pairs[1] = new Pair<View, String>(findViewById(R.id.prof_email), "transition_email");
        pairs[2] = new Pair<View, String>(findViewById(R.id.prof_tentaikhoan), "transition_username");
        pairs[3] = new Pair<View, String>(findViewById(R.id.prof_sodienthoai), "transition_noPhone");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetailProfile.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callUpdateUser(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateUser.class);
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(findViewById(R.id.detail_Prof_back), "transition_detailpro_back");
        pairs[1] = new Pair<View, String>(findViewById(R.id.prof_email), "transition_email");
        pairs[2] = new Pair<View, String>(findViewById(R.id.prof_tentaikhoan), "transition_username");
        pairs[3] = new Pair<View, String>(findViewById(R.id.prof_sodienthoai), "transition_noPhone");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetailProfile.this, pairs);
        startActivity(intent, options.toBundle());
    }
}