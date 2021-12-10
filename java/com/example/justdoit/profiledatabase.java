package com.example.justdoit;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class profiledatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "profileinfo.db";
    public static final String TABLE_NAME = "info";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";

    public profiledatabase(Context context) {
    super(context, DATABASE_NAME , null, 1);
}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME  + "(phone text primary key, name text,email text)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS info");
        onCreate(sqLiteDatabase);

    }
    public long addprofile (String name, String phone, String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("name", name);
        contentValues.put("email", email);
        long a=sqLiteDatabase.insert("info", null, contentValues);
        return a;
    }
    public Cursor getsingleline(String phone) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery( "select * from info where phone="+phone+"", null );
        return cursor;
    }
    public ArrayList<String> getsinglelastline() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cur =  sqLiteDatabase.rawQuery( "select * from info ORDER BY phone DESC LIMIT 1", null );
        cur.moveToFirst();
        StringBuffer s=new StringBuffer();
        String s1=cur.getString(cur.getColumnIndex(COLUMN_NAME));
        String s2=cur.getString(cur.getColumnIndex(COLUMN_PHONE));
        String s3=cur.getString(cur.getColumnIndex(COLUMN_EMAIL));
        s.append(s1+" "+s2+" "+s3);
        ArrayList<String> array_list1 = new ArrayList<String>();
        array_list1.add(s.toString());
        return array_list1;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }
    public boolean updateprofile (String name, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        //contentValues.put("phone", phone);
        contentValues.put("email", email);

   //     db.update("info", contentValues, "phone = ? ", new String[] { Integer.toString(Integer.parseInt(phone)) } );
        db.update("info", contentValues, "phone = ? ", new String[] { phone } );
        db.close();

        return true;
    }
    public Integer deleteprofile (String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("info",
                "phone = ? ",
                new String[] { phone });
    }
    public ArrayList<String> getAllprofile() {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from info", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            //array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME+COLUMN_PHONE+COLUMN_EMAIL)));
            StringBuffer s=new StringBuffer();
            String s1=res.getString(res.getColumnIndex(COLUMN_NAME));
            String s2=res.getString(res.getColumnIndex(COLUMN_PHONE));
            String s3=res.getString(res.getColumnIndex(COLUMN_EMAIL));
            s.append(s1+" "+s2+" "+s3);
            array_list.add(s.toString());
            res.moveToNext();
        }

        db.close();
        return array_list;
    }
}




























