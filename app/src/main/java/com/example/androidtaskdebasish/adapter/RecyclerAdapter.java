package com.example.androidtaskdebasish.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.androidtaskdebasish.R;
import com.example.androidtaskdebasish.model.Context;
import com.example.androidtaskdebasish.model.DataClass;
import com.example.androidtaskdebasish.model.Image;
import com.example.androidtaskdebasish.view.ViewImages;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ViewImages context;
    ArrayList<Image>  imageArrayList = new ArrayList<>();

    public RecyclerAdapter(ViewImages context, ArrayList<Image> imageArrayList) {
        this.context = context;
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Image image = imageArrayList.get(position);
        Log.d("!!!contextimage",String.valueOf(image.getContextLink()));

        RequestOptions defaultOptions = new RequestOptions().error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(defaultOptions)
                .load(image.getContextLink())
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if(imageArrayList.size() == 0){

        }else {
            imageArrayList.size();
        }
        Log.d("!!!image_size",String.valueOf(imageArrayList.size()));
        return imageArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
