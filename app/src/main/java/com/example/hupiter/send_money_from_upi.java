package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class send_money_from_upi extends AppCompatActivity {

    TextView initials,fullname,upiid;
    EditText amountentered,note;
    Button continuedeposit;
    RadioGroup selectbankrg;
    RadioButton rbtn1,rbtn2,rbtn3;
    boolean selected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_from_upi);
        initials = (TextView) findViewById(R.id.initials);
        fullname = (TextView) findViewById(R.id.fullname);
        upiid = (TextView) findViewById(R.id.upiid);
        amountentered = (EditText) findViewById(R.id.amountentered);
        continuedeposit = (Button) findViewById(R.id.continuedeposit);
        selectbankrg= (RadioGroup) findViewById(R.id.selectbankrg);
        rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        rbtn3 = (RadioButton) findViewById(R.id.rbtn3);
        note = (EditText) findViewById(R.id.note);
        MainActivity fetch = new MainActivity();

        Intent getfrom = getIntent();
        fullname.setText(getfrom.getStringExtra("FULL NAME"));
        upiid.setText(getfrom.getStringExtra("UPI ID"));
        initials.setText(getfrom.getStringExtra("INITIALS"));

        continuedeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amountentered.getText().equals("") || amountentered.getText().equals("0"))
                {
                    Toast.makeText(send_money_from_upi.this, "Enter Amount", Toast.LENGTH_SHORT).show();
                }
                if(!rbtn1.isChecked())
                {
                    Toast.makeText(send_money_from_upi.this, "Select Mode", Toast.LENGTH_SHORT).show();
                }
                if(!amountentered.getText().equals("") && rbtn1.isChecked())
                {
                    if(Integer.parseInt(amountentered.getText().toString())>Integer.parseInt(fetch.balanceid.getText().toString()))
                    {
                        Toast.makeText(send_money_from_upi.this, "Amount more than Balance", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent inten = new Intent(send_money_from_upi.this,sending_pin.class);
                        inten.putExtra("FULL NAME",getfrom.getStringExtra("FULL NAME"));
                        inten.putExtra("MODE","Jupiter Wallet");
                        inten.putExtra("INITIALS",getfrom.getStringExtra("INITIALS"));
                        inten.putExtra("AMOUNTS",amountentered.getText().toString());
                        startActivity(inten);
                    }
                }
            }
        });
        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtn1.setChecked(true);
                rbtn2.setChecked(false);
                rbtn3.setChecked(false);
                selected=true;
            }
        });

        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtn2.setChecked(true);
                rbtn1.setChecked(false);
                rbtn3.setChecked(false);
                selected=true;
            }
        });

        rbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtn2.setChecked(false);
                rbtn1.setChecked(false);
                rbtn3.setChecked(true);
                selected=true;
            }
        });
    }
}