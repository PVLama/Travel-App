package com.example.btlandroid_travelapp.activity;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.Utils.Utils;
import com.example.btlandroid_travelapp.activity.LoginSignup.Login;
import com.example.btlandroid_travelapp.activity.LoginSignup.SignUp;
import com.example.btlandroid_travelapp.activity.LoginSignup.StartUpScreen;
import com.example.btlandroid_travelapp.adapter.PlacesAdapter;
import com.example.btlandroid_travelapp.adapter.TopPlacesAdapter;
import com.example.btlandroid_travelapp.model.ModelPlaces;
import com.example.btlandroid_travelapp.model.Places;
import com.example.btlandroid_travelapp.model.TopPlaces;
import com.example.btlandroid_travelapp.model.User;
import com.example.btlandroid_travelapp.retrofit.ApiTravelApp;
import com.example.btlandroid_travelapp.retrofit.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Valiables
    static final float END_SCALE = 0.7f;
    TextView tvUserName;
    Toolbar toolbar;
    ImageView imsearch;
    RecyclerView placesRecyclerView, topPlacesRecyclerView;
    NavigationView navigationView;
    //                ListView listViewHome;
    DrawerLayout drawerLayout;
    LinearLayout content;
    ApiTravelApp apiTravelApp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    //Places
    PlacesAdapter placesAdapter;
    List<Places> modelPlacesList;

    //Top Places
    TopPlacesAdapter topPlacesAdapter;
    List<TopPlaces> modelTopPlacesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        apiTravelApp = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiTravelApp.class);

        Anhxa();
        ActionBar();
        ViewHome();
        animateNavigationDrawer();
        if (isConnected((this))) {
            getPlaces();
            getTopPlaces();
//            getEventClick();
        } else {
            Toast.makeText(getApplicationContext(), "Not Connect", Toast.LENGTH_LONG).show();
        }

        Paper.init(this);
        if (Paper.book().read("user") != null){
            User user = Paper.book().read("user");
            Utils.user_current = user;
        }
    }

    private void getTopPlaces() {
        compositeDisposable.add(apiTravelApp.getTopPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        modelTopPlaces -> {
                            if (modelTopPlaces.isSuccess()) {
                                modelTopPlacesList = modelTopPlaces.getResult();
                                topPlacesAdapter = new TopPlacesAdapter(getApplicationContext(), modelTopPlacesList);
                                topPlacesRecyclerView.setAdapter(topPlacesAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Do not connect to sever" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void ViewHome() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
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
                                placesRecyclerView.setAdapter(placesAdapter);
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Do not connect to sever" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void Anhxa() {
        imsearch = findViewById(R.id.search_places);
        toolbar = findViewById(R.id.toolBarHome);
        placesRecyclerView = findViewById(R.id.places_recycler);
        topPlacesRecyclerView = findViewById(R.id.top_place_recycler);
        drawerLayout = findViewById(R.id.drawerLayoutHome);
        navigationView = findViewById(R.id.navigationViewHome);
        content = findViewById(R.id.contentHome);

        //place_recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, HORIZONTAL, false);
        placesRecyclerView.setLayoutManager(layoutManager);
        placesRecyclerView.setHasFixedSize(true);

        //Top places_RecyclerView
        RecyclerView.LayoutManager toplayoutManager = new LinearLayoutManager(this, HORIZONTAL, false);
        topPlacesRecyclerView.setLayoutManager(toplayoutManager);
        topPlacesRecyclerView.setHasFixedSize(true);

        tvUserName = findViewById(R.id.home_tentaikhoan);
        tvUserName.setText(Utils.user_current.getTendangnhap());

        if (Utils._favourites == null){
                Utils._favourites = new ArrayList<>();
        }

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

    //All about Navigative
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_all_places:
                startActivity(new Intent(getApplicationContext(),AllItemPlaces.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(getApplicationContext(),MyProfileActivity.class));
                break;
            case R.id.nav_logout:
                Paper.book().delete("user");
                startActivity(new Intent(getApplicationContext(), Login.class));
                Toast.makeText(getApplicationContext(),"Logged Out Sucessfully",Toast.LENGTH_LONG).show();
                break;

        }
        return true;
    }

    private void animateNavigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                final float diffScaleOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaleOffset;
                content.setScaleX(offsetScale);
                content.setScaleX(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = content.getWidth() * diffScaleOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                content.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

//    public void callStarScreens(View view) {
//        startActivity(new Intent(getApplicationContext(), StartUpScreen.class));
//    }

    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    public void callAllItemPlaces(View view) {
        Intent intent = new Intent(getApplicationContext(), AllItemPlaces.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.see_all_places), "transition_see_all");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }

    //TODO: Log Out


}