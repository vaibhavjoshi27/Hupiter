package com.example.hupiter;

import static com.example.hupiter.MainActivity.sendamount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.BaseMenuPresenter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DepositFromHome extends AppCompatActivity {
    Button back_to_home;
    public static EditText amountentered;
    RadioButton button1,button2,button3,button4;
    Button continuetodeposit;
    RadioGroup selectbankrg;
    RadioButton rbtn1,rbtn2;

    boolean selected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_from_home);


        back_to_home= (Button) findViewById(R.id.back_to_home);
        amountentered= (EditText) findViewById(R.id.amountentered);
        button1 = (RadioButton) findViewById(R.id.button1);
        button2 = (RadioButton) findViewById(R.id.button2);
        button3 = (RadioButton) findViewById(R.id.button3);
        button4 = (RadioButton) findViewById(R.id.button4);
        rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        selectbankrg = (RadioGroup) findViewById(R.id.selectbankrg);
        continuetodeposit = (Button) findViewById(R.id.continuedeposit);


        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_tohome = new Intent(DepositFromHome.this,MainActivity.class);
                back_tohome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_tohome);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove_effects("button1");
                amountentered.setText(button1.getText().toString());
                    button1.setBackgroundColor(getResources().getColor(R.color.TextGreen));
                    button1.setTextColor(getResources().getColor(R.color.BackgroundGreen));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove_effects("button2");
                amountentered.setText(button2.getText().toString());
                button2.setBackgroundColor(getResources().getColor(R.color.TextGreen));
                button2.setTextColor(getResources().getColor(R.color.BackgroundGreen));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove_effects("button3");
                amountentered.setText(button3.getText().toString());
                button3.setBackgroundColor(getResources().getColor(R.color.TextGreen));
                button3.setTextColor(getResources().getColor(R.color.BackgroundGreen));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove_effects("button4");
                amountentered.setText(button4.getText().toString());
                button4.setBackgroundColor(getResources().getColor(R.color.TextGreen));
                button4.setTextColor(getResources().getColor(R.color.BackgroundGreen));
            }
        });

        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    rbtn1.setChecked(true);
                    rbtn2.setChecked(false);
                    selected=true;
            }
        });

        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    rbtn2.setChecked(true);
                    rbtn1.setChecked(false);
                    selected=true;
            }
        });
        continuetodeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtn1.isChecked() || rbtn2.isChecked())
                {
                    if(!amountentered.getText().toString().equals(""))
                    {
                        if(rbtn1.isChecked()) {
                            if(amountentered.getText().toString()!="100000")
                            {
                                String a = amountentered.getText().toString();
                                Intent continue_to_pay = new Intent(DepositFromHome.this, pin.class);
                                continue_to_pay.putExtra("amount", a);
                                continue_to_pay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(continue_to_pay);
                            }
                            else
                            {
                                Toast.makeText(DepositFromHome.this, "Amount More than Limit", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(DepositFromHome.this, "Backend not ready", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(DepositFromHome.this, "Enter Amount", Toast.LENGTH_SHORT).show();
                    }
                }
                else if((!rbtn1.isChecked() || !rbtn2.isChecked()))
                {
                    if(amountentered.getText().toString().equals("")) {
                        Toast.makeText(DepositFromHome.this, "Enter Amount", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(DepositFromHome.this, "Select Payment Mode", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void remove_effects(String s)
    {
        if(s.equals("button1"))
        {
            button2.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button2.setTextColor(getResources().getColor(R.color.TextGreen));

            button3.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button3.setTextColor(getResources().getColor(R.color.TextGreen));

            button4.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button4.setTextColor(getResources().getColor(R.color.TextGreen));

        }
        else if(s.equals("button2"))
        {
            button1.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button1.setTextColor(getResources().getColor(R.color.TextGreen));

            button3.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button3.setTextColor(getResources().getColor(R.color.TextGreen));

            button4.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button4.setTextColor(getResources().getColor(R.color.TextGreen));

        }
        else if(s.equals("button3"))
        {
            button1.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button1.setTextColor(getResources().getColor(R.color.TextGreen));

            button2.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button2.setTextColor(getResources().getColor(R.color.TextGreen));

            button4.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button4.setTextColor(getResources().getColor(R.color.TextGreen));

        }
        else if(s.equals("button4"))
        {
            button2.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button2.setTextColor(getResources().getColor(R.color.TextGreen));

            button3.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button3.setTextColor(getResources().getColor(R.color.TextGreen));

            button1.setBackgroundColor(getResources().getColor(R.color.BackgroundGreen));
            button1.setTextColor(getResources().getColor(R.color.TextGreen));

        }
    }
}