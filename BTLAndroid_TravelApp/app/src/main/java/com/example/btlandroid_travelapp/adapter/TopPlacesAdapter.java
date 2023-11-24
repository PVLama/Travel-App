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
import com.example.btlandroid_travelapp.activity.DetailTopPlacesActivity;
import com.example.btlandroid_travelapp.listener.ItemClickListener;
import com.example.btlandroid_travelapp.model.Places;
import com.example.btlandroid_travelapp.model.TopPlaces;

import java.util.List;

public class TopPlacesAdapter extends RecyclerView.Adapter<TopPlacesAdapter.MyViewHoder>{
    Context context;
    List<TopPlaces> topPlacesList;

    public TopPlacesAdapter(Context context, List<TopPlaces> TopplacesList) {
        this.context = context;
        this.topPlacesList = TopplacesList;
    }
    public void setTopPlacesList(List<TopPlaces> TopplacesList) {
        this.topPlacesList = TopplacesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_places, parent,false);
        return new TopPlacesAdapter.MyViewHoder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
         MyViewHoder myViewHoder = (MyViewHoder) holder;

        TopPlaces topPlaces = topPlacesList.get(position);
        holder.tenTopDiaDanh.setText(topPlaces.getTendiadanh());
        holder.tenTopDiaDiem.setText(topPlaces.getTendiadiem());
        Glide.with(context).load(topPlaces.getHinhanh()).into(holder.imTopDiaDanh);

        myViewHoder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isClick) {
                if (!isClick){
                    Intent intent = new Intent(context, DetailTopPlacesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return topPlacesList.size();
    }


    public class MyViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tenTopDiaDanh, tenTopDiaDiem;
        ImageView imTopDiaDanh;
        private ItemClickListener TopitemClickListener;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            tenTopDiaDanh = itemView.findViewById(R.id.Tentopdiadanh);
            tenTopDiaDiem = itemView.findViewById(R.id.Tentopdiadiem);
            imTopDiaDanh = itemView.findViewById(R.id.imTopDiadanh);

            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener TopitemClickListener) {
            this.TopitemClickListener = TopitemClickListener;
        }
        @Override
        public void onClick(View view) {
            TopitemClickListener.onClick(view, getAdapterPosition(), false);
        }

    }


}
