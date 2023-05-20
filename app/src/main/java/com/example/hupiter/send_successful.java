package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class send_successful extends AppCompatActivity {
    String amt;
    public static int send_flag=0;
    long xyz;
    String mode,name,fullname,initials,time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_successful);

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        time=sdf.format(date);

        Intent in = getIntent();
        amt=in.getStringExtra("AMOUNTS");
        mode=in.getStringExtra("MODE");
        initials=in.getStringExtra("INITIALS");
        fullname=in.getStringExtra("FULL NAME");
        send_flag=1;

        int present =0;
        for(int i=0;i<MainActivity.payeelist.size();i++)
        {
            if(MainActivity.payeelist.get(i).name == fullname)
                present=1;
        }
        if(present==0)
        {
            MainActivity.payeelist.add(new Payees(initials,fullname));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Subfn();
                MainActivity.dropdata.add(new droprecdata(R.drawable.debit_card_foreground,fullname,time,"- "+amt));


                Intent i=new Intent(send_successful.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("AMOUNTS",xyz);
                startActivity(i);
            }
        }, 2000);
    }

    public void Subfn()
    {
        String aa = amt;
        String bb;
        bb = MainActivity.balanceid.getText().toString();
        int a=Integer.parseInt(aa);
        int c=Integer.parseInt(bb);
        xyz=c-a;
    }
}