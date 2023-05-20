package com.example.hupiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class Camtu extends AppCompatActivity{

    PreviewView cameraview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camtu);
        cameraview = (PreviewView) findViewById(R.id.cameraview);

    }
}