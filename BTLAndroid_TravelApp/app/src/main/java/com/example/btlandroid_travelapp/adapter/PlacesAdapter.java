package com.example.btlandroid_travelapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.activity.DetailActivity;
import com.example.btlandroid_travelapp.listener.ItemClickListener;
import com.example.btlandroid_travelapp.model.Detail;
import com.example.btlandroid_travelapp.model.Foods;
import com.example.btlandroid_travelapp.model.Places;
import com.google.android.gms.common.internal.service.Common;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHoder> {

    Context context;
    List<Places> placesList;

    public PlacesAdapter(Context context, List<Places> placesList) {
        this.context = context;
        this.placesList = placesList;
    }

    public void setPlacesList(List<Places> placesList) {
        this.placesList = placesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_places, parent,false);
        return new MyViewHoder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        MyViewHoder myViewHoder = (MyViewHoder) holder;

        Places places = placesList.get(position);
        holder.tenDiaDanh.setText(places.getTendiadanh());
        holder.tenDiaDiem.setText(places.getTendiadiem());

        Glide.with(context).load(places.getHinhanh()).into(holder.imDiaDanh);

        myViewHoder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isClick) {
                if (!isClick){
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }


    public class MyViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tenDiaDanh, tenDiaDiem;
        ImageView imDiaDanh;
        private ItemClickListener itemClickListener;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            tenDiaDanh = itemView.findViewById(R.id.Tendiadanh);
            tenDiaDiem = itemView.findViewById(R.id.Tendiadiem);
            imDiaDanh = itemView.findViewById(R.id.imDiadanh);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }

}
