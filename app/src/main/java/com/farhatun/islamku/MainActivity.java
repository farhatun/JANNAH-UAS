package com.farhatun.islamku;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Int4;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnMoveShalat, btnMoveHalal, btnMoveKiblat, btnDoa, btnSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveShalat = (Button) findViewById(R.id.btn_move_shalat_app);
        btnMoveShalat.setOnClickListener(this);
        btnMoveHalal=(Button)findViewById(R.id.btn_move_halal_app);
        btnMoveHalal.setOnClickListener(this);
        btnMoveKiblat=(Button)findViewById(R.id.btn_move_kiblat_app);
        btnMoveKiblat.setOnClickListener(this);
        btnDoa=(Button)findViewById(R.id.doa);
        btnDoa.setOnClickListener(this);
        btnSubscribe=(Button)findViewById(R.id.subscribe);
        btnSubscribe.setOnClickListener(this);

        TextView openYoutube = findViewById(R.id.btn_move_halal_app);
        openYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://youtu.be/FsYY7fWjRL4"));
                try {
                    MainActivity.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_move_shalat_app:
                Intent moveShalat = new Intent(MainActivity.this,ShalatApp.class);
                startActivity(moveShalat);
                break;
            case R.id.btn_move_halal_app:
                Intent moveHalal = new Intent(MainActivity.this,HalalApp.class);
                startActivity(moveHalal);
                break;
            case R.id.btn_move_kiblat_app:
                Intent moveKiblat = new Intent(MainActivity.this,CompassActivity.class);
                startActivity(moveKiblat);
                break;
            case R.id.doa:
                Intent doa = new Intent(MainActivity.this,ListView.class);
                startActivity(doa);
                break;
            case R.id.subscribe:
                Intent subscribe = new Intent(MainActivity.this,subscribe.class);
                startActivity(subscribe);
                break;
        }
    }
}

