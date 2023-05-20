package com.example.hupiter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BannerAdapterHome extends RecyclerView.Adapter<BannerAdapterHome.ViewHolder> {
    Context context;
    ArrayList<Bannerdata> bannerdata;
    public BannerAdapterHome(Context context,ArrayList<Bannerdata> bannerdata){
        this.context=context;
        this.bannerdata=bannerdata;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bannerview= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_view,parent,false);
        ViewHolder homebannerviewholder = new ViewHolder(bannerview);
        return homebannerviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapterHome.ViewHolder holder, int position) {
        holder.banner.setImageResource(bannerdata.get(position).img);
    }

    @Override
    public int getItemCount() {
        return bannerdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = (ImageView) itemView.findViewById(R.id.banner);
        }
    }
}
