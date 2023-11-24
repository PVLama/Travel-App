package com.example.btlandroid_travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.btlandroid_travelapp.R;
import com.example.btlandroid_travelapp.listener.ItemClickListener;
import com.example.btlandroid_travelapp.model.Foods;
import com.example.btlandroid_travelapp.model.Places;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.MyViewHoder> {
    Context context;
    List<Foods> foodsList;

    public FoodsAdapter(Context context, List<Foods> foodsList) {
        this.context = context;
        this.foodsList = foodsList;
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

        Foods foods = foodsList.get(position);
        holder.tenFoods.setText(foods.getTenmonan());
        Glide.with(context).load(foods.getHinhanh()).into(holder.imageFoods);

    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }


    public class MyViewHoder extends RecyclerView.ViewHolder {
        TextView tenFoods;
        ImageView imageFoods;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            tenFoods = itemView.findViewById(R.id.tenmonan);
            imageFoods = itemView.findViewById(R.id.imMonan);
        }

    }
}
