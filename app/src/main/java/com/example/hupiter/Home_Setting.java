package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView SettingsBackButton;
        final TextView upiid,Accountnumber,IFSCcode;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_setting);
        SettingsBackButton = (TextView) findViewById(R.id.SettingsBackButton);
        upiid = (TextView) findViewById(R.id.upiid);
        Accountnumber = (TextView) findViewById(R.id.Accountnumber);
        IFSCcode = (TextView) findViewById(R.id.IFSCcode);
        SettingsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_home = new Intent(Home_Setting.this,MainActivity.class);
                back_to_home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_to_home);
            }
        });
        upiid.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence label = null;
                ClipData clip = ClipData.newPlainText(label, upiid.getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Home_Setting.this, "UPI ID Copied", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        Accountnumber.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence label = null;
                ClipData clip = ClipData.newPlainText(label, "1234 5678 9123 4567");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Home_Setting.this, "Account Number Copied", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        IFSCcode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence label = null;
                ClipData clip = ClipData.newPlainText(label, IFSCcode.getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Home_Setting.this, "IFSC Code Copied", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}