package com.example.btlandroid_travelapp.Utils;

import com.example.btlandroid_travelapp.model.Favourite;
import com.example.btlandroid_travelapp.model.Foods;
import com.example.btlandroid_travelapp.model.User;

import java.util.List;

public class Utils {
    public static final String BASE_URL = "http://192.168.0.102/App_Dulich/";

    public static List<Favourite> _favourites;
    public static User user_current = new User();
    public static Foods foods_current = new Foods();
}
