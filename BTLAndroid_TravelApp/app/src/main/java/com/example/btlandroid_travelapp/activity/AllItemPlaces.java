package com.example.btlandroid_travelapp.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.LoginSignup.ForgetPassword;
import com.example.btlandroid_travelapp.activity.LoginSignup.Login;
import com.example.btlandroid_travelapp.adapter.PlacesAdapter;
import com.example.btlandroid_travelapp.model.Favourite;
import com.example.btlandroid_travelapp.model.Places;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;
import com.example.btlandroid_travelapp.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AllItemPlaces extends AppCompatActivity {
    EditText editsearch;
    RecyclerView seeAllRecyclerView;
    ImageView btn_backtohome;
    ApiTravelApp apiTravelApp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    //Places
    PlacesAdapter placesAdapter;
    List<Places> modelPlacesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_item_places);
        apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);
        Anhxa();
        if (isConnected((this))) {
            getPlaces();
        } else {
            Toast.makeText(getApplicationContext(), "Not Connect", Toast.LENGTH_LONG).show();
        }
    }


    private void Anhxa() {

        apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);
        editsearch = findViewById(R.id.edit_search_places);
        seeAllRecyclerView = findViewById(R.id.see_all_recyclerview);
        btn_backtohome = findViewById(R.id.see_all_back);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this ,2);
        seeAllRecyclerView.setLayoutManager(layoutManager);
        seeAllRecyclerView.setHasFixedSize(true);

        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getDataSearch();
            }
        });
    }

    private void getDataSearch() {
        String str_search = editsearch.getText().toString().trim();
        compositeDisposable.add(apiTravelApp.search(str_search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        modelPlaces -> {
                            if (modelPlaces.isSuccess()){
                                modelPlacesList = modelPlaces.getResult();
                                placesAdapter = new PlacesAdapter(getApplicationContext(), modelPlacesList);
                                seeAllRecyclerView.setAdapter(placesAdapter);
                            }

                        },throwable -> {
                            Toast.makeText(getApplicationContext(), throwable.getMessage(),Toast.LENGTH_SHORT).show();
                        }

                        ));
    }
    private void getPlaces() {
        compositeDisposable.add(apiTravelApp.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        modelPlaces -> {
                            if (modelPlaces.isSuccess()) {
                                modelPlacesList = modelPlaces.getResult();
                                placesAdapter = new PlacesAdapter(getApplicationContext(), modelPlacesList);
                                seeAllRecyclerView.setAdapter(placesAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Do not connect to sever" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }


    private boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi != null && wifi.isConnected() || (mobile != null && mobile.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    public void callHomeScreen(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.see_all_back), "transition_back_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AllItemPlaces.this, pairs);
        startActivity(intent, options.toBundle());
    }

}
