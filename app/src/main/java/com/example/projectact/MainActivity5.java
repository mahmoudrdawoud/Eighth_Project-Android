package com.example.projectact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        TextView tx = findViewById(R.id.textvi3);
        TextView box = findViewById(R.id.textview1);



        String dd = getIntent().getExtras().getString("the name").toString();
        String bo = getIntent().getExtras().getString("the box").toString();


        tx.setText(dd);
        box.setText(bo);



    }
}