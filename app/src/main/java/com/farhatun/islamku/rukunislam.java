package com.farhatun.islamku;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class rukunislam extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rukun_islam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

