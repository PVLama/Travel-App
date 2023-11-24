package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.btlandroid_travelapp.R;

public class SetNewPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_pass);
    }
    public void callForgetPasswordSuccess(View view){
        Intent intent = new Intent(getApplicationContext(),ForgetPassSuccessMessage.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.set_new_btn_ok),"transition_btn_ok");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SetNewPass.this,pairs);
        startActivity(intent,options.toBundle());
    }
}