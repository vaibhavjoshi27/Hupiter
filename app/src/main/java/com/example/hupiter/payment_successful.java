package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class payment_successful extends AppCompatActivity {
    String amt,time;
    MainActivity neuobj = new MainActivity();
    public static long xyz;
    public static int ps_flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_successful);


        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        time=sdf.format(date);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ps_flag=1;
                Intent getfrom = getIntent();
                amt= getfrom.getStringExtra("amount");
                MainActivity.dropdata.add(new droprecdata(R.drawable.payment_successfull_foreground,"Deposit",time,"+ "+amt));
                Intent i=new Intent(payment_successful.this,MainActivity.class);
                Sumfn();
                i.putExtra("Amant",xyz);
                startActivity(i);
            }
        }, 2000);
    }
    public void Sumfn()
    {
        String aa = amt;
        String bb;
        if(neuobj.balanceid.getText().toString()=="")
        {
            bb="0";
        }
        else
        {
            bb= neuobj.balanceid.getText().toString();
        }
        int a=Integer.parseInt(aa);
        int c=Integer.parseInt(bb);
        xyz=a+c;
    }
}