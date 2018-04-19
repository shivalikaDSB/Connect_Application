package com.connect.dsb.communityAdapter;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.connect.dsb.R;
import com.connect.dsb.communityModel.CommunityBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.MyViewHolder> {

        RequestOptions options ;
        private Context mContext ;
        private List<CommunityBean> mData ;
        ProgressDialog progressDialog;


    public CommunityAdapter(Context mContext, List lst) {


            this.mContext = mContext;
            this.mData = lst;
            options = new RequestOptions()
                    .centerCrop();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view ;
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            view = mInflater.inflate(R.layout.community_model_row_item,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {


            holder.name.setText(mData.get(position).getName());
            holder.rating.setText(mData.get(position).getRating());
            holder.studio.setText(mData.get(position).getStudios());
            holder.category.setText(mData.get(position).getCategories());
            // load image from the internet using Glide
            Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.AnimeThumbnail);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView name,rating,studio,category;
            RoundedImageView AnimeThumbnail;


            public MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                studio = itemView.findViewById(R.id.studio);
                rating = itemView.findViewById(R.id.rating);
                category = itemView.findViewById(R.id.category);
                AnimeThumbnail = itemView.findViewById(R.id.thumbnail);
            }
        }


    }


