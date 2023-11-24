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
import com.example.btlandroid_travelapp.model.Favourite;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHoder>{
    Context context;
    List<Favourite> favouriteList;
    private FavouriteAdapter favouriteAdapter;

    public FavouriteAdapter(Context context, List<Favourite> favouriteList) {
        this.context = context;
        this.favouriteList = favouriteList;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item,parent,false);

        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {

        Favourite favourite = favouriteList.get(position);
        holder.tenDiaDiem.setText(favourite.getTendiadiem());
        holder.tenDiaDanh.setText(favourite.getTendiadanh());
        Glide.with(context).load(favourite.getHinhanh()).into(holder.imageViewDiaDanh);


    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }


    public class MyViewHoder extends RecyclerView.ViewHolder {
        ImageView imageViewDiaDanh;
        TextView tenDiaDanh, tenDiaDiem;
        ImageView favImage;

        private FavouriteAdapter favouriteAdapter;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            imageViewDiaDanh = itemView.findViewById(R.id.imDiadanh);
            tenDiaDanh = itemView.findViewById(R.id.Tendiadanh);
            tenDiaDiem = itemView.findViewById(R.id.Tendiadiem);
            favImage = itemView.findViewById(R.id.image_fav);

//            favImage.setOnClickListener(view -> {
//                favouriteAdapter.favouriteList.remove(getAdapterPosition());
//                favouriteAdapter.notifyDataSetChanged();
//
//            });
//        }
//    }
//
//    public FavouriteAdapter linkAdapter(FavouriteAdapter favouriteAdapter){
//       this.favouriteAdapter = favouriteAdapter;
//       return this;
//    }
        }
        }
}
