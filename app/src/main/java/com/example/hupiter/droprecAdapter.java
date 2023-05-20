package com.example.hupiter;


import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class droprecAdapter extends RecyclerView.Adapter<droprecAdapter.ViewHolder> {
    Context context;
    ArrayList<droprecdata> dropdata;

    droprecAdapter(Context context,ArrayList<droprecdata> dropdata)
    {
        this.context=context;
        this.dropdata=dropdata;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdownrecyclerviewhome,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.merchantname.setText(dropdata.get(position).merchantname);
        holder.timendate.setText(dropdata.get(position).timendate);
        holder.amnt.setText(dropdata.get(position).amnt);
        holder.image.setImageResource(dropdata.get(position).image);
    }

    @Override
    public int getItemCount() {
        return dropdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView merchantname,timendate,amnt;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            merchantname = itemView.findViewById(R.id.merchantname);
            timendate= itemView.findViewById(R.id.timeoftransaction);
            amnt= itemView.findViewById(R.id.transactionamount);
            image= itemView.findViewById(R.id.CenterHomeCardViewImage1);
        }
    }
}
