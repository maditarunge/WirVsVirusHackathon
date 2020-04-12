package com.example.hackathon;

import android.content.SharedPreferences;

import com.example.hackathon.Model.User;

public class Consts {

    public static User user;

    public static class Indexer
    {
        public static String title = "title";
        public static String user = "user";
        public static String date = "date";
    }

    public static class SharedPrefs
    {
        public static SharedPreferences sharedPref;
        public static SharedPreferences.Editor editor;
//        public static boolean checkPrefs = true;

        public static class Values
        {
            public static final String STAY_LOGGED_IN = "STAY_LOGGED_IN";
            public static final String USER = "USER";
            public static final String PASS = "PASS";
        }
    }

    public static class TestData
    {
        public static String username = "Max";
        public static boolean testVersion = true;
    }

    public static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

}
