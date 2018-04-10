package com.connect.dsb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    // private GestureDetector gestureDetector;
    //ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        //   gestureDetector=(new GestureDetector(this, new MyGestureListener(this)));
//       this.findViewById(R.id.nxt).setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent i = new Intent(getApplicationContext(),login_info.class);
//               startActivity(i);
//
//
//           }
//       });
    }
}

//    private void showProgressDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(this,R.drawable.cutom_progress));
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setMessage("Please wait...");
//        progressDialog.show();
//    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
//    }
//}

