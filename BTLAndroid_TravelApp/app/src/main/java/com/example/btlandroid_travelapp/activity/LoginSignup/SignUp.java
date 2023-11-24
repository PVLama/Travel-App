package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.MainActivity;
import com.example.btlandroid_travelapp.model.ModelUser;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;
import com.example.btlandroid_travelapp.retrofit.RetrofitClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SignUp extends AppCompatActivity {
    TextInputLayout username, email, numberphone, password, confirmpass;
    CountryCodePicker countryCodePicker;
    Button btn_Next_SignupScr;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiTravelApp apiTravelApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen_sign_up);
        Anhxa();
        initControl();

    }

    private void initControl() {
        btn_Next_SignupScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangKi();
            }
        });
    }

        private void dangKi() {
                if (!validateUserName() | !validateEmail() | !validatePassword() | !validateNumberPhone()) {
                    return;
                }
                String str_username = username.getEditText().getText().toString().trim();
                String str_email = email.getEditText().getText().toString().trim();
                String str_pass = password.getEditText().getText().toString().trim();
                String _nophone = numberphone.getEditText().getText().toString().trim();
                compositeDisposable.add(apiTravelApp.signup(str_username, str_email, _nophone, str_pass)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                modelUser -> {
                                    if (modelUser.isSuccess()) {
                                        Utils.user_current.setEmail(str_email);
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
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


            public boolean validateUserName() {
                String val = username.getEditText().getText().toString().trim();
                if (val.isEmpty()) {
                    username.setError("Nhập đầy đủ tên");
                    return false;
                } else {
                    username.setError(null);
                    username.setErrorEnabled(false);
                    return true;
                }
            }

            public boolean validateNumberPhone() {
                String val = numberphone.getEditText().getText().toString().trim();
                if (val.isEmpty()) {
                    numberphone.setError("Nhập số điện thoại");
                    return false;
                } else {
                    numberphone.setError(null);
                    numberphone.setErrorEnabled(false);
                    return true;
                }
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
                String passInPut = password.getEditText().getText().toString().trim();
                String confirmPass = confirmpass.getEditText().getText().toString().trim();
                if (passInPut.isEmpty()) {
                    password.setError("Nhập Password");
                    return false;
                } else if (passInPut.length() < 6) {
                    password.setError("Nhập trên 6 kí tự");
                    return false;
                } else if (!passInPut.equals(confirmPass)) {
                    confirmpass.setError("Pass không khớp");
                    return false;
                } else {
                    confirmpass.setError(null);
                    confirmpass.setErrorEnabled(false);
                    return true;
                }
            }

            private void Anhxa() {
                apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);
                numberphone = findViewById(R.id.signup_phone_number);
                username = findViewById(R.id.signup_username);
                email = findViewById(R.id.signup_email);
                password = findViewById(R.id.signup_password);
                confirmpass = findViewById(R.id.signup_confirmpass);
                countryCodePicker = findViewById(R.id.country_code_picker);
                btn_Next_SignupScr = findViewById(R.id.signup_next_button);
            }


            public void callLoginScreen(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow_btn");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            }

            protected void onDestroy() {
                compositeDisposable.clear();
                super.onDestroy();
            }
        }