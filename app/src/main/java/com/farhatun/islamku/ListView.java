package com.farhatun.islamku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

    public class ListView extends AppCompatActivity {

        android.widget.ListView listView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            listView= (android.widget.ListView) findViewById(R.id.listview1);
            final String [] values = new String[]{"Rukun Islam", "Rukun Iman", "Nama Malaikat", "Nama Nabi"};

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, values);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position==0){
                        Intent myintent = new Intent(view.getContext(), rukunislam.class);
                        startActivityForResult(myintent,0);
                    }
                    if (position==1){
                        Intent myintent = new Intent(view.getContext(), rukuniman.class);
                        startActivityForResult(myintent,1);
                    }
                    if (position==2){
                        Intent myintent = new Intent(view.getContext(), malaikat.class);
                        startActivityForResult(myintent,2);
                    }
                    if (position==3){
                        Intent myintent = new Intent(view.getContext(), nabi.class);
                        startActivityForResult(myintent,3);
                    }
                }

            });

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        @Override
        public boolean onSupportNavigateUp() {
            finish();
            return true;
        }
    }