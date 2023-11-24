package com.example.btlandroid_travelapp.retrofit;

import com.example.btlandroid_travelapp.model.ModelDetail;
import com.example.btlandroid_travelapp.model.ModelFoods;
import com.example.btlandroid_travelapp.model.ModelPlaces;
import com.example.btlandroid_travelapp.model.ModelTopPlaces;
import com.example.btlandroid_travelapp.model.ModelUser;
import com.google.firebase.encoders.annotations.Encodable;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiTravelApp {
    //GET DATA
    @GET("places.php")
    Observable<ModelPlaces> getPlaces();

    @GET("topplaces.php")
    Observable<ModelTopPlaces> getTopPlaces();

    //POST DATA
    @POST("search.php")
    @FormUrlEncoded
    Observable<ModelPlaces> search(
            @Field("search") String search
    );

    @POST("signup.php")
    @FormUrlEncoded
    Observable<ModelUser> signup(
            @Field("Tendangnhap") String username,
            @Field("Email") String email,
            @Field("Sodienthoai") String numberphone,
            @Field("Matkhau") String password
    );

    @POST("login.php")
    @FormUrlEncoded
    Observable<ModelUser> login(
            @Field("Email") String email,
            @Field("Matkhau") String password
    );


    @POST("foods.php")
    @FormUrlEncoded
    Observable<ModelFoods> foods(
            @Field("idMonan") int idmonan
    );


    @POST("updateuser.php")
    @FormUrlEncoded
    Observable<ModelUser> updateuser(
            @Field("Tendangnhap") String username,
            @Field("Email") String email,
            @Field("Sodienthoai") String numberPhone,
            @Field("Matkhau") String password
    );

}
