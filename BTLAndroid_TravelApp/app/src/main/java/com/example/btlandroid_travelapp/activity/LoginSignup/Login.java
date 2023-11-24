package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.MainActivity;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;
import com.example.btlandroid_travelapp.retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Login extends AppCompatActivity {
    TextInputLayout email, password;

    ApiTravelApp apiTravelApp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    Button login_btn, foget_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen_login);
        Anhxa();
        initControl();

    }

    private void initControl() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangNhap();
            }
        });


        foget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ForgetPassword.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);
        foget_btn = findViewById(R.id.btn_forgetpass);
        login_btn = findViewById(R.id.login_btn_screenlogin);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
    }

    public boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Nhập Email");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            password.setError("Nhập Password");
            return false;
        }else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void callSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_createacc), "transition_createAcc");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void dangNhap() {

        if (!validateEmail() | !validatePassword()) {
            return;
        }else {
            String str_email = email.getEditText().getText().toString().trim();
            String str_pass = password.getEditText().getText().toString().trim();
            compositeDisposable.add(apiTravelApp.login(str_email, str_pass)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            modelUser -> {
                                if (modelUser.isSuccess()) {
                                    Utils.user_current = modelUser.getResult().get(0);
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), modelUser.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    ));
        }
    }


    public void callForgetPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_forgetpass), "transition_forgetpass");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.user_current.getEmail() != null ) {
            email.getEditText().setText(Utils.user_current.getEmail());
        }
    }

    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

}