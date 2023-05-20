package com.example.hupiter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAdapterHome extends RecyclerView.Adapter<HorizontalAdapterHome.RecyclerViewHolder> {
    Context context;
    ArrayList<HomeHorizontalRecyclerViewData> data;
    HorizontalAdapterHome(Context context, ArrayList<HomeHorizontalRecyclerViewData> data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.horizontal_recycler_view_home,parent,false);
        RecyclerViewHolder viewHolder= new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.imgbtn.setImageResource(data.get(position).img);
        holder.txtview.setText(data.get(position).title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageButton imgbtn;
        TextView txtview;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgbtn = itemView.findViewById(R.id.horizontalhomerecyclerviewbutton);
            txtview=itemView.findViewById(R.id.horizontalhomerecyclerviewtext);
        }
    }
}
