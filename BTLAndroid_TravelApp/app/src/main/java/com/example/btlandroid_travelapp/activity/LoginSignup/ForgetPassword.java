package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private Button forgetBtn;
    private EditText txtEmail;
    private String email;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        firebaseAuth = FirebaseAuth.getInstance();
        Anhxa();
    }

    private void Anhxa() {
        forgetBtn = findViewById(R.id.forget_nextBtn);
        txtEmail = findViewById(R.id.edt_forget_email);


        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData() {
        email = txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("Nhập Email");
        }else {
            forgetpass();
        }
    }

    private void forgetpass() {
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "Check your Email", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ForgetPassword.this, Login.class));
                            finish();
                        }else {
                            Toast.makeText(ForgetPassword.this, "Error: "+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    public void callLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.forget_btn_back), "btn_back");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }
}