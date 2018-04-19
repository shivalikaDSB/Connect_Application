package com.connect.dsb.communityFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.connect.dsb.R;
import com.connect.dsb.communityAdapter.CommunityAdapter;
import com.connect.dsb.communityModel.CommunityBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Community extends Fragment {

    public Community() {
    }

    private final String JSON_URL="https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";

    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<CommunityBean> list = new ArrayList<>();
    private RecyclerView myrv ;
    ProgressDialog progressDialog;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

//        getActivity().setTitle("Events of ICDP");

    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
                View rootView =inflater.inflate(R.layout.community, container, false);

                myrv=rootView.findViewById(R.id.recyclerview_community);
                progressDialog=new ProgressDialog(getContext());
                progressDialog.setMessage("please wait...");
                progressDialog.setCancelable(false);

                        jsoncall();

                        return rootView;
    }
    public void jsoncall() {
        ArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0 ; i<response.length();i++) {

                    try {

                        jsonObject = response.getJSONObject(i);
                        CommunityBean communityBean = new CommunityBean();
                        communityBean.setName(jsonObject.getString("name"));
                        communityBean.setRating(jsonObject.getString("Rating"));
                        communityBean.setDescription(jsonObject.getString("description"));
                        communityBean.setImage_url(jsonObject.getString("img"));
                        communityBean.setStudios(jsonObject.getString("studio"));
                        communityBean.setCategories(jsonObject.getString("categorie"));
                        progressDialog.dismiss();

                        list.add(communityBean);


                    } catch (JSONException e) {
                        progressDialog.dismiss();

                        e.printStackTrace();

                    }
                }

                setCommuntyAdapter(list);

            }
        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {


            }
        });

        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(ArrayRequest);
        progressDialog.show();
    }


    private void setCommuntyAdapter(List<CommunityBean> list) {

       CommunityAdapter  myAdapter = new CommunityAdapter(getContext(),list) ;
        myrv.setLayoutManager(new LinearLayoutManager(getContext()));
        myrv.setAdapter(myAdapter);


    }

}


