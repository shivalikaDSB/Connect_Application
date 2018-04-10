package com.connect.dsb;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by monagarg on 30/03/18.
 */

public class Preference_Helper {


    public static final String PREFERENCE_NAME = "ISCK_PREF";
    public static final String REGISTERED = "IS_REGISTERED";
    public static final String F_NAME = "f_name";
    public static final String L_NAME = "l_name";
    public static final String EMAIL = "email";
    public static final String Mobile = "mobile";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirm_password";


    /*
    *   METHODS FOR ACCESSING/WRITING THE PREFERENCES VALUES
    * */

    private SharedPreferences preferences;
    private Context context;

    public Preference_Helper(Context context) {
        this.context = context;
        openPreferences();

    }

    private void unregisterUser() {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, false).apply();
    }


    private void openPreferences() {
        this.preferences = this.context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }


    public void registerUser(String email) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(EMAIL,email).apply();
    }
    public void usernamee(String username) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(USER_NAME,username).apply();
    }
    public void password(String password) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(PASSWORD,password).apply();
    }

    public void confirm_password(String confirm_password) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(CONFIRM_PASSWORD,confirm_password).apply();
    }

    public void first_name(String f_name) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(F_NAME,f_name).apply();
    }

    public void Last_name(String l_name) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(L_NAME,l_name).apply();
    }

    public void Mobile_number(String mobile) {
        openPreferences();
        this.preferences.edit().putBoolean(REGISTERED, true).apply();
        this.preferences.edit().putString(Mobile,mobile).apply();
    }
    public String firstname() {
        openPreferences();
        if (this.preferences == null)
            return firstname();       //representing null value in world of numbers
        return this.preferences.getString(F_NAME, "f_name");
    }
    public String lastname() {
        openPreferences();
        if (this.preferences == null)
            return lastname();       //representing null value in world of numbers
        return this.preferences.getString(L_NAME, "l_name");
    }
    public String email() {
        openPreferences();
        if (this.preferences == null)
            return email();       //representing null value in world of numbers
        return this.preferences.getString(EMAIL, "email");
    }
    public String mobileno() {
        openPreferences();
        if (this.preferences == null)
            return mobileno();       //representing null value in world of numbers
        return this.preferences.getString(Mobile, "mobile");
    }


    public String usernamee() {
        openPreferences();
        if (this.preferences == null)
            return usernamee();       //representing null value in world of numbers
        return this.preferences.getString(USER_NAME, "user_name");
    }

    public String passwordd() {
        openPreferences();
        if (this.preferences == null)
            return passwordd();       //representing null value in world of numbers
        return this.preferences.getString(PASSWORD, "password");
    }
    public String confirm_passwordd() {
        openPreferences();
        if (this.preferences == null)
            return confirm_passwordd();       //representing null value in world of numbers
        return this.preferences.getString(CONFIRM_PASSWORD, "confirmpassword");
    }

}
