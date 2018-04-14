package com.connect.dsb;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import com.connect.dsb.communityFragment.Community;

import java.lang.reflect.Field;

public class  BottomNavigation extends AppCompatActivity {

    private TextView mTextMessage;
    Toolbar toolbar;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected( @NonNull MenuItem item ) {
            switch (item.getItemId()) {
                case R.id.navigation_left:
                    changeFragment(new NavigationLeft());
                    return true;
                case R.id.navigation_home:
                    Intent one = new Intent(BottomNavigation.this, BottomNavigation.class);
                    //Backstack clear in activity
                    one.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(one);
                    break;
                case R.id.navigation_notifications:
                    changeFragment(new Notification());
                    return true;
//              case R.id.navigation_logout:
//                    Intent two = new Intent(BottomNavigation.this, Login.class);
//                    //Backstack clear in activity
//                    two.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(two);

                //    return true;

//                    Intent two = new Intent(BottomNavigation.this, Login.class);
//                    two.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(two);
////                    session.logoutUser();
//                    break;
//                    changeFragment(new Login());
//                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
//        setTitle("gfhjhgg");
        setContentView(R.layout.bottom_navigation);

//        Toolbar toolbar=(Toolbar)findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);

        // Session class instance

//
//        TextView lblName = (TextView) findViewById(R.id.lblName);
//        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);

//        btnLogout = (Button) findViewById(R.id.btnLogout);



        // displaying user data
//        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
//        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));


        /**
         * Logout button click event
         * */
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Clear the session data
//                // This will clear all session data and
//                // redirect user to LoginActivity
//                session.logoutUser();
//            }

        mTextMessage = (TextView) findViewById(R.id.message);
        TextView t1 =(TextView)findViewById(R.id.wallet);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    private void changeFragment(Fragment fm){
//      final FrameLayout fl = (FrameLayout) findViewById(R.id.content);
//        fl.removeAllViews();


        //Backstack clear in fragment(back back issue solve
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, fm);

        ft.setTransition(FragmentTransaction.TRANSIT_NONE);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();


    }

//    protected OnBackPressedListener onBackPressedListener;
//
//    public interface OnBackPressedListener {
//        void doBack();
//    }
//
//    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
//        this.onBackPressedListener = onBackPressedListener;
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (onBackPressedListener != null)
//            onBackPressedListener.doBack();
//        else
//            super.onBackPressed();
//    }
    public void wallet(View view) {
        changeFragment(new WalletActivity());
    }
    public void community(View view) {

        changeFragment(new Community());
    }
    public void upcoming(View view) {
        changeFragment(new UpcomingEventActivity());
    }
    public void chatbox(View view) { Intent i = new Intent(this, Chatbox.class);
        startActivity(i); }
}

class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode( BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

}

