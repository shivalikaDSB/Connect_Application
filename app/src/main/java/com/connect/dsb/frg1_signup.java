package com.connect.dsb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.bridge.Bridge;
import com.afollestad.bridge.BridgeException;
import com.afollestad.bridge.Form;
import com.afollestad.bridge.Request;

/**
 * Created by monagarg on 24/03/18.
 */

    public class frg1_signup extends Fragment {
    private Vibrator vib;
    private TextInputLayout d_name,d_password,d_confirmPassword;
    EditText username,password,confirm_password;
    Button signup;
    String email,f_name,L_name,mobile,result1,username1,password1,confirm_password1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



       View view= inflater.inflate(R.layout.frag_signup1_layout,container,false);

       signup=(Button)view.findViewById(R.id.b1);
        TextView txt=(TextView)view.findViewById(R.id.t3);
        d_name=(TextInputLayout)view.findViewById(R.id.di_username);
        d_password=(TextInputLayout)view.findViewById(R.id.d_password);
        d_confirmPassword=(TextInputLayout)view.findViewById(R.id.d_confirmpassword);
        username =(EditText)view.findViewById(R.id.r_username);
        password=(EditText)view.findViewById(R.id.password);
        confirm_password=(EditText)view.findViewById(R.id.confirm_password);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });

         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Preference_Helper helper = new Preference_Helper(getActivity());
                 email = helper.email();
                 f_name = helper.firstname();
                 L_name = helper.lastname();
                 mobile = helper.mobileno();
                 username1=helper.usernamee();
                 password1=helper.passwordd();
                 confirm_password1=helper.confirm_passwordd();
             //   Toast.makeText(getActivity()," " +f_name + " " +L_name+ " " +email+" "+ mobile +" " +username1+""+password1+" " +confirm_password1,Toast.LENGTH_LONG).show();

                 Form form=new Form().add("f_name",f_name)
                         .add("l_name",L_name)
                         .add("email",email)
                         .add("mobile",mobile)
                         .add("username",username1)
                         .add("password",password1)
                         .add("confirmpassword",confirm_password1);
                 try {
                     Request request=Bridge
                             .post("http://test.dasbedutech.in/users")
                             .body(form)
                             .request();
                 } catch (BridgeException e) {
                     e.printStackTrace();
                 }
                 Intent intent = new Intent(getActivity(), BottomNavigation.class);
                 startActivity(intent);

             }

         });

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Preference_Helper helper=new Preference_Helper(getActivity());
                helper.usernamee(username.getText().toString());
                boolean isvalid=true;
                if (username.getText().toString().isEmpty()) {
                    d_name.setError("full name is mandatory");
                    isvalid = false;
                }
                else {
                    d_name.setErrorEnabled(false);
                }
            }

        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Preference_Helper helper=new Preference_Helper(getActivity());
                helper.password(password.getText().toString());

                boolean isvalid=true;

//                  if (password!= null && password.length()> 8)
                if(password!=null && password.length()<8)         {
                    d_password.setError("enter atleast 8 character long");
                    isvalid = false;
                }
                else {
                    d_password.setErrorEnabled(false);
                }

            }

        });
        confirm_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Preference_Helper helper=new Preference_Helper(getActivity());
                helper.confirm_password(confirm_password.getText().toString());
                boolean isvalid = false;
                if(confirm_password.getText().toString().equals(password.getText().toString()))
                {

                    d_confirmPassword.setErrorEnabled(false);
                    isvalid = true;

                }

                else {
                    d_confirmPassword.setError("password doesn't match");
                }
            }
        });
        return view;



    }
}
