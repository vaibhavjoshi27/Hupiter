package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class payment_failed extends AppCompatActivity {
    public static int failed=0;
    public static int send_fail=0,deposit_fail=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_failed);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sending_pin.send_back_pressed==1) {
                    sending_pin.send_back_pressed=0;
                    failed=1;
                    send_fail=1;
                    Intent fromsend= getIntent();
                    Long amt = fromsend.getLongExtra("AMOUNTS",0);
                    Intent i = new Intent(payment_failed.this, MainActivity.class);
                    i.putExtra("AMOUNTS",amt);
                    startActivity(i);
                }
                if(pin.send_back_pressed ==1){
                    pin.send_back_pressed=0;
                    failed=1;
                    deposit_fail=1;
                    Intent fromsend= getIntent();
                    Long amt = fromsend.getLongExtra("AMOUNT",0);
                    Intent i = new Intent(payment_failed.this, MainActivity.class);
                    i.putExtra("AMOUNT",amt);
                    startActivity(i);
                }
            }
        }, 2000);
    }
}