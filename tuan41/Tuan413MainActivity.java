package com.example.test.tuan41;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.R;

public class Tuan413MainActivity extends AppCompatActivity {
    Button btnGetData;
    TextView tvKQ;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan413_main);
        Tuan41VolleyFn volleyFn=new Tuan41VolleyFn();
        tvKQ=findViewById(R.id.tuan413TvKQ);
        btnGetData=findViewById(R.id.tuan413Btn);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFn.getJsonArrayOfObject(context,tvKQ);
            }
        });
    }
}