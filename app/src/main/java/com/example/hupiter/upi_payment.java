package com.example.hupiter;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;


public class upi_payment extends Fragment{

    EditText upiid;
    Button continuepayment;
    ImageButton addid;
    int ret=0;
    String name;
    String init;

    public upi_payment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_upi_payment, container, false);
        EditText upiid = view.findViewById(R.id.upiid);
        Button continuepayment = view.findViewById(R.id.continuepayment);
        addid = view.findViewById(R.id.addid);
        GridView payee_gridlayout =(GridView) view.findViewById(R.id.payeegrid);
        GridAdapter obj = new GridAdapter(getContext());
        payee_gridlayout.setAdapter(obj);
        upiid.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        addid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upiid.setText(upiid.getText().toString() +"@hupiteraxis");
            }
        });

        continuepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(upiid.getText().toString()))
                {
                    Toast.makeText(getActivity(), "Enter UPI ID", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(checkId(upiid.getText().toString())!=1)
                    {
                        Intent inten = new Intent(getActivity(),send_money_from_upi.class);
                        inten.putExtra("FULL NAME",name);
                        inten.putExtra("UPI ID",upiid.getText().toString());
                        inten.putExtra("INITIALS",init);
                        startActivity(inten);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Incorrect UPI Id", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return view;
    }
    public int checkId(String s)
    {
        ret=0;
        if(s.length()>10) {
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='@')
                {
                    for(int j=0;j<i;j++)
                    {
                        if(Character.isDigit(s.charAt(j)))
                        {
                            ret=1;
                        }
                    }
                    if(!s.substring(i,s.length()).toLowerCase().equals("@hupiteraxis"))
                    {
                        ret = 1;
                    }
                    if(s.substring(0,i).contains("_"))
                    {
                        if(s.charAt(i-1)=='_')
                            ret=1;
                    }
                    else
                    {
                        ret=1;
                    }
                }
                if(ret==1)
                    break;
            }
        }
        else
        {
            ret=1;
        }
        if(ret==0)
        {
            namereader(s);
        }
        return ret;
    }

    public String namereader(String s)
    {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='@')
                {
                    name=s.substring(0,i);
                    for(int j=0;j<i;j++)
                    {
                            if(name.contains("_"))
                            {
                                name=name.replace("_"," ");
                            }
                    }
                }
            }
            char newname[] = name.toCharArray();
            newname[0] = Character.toUpperCase(newname[0]);
            init=String.valueOf(newname[0]);
            for(int i=0;i<name.length();i++)
            {
                if(newname[i]==' ') {
                    newname[i + 1] = Character.toUpperCase(newname[i + 1]);
                    if(init.length()<2)
                    init=init.concat(Character.toString(newname[i+1]));
                }
            }
            name= new String(newname);
        return name;
    }

}