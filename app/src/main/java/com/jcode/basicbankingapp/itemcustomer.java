package com.jcode.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class itemcustomer extends AppCompatActivity {
TextInputEditText tvname,tvacnumber,tvrenumber,tvemail,tvnumber,tvbank,tvifsc;
Button save;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemcustomer);
        Cursor cursor = db.alldata();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        while (cursor.moveToNext()){
            Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();
        }

        db = new DatabaseHelper(this);
        boolean insert = db.addcustomer("jaydeep","123","bhayani");
        Toast.makeText(this, insert+"successfuly", Toast.LENGTH_SHORT).show();
        tvname=findViewById(R.id.tvname);
        tvacnumber=findViewById(R.id.tvacnumber);
        tvrenumber=findViewById(R.id.tvrenumber);
        tvemail=findViewById(R.id.tvemail);
        tvnumber=findViewById(R.id.tvnumber);
        tvbank=findViewById(R.id.tvbank);
        tvifsc=findViewById(R.id.tvifsc);
        save=findViewById(R.id.save);
    }
}