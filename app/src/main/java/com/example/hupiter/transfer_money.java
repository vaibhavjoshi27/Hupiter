package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class transfer_money extends AppCompatActivity {
    Button banktransferbutton, upitransferbutton;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_money);

        banktransferbutton = (Button) findViewById(R.id.banktransferbutton);
        upitransferbutton = (Button) findViewById(R.id.upitransferbutton);
        container = (FrameLayout) findViewById(R.id.container);

        loadfrags(new upi_payment(),0);

        banktransferbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrags(new bank_transfer(),1);
            }
        });

        upitransferbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrags(new upi_payment(),1);
            }
        });
    }

    public void loadfrags(Fragment fragment,int flag)
    {
        if(flag==0) {
            container.removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container,fragment);
            ft.commit();
        }
        else
        {
            container.removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container,fragment);
            ft.commit();
        }
    }
}