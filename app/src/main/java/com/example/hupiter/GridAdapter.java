package com.example.hupiter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class GridAdapter extends BaseAdapter {
    Context context;

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        if(MainActivity.payeelist.size()>10)
        return 10;
        else
            return MainActivity.payeelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutinflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = layoutinflate.inflate(R.layout.payee_grid,null,false);

                ImageView img =(ImageView) v.findViewById(R.id.img);
                TextView textviewgrid = (TextView) v.findViewById(R.id.textviewtitle);
                TextView initial = (TextView) v.findViewById(R.id.initial);

                if(!MainActivity.payeelist.isEmpty()) {
                    img.setImageResource(R.drawable.payee_recent);
                    textviewgrid.setText(MainActivity.payeelist.get(i).name);
                    initial.setText(MainActivity.payeelist.get(i).init);
                }
                else if(MainActivity.payeelist.isEmpty())
                {
                    img.setImageResource(R.drawable.debit_card_foreground);
                    textviewgrid.setText("NULL");
                    initial.setText("NULL");
                }

        return v;
    }
}
