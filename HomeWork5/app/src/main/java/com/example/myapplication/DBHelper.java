package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static int ver = 1;
    private static String n = "studentSys.db";

    public DBHelper(Context context, String name, CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    public DBHelper(Context context, String name,
                    int version) {
        this(context,name,null,version);
    }

    public DBHelper(Context context, String name) {
        this(context,name,ver);
    }

    public DBHelper(Context context) {
        this(context,n);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        arg0.execSQL("create table Course(cid varchar(30) primary key,cname varchar(30),cprice varchar(30) not null");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        System.out.println("���º�İ汾Ϊ"+arg2);

    }

}
