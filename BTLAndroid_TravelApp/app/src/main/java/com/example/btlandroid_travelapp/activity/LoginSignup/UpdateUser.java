package com.example.btlandroid_travelapp.activity.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.MyProfileActivity;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;
import com.example.btlandroid_travelapp.retrofit.RetrofitClient;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UpdateUser extends AppCompatActivity {
        TextView email, sodienthoai, tentaikhoan;
        EditText edt_email, edt_sodienthoai, edt_tentaikhoan, edt_matkhau;
        Button btn_update;
        ImageView backToDetailProf;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        ApiTravelApp apiTravelApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Anhxa();
        initConTrol();
        updateUser();
        initView();
    }

    private void initView() {
        apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);
        email.setText(Utils.user_current.getEmail());
        tentaikhoan.setText(Utils.user_current.getTendangnhap());
        sodienthoai.setText(Utils.user_current.getSodienthoai());

        edt_email.setText(Utils.user_current.getEmail());
        edt_tentaikhoan.setText(Utils.user_current.getTendangnhap());
        edt_sodienthoai.setText(Utils.user_current.getSodienthoai());
    }

    private void initConTrol() {
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser();
            }
        });

        backToDetailProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailProfile.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateUser() {
        String str_name = edt_tentaikhoan.getText().toString().trim();
        String str_noPhone = edt_sodienthoai.getText().toString().trim();
        String str_pass = edt_matkhau.getText().toString().trim();
        String str_email = edt_email.getText().toString().trim();

        if (str_name.isEmpty() || str_noPhone.isEmpty()||str_pass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();

        }else {
            compositeDisposable.add(apiTravelApp.updateuser(str_name,str_email,str_noPhone, str_pass)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            modelUser -> {
                                if (modelUser.isSuccess()) {
                                    Utils.user_current.setEmail(str_email);
                                    Intent intent = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(getApplicationContext(),"Updated Successfully", Toast.LENGTH_SHORT).show();
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

    private void Anhxa() {
        edt_email = findViewById(R.id.edit_email);
        edt_sodienthoai = findViewById(R.id.edit_sodienthoai);
        edt_tentaikhoan = findViewById(R.id.edit_tentaikhoan);
        edt_matkhau = findViewById(R.id.edit_matkhau);
        btn_update = findViewById(R.id.updateUser_btn);
        backToDetailProf = findViewById(R.id.update_Prof_back);

        email = findViewById(R.id.prof_email);
        sodienthoai = findViewById(R.id.prof_sodienthoai);
        tentaikhoan = findViewById(R.id.prof_tentaikhoan);


    }
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}