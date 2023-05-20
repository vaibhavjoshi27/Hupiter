package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity<BannerData> extends AppCompatActivity {

    HorizontalAdapterHome horizontalAdapterHome;
    Button depositmoney;
    RecyclerView homerecyclerview,bannerrecyclerviewhome,drp;
    ImageView homeslider;
    FloatingActionButton scan;

    static ArrayList<Payees> payeelist = new ArrayList<Payees>();
    ArrayList<HomeHorizontalRecyclerViewData> HHRVdata = new ArrayList<>();
    ArrayList<BannerData> Bannerdata = new ArrayList<>();
    public static ArrayList<droprecdata> dropdata = new ArrayList<>();

    public static TextView balanceid;
    ImageButton hidenshow,droprecyclerhome;

    int hidecount=0;
    public static long p=0;
    static MainActivity sendamount;
    public int send_intent,deposit_intent=1;
    long amt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balanceid = (TextView) findViewById(R.id.balanceid);

        if(payment_failed.failed==1)
        {
            payment_failed.failed=0;
            if(payment_failed.send_fail==1)
            {
                payment_failed.send_fail=0;
                Intent getfrom= getIntent();
                balanceid.setText(String.valueOf(getfrom.getLongExtra("AMOUNTS",0)));
            }
            if(payment_failed.deposit_fail==1)
            {
                payment_failed.deposit_fail=0;
                Intent getfrom= getIntent();
                balanceid.setText(String.valueOf(getfrom.getLongExtra("AMOUNT",0)));
            }
        }

        if(payment_successful.ps_flag==1) {
            payment_successful.ps_flag=0;
            Intent i = getIntent();
            amt = i.getLongExtra("Amant", p);
            balanceid.setText(Long.toString(amt));
        }

            if(send_successful.send_flag==1) {
                send_successful.send_flag=0;
                Intent getin = getIntent();
                amt = getin.getLongExtra("AMOUNTS", p);
                balanceid.setText(String.valueOf(amt));
            }


        droprecyclerhome = (ImageButton) findViewById(R.id.droprecyclerhome);
        drp = (RecyclerView) findViewById(R.id.drp);
        drp.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        droprecAdapter drpadapter = new droprecAdapter(this,dropdata);
        drp.setAdapter(drpadapter);

        sendamount=this;
        scan = (FloatingActionButton) findViewById(R.id.scan);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        homerecyclerview = (RecyclerView) findViewById(R.id.homerecyclerview);
        homerecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        HHRVdata.add(new HomeHorizontalRecyclerViewData(R.drawable.debit_card_foreground,"Debit Card"));
        HHRVdata.add(new HomeHorizontalRecyclerViewData(R.drawable.save_foreground,"Save"));
        HHRVdata.add(new HomeHorizontalRecyclerViewData(R.drawable.loan_tracker_foreground,"Loan Tracker"));
        HHRVdata.add(new HomeHorizontalRecyclerViewData(R.drawable.portfolio_foreground,"Portfolio"));
        HHRVdata.add(new HomeHorizontalRecyclerViewData(R.drawable.refer_and_earn_foreground,"Refer and Earn"));
        HorizontalAdapterHome obj = new HorizontalAdapterHome(this,HHRVdata);
        homerecyclerview.setAdapter(obj);

        bannerrecyclerviewhome = (RecyclerView) findViewById(R.id.bannerrecyclerviewhome);
        ArrayList<Bannerdata> bannerdata = new ArrayList<Bannerdata>();
        bannerrecyclerviewhome.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        bannerdata.add(new Bannerdata(R.drawable.refer_and_earn_foreground));
        bannerdata.add(new Bannerdata(R.drawable.debit_card_foreground));
        BannerAdapterHome bannerobj = new BannerAdapterHome(this,bannerdata);
        bannerrecyclerviewhome.setAdapter(bannerobj);

        homeslider= (ImageView) findViewById(R.id.homeslider);
        homeslider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_to_settings = new Intent(MainActivity.this,Home_Setting.class);
                home_to_settings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home_to_settings);
            }
        });
        depositmoney = (Button) findViewById(R.id.depositmoney);
        depositmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_amount_page = new Intent(MainActivity.this,DepositFromHome.class);
                to_amount_page.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(to_amount_page);
            }
        });
        hidenshow = (ImageButton) findViewById(R.id.hidenshow);
        hidenshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hidecount%2 == 1)
                {
                    balanceid.setVisibility(View.INVISIBLE);
                    hidecount++;
                }
                else
                {
                    balanceid.setVisibility((View.VISIBLE));
                    hidecount++;
                }
            }
        });


        droprecyclerhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drp.getVisibility()==View.VISIBLE)
                {
                    drp.setVisibility(View.GONE);
                    droprecyclerhome.setImageResource(R.mipmap.drop);
                }
                else if(drp.getVisibility()==View.GONE)
                {
                    drp.setVisibility(View.VISIBLE);
                    droprecyclerhome.setImageResource(R.mipmap.dropup);
                }
            }
        });

        scan = (FloatingActionButton) findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener()
        {
         @Override
        public void onClick(View view) {
                   Intent inten = new Intent(MainActivity.this,transfer_money.class);
                   startActivity(inten);
        }
        });
        scan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Bahot Dabaya", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    }
