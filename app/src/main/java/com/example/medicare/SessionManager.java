package com.example.medicare;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.medicare.data.model.Data;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
//    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String IMAGE = "image";
    public static final String TOKEN = "token";

    public SessionManager(Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(Data user) {
        editor.putBoolean(IS_LOGGED_IN, true);
//        editor.putInt(ID, user.getId());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NAME, user.getName());
        editor.putString(PHONE, user.getPhone());
        editor.putString(IMAGE, user.getProfilePicture());
        editor.putString(TOKEN, user.getToken());
        editor.commit();
    }

    public void createRegisSession(com.example.medicare.register.model.Data user) {
        editor.putBoolean(IS_LOGGED_IN, true);
//        editor.putInt(ID, user.getId());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(NAME, user.getName());
        editor.putString(PHONE, user.getPhone());
        editor.putString(IMAGE, user.getProfilePicture());
        editor.putString(TOKEN, user.getToken());
        editor.commit();
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
//        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(PHONE, sharedPreferences.getString(PHONE, null));
        user.put(IMAGE, sharedPreferences.getString(IMAGE, null));
        user.put(TOKEN, sharedPreferences.getString(TOKEN, null));

        return user;
    }

    public void logoutSession() {
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
