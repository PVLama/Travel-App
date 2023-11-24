package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.btlandroid_travelapp.R;

public class ForgetPassSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_success_message);
    }
    public void callLoginScreen(View view){
        Intent intent = new Intent(getApplicationContext(),Login.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.set_new_btn_login),"transition_btn_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPassSuccessMessage.this,pairs);
        startActivity(intent,options.toBundle());
    }
}