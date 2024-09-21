package com.example.projectact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {


    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    Button btnsave;

    RadioButton male , female;

    CheckBox ch1 , ch2 , ch3 , ch4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent i = new Intent(MainActivity3.this, MainActivity5.class);







        et1 = findViewById(R.id.idname);
        et2 = findViewById(R.id.idemail);
        et3 = findViewById(R.id.idpass1);
        et4 = findViewById(R.id.idpass2);

        btnsave = findViewById(R.id.saveid);


        male = findViewById(R.id.idmale);
        female = findViewById(R.id.idfemale);

        ch1 = findViewById(R.id.idch1);
        ch2 = findViewById(R.id.idch2);
        ch3 = findViewById(R.id.idch3);
        ch4 = findViewById(R.id.idch4);




        EditText date = findViewById(R.id.iddate);

        date.setInputType(InputType.TYPE_NULL);

        Calendar c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        date.setOnClickListener(v -> {
            DatePickerDialog dd = new DatePickerDialog(MainActivity3.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    date.setText(i+"/"+(i1+1)+"/"+i2);
                }
            },year,month,day);
            dd.setTitle("Show Date");
            dd.show();
        });




        btnsave.setOnClickListener(view -> {



                    String gender = female.getText().toString();
                    if (male.isChecked())
                        gender = male.getText().toString();


                    String box = "";
                    if (ch1.isChecked()){
                        box += "\n"+ ch1.getText().toString();
                    }
                    if (ch2.isChecked()) {
                        box += "\n"+ ch2.getText().toString();
                    }
                    if (ch3.isChecked()){
                        box += "\n"+ ch3.getText().toString();
                    }
                    if (ch4.isChecked()){
                        box += "\n"+ ch4.getText().toString();
                    }



            if (!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty() && et3.getText().toString().equals(et4.getText().toString()) && !et3.getText().toString().isEmpty() && !et4.getText().toString().isEmpty()){

                        i.putExtra("the name",et1.getText().toString());
                        i.putExtra("the box",box);


                startActivity(i);

            }else{
                if (et1.getText().toString().isEmpty()){
                    Toast.makeText(this, "The username is not written", Toast.LENGTH_SHORT).show();
                }
                if (et2.getText().toString().isEmpty() ){
                    Toast.makeText(this, "The email is not written", Toast.LENGTH_SHORT).show();
                }
                if (!et2.getText().toString().contains("@")){
                    Toast.makeText(this, "The email is not contains @", Toast.LENGTH_SHORT).show();
                }
                if (et3.getText().toString().isEmpty() && et4.getText().toString().isEmpty()){
                    Toast.makeText(this, "The password is not written", Toast.LENGTH_SHORT).show();
                }
                if (!(et3.getText().toString().equals(et4.getText().toString()))){
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
    }
}

