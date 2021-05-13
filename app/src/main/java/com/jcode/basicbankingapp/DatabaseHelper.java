package com.jcode.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "BasicDatabase.db",null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table customer(name text, ac_nu int, emali text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists customer");

    }
    public  boolean addcustomer(String s1, String s2 , String s3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues . put("name",s1);
        contentValues . put("ac_nu",s2);
        contentValues . put("emali",s3);
        long result =db.insert("customer",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return  true;
        }
    }
    public Cursor alldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from customer",null);
        return  cursor;
    }
}
