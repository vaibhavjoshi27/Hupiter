package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class sending_pin extends AppCompatActivity {
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    TextView hidebtn,pin_amount,payvia;
    ImageButton buttonback,buttoncontinue,hide;
    EditText pos1,pos2,pos3,pos4;
    private int count=2;
    private static final String Channel_id ="Send Notifications";
    String amt;
    public static int send_back_pressed=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_pin);

        pin_amount = findViewById(R.id.pin_amount);
        payvia = (TextView) findViewById(R.id.payvia);

        Intent fromsend = getIntent();
        pin_amount.setText("Rs "+ fromsend.getStringExtra("AMOUNTS"));
        payvia.setText(fromsend.getStringExtra("MODE"));
        amt=fromsend.getStringExtra("AMOUNTS");

        button0 = findViewById(R.id.button0);
        button1 =findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        button4 =  findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 =findViewById(R.id.button7);
        button8 =findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonback = findViewById(R.id.buttonback);
        buttoncontinue = findViewById(R.id.buttoncontinue);
        hide = findViewById(R.id.hide);

        pos1= findViewById(R.id.pos1);
        pos2= findViewById(R.id.pos2);
        pos3= findViewById(R.id.pos3);
        pos4= findViewById(R.id.pos4);

        hidebtn = findViewById(R.id.hidebtn);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("0");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("8");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("7");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkif("9");
            }
        });
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBack();
            }
        });
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!pos4.getText().toString().equals("")) {
                    String password = pos1.getText().toString() + pos2.getText().toString() + pos3.getText().toString() + pos4.getText().toString();
                    if(password.equals("1235")) {
                        Intent flashpay = new Intent(sending_pin.this, send_successful.class);
                        flashpay.putExtra("AMOUNTS", amt);
                        flashpay.putExtra("FULL NAME",fromsend.getStringExtra("FULL NAME"));
                        flashpay.putExtra("INITIALS",fromsend.getStringExtra("INITIALS"));
                        flashpay.putExtra("MODE",fromsend.getStringExtra("MODE"));
                        flashpay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(flashpay);

                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Notification deposit_success = null;

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
                        {
                            deposit_success = new Notification.Builder(sending_pin.this)
                                    .setSmallIcon(R.drawable.payment_done_foreground)
                                    .setContentText("Sent Rs " + fromsend.getStringExtra("AMOUNTS") + " Successful")
                                    .setSubText("Payment Successful")
                                    .setChannelId(Channel_id)
                                    .build();
                            nm.createNotificationChannel(new NotificationChannel(Channel_id, "New channel", NotificationManager.IMPORTANCE_HIGH));
                        }
                        else
                        {
                            deposit_success = new Notification.Builder(sending_pin.this)
                                    .setSmallIcon(R.drawable.payment_done_foreground)
                                    .setContentText("Sent Rs " + fromsend.getStringExtra("AMOUNTS") +" Successful")
                                    .setSubText("Payment Successful")
                                    .build();
                        }
                        nm.notify(1,deposit_success);
                    }
                    else
                    {
                        Toast.makeText(sending_pin.this, "Wrong PIN", Toast.LENGTH_SHORT).show();
                        pos1.setText("");
                        pos2.setText("");
                        pos3.setText("");
                        pos4.setText("");
                    }
                }
                else
                {
                    Toast.makeText(sending_pin.this, "Enter Complete PIN", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(count%2 == 0)
                {
                    pos1.setVisibility(View.INVISIBLE);
                    pos2.setVisibility(View.INVISIBLE);
                    pos3.setVisibility(View.INVISIBLE);
                    pos4.setVisibility(View.INVISIBLE);
                    hidebtn.setTextSize(15);
                    hide.setImageResource(R.drawable.show_pass_foreground);
                    hidebtn.setText("Show");
                    count++;
                }
                else
                {
                    pos1.setVisibility(View.VISIBLE);
                    pos2.setVisibility(View.VISIBLE);
                    pos3.setVisibility(View.VISIBLE);
                    pos4.setVisibility(View.VISIBLE);
                    hide.setImageResource(R.mipmap.eye_open);
                    hidebtn.setText("Hide");
                    count++;
                }
            }
        });
    }
    public void Checkif(String s)
    {
        if(pos1.getText().toString().equals(""))
        {
            pos1.setText(s);
        }
        else if(pos2.getText().toString().equals(""))
        {
            pos2.setText(s);
        }
        else if(pos3.getText().toString().equals(""))
        {
            pos3.setText(s);
        }
        else if(pos4.getText().toString().equals(""))
        {
            pos4.setText(s);
        }
        else
        {
            Toast.makeText(this, "PIN Entered", Toast.LENGTH_SHORT).show();
        }
    }
    public void CheckBack()
    {
        if(!pos4.getText().toString().equals(""))
        {
            pos4.setText("");
        }
        else if(!pos3.getText().toString().equals(""))
        {
            pos3.setText("");
        }
        else if(!pos2.getText().toString().equals(""))
        {
            pos2.setText("");
        }
        else if(!pos1.getText().toString().equals(""))
        {
            pos1.setText("");
        }
    }
    @Override
    public void onBackPressed()
    {
        send_back_pressed=1;
        long amt = Long.parseLong(MainActivity.balanceid.getText().toString());
        Intent i = new Intent(sending_pin.this,payment_failed.class);
        i.putExtra("AMOUNTS",amt);
        startActivity(i);
    }
}