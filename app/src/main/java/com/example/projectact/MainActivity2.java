package com.example.projectact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        EditText user = findViewById(R.id.iduser);
        EditText pass = findViewById(R.id.idpass);


        btn2.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, MainActivity4.class);

            if (user.getText().toString().equals("admin") && pass.getText().toString().equals("123")) {
                Toast.makeText(this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                i.putExtra("the name",user.getText().toString());
                startActivity(i);

            } else {
                Toast.makeText(this, "Error UserName Or PassWord", Toast.LENGTH_SHORT).show();
            }
        });



        btn1.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(i);
        });

    }}
