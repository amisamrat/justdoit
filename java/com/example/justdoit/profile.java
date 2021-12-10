package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    ListView prlist;
    profiledatabase profiledatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prlist=findViewById(R.id.prlist);
        profiledatabase = new profiledatabase(this);
        ArrayList al = profiledatabase.getAllprofile();
       // ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, al);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, al);
        //ArrayList array_list1 = profiledatabase.getsinglelastline();
        //ArrayAdapter arrayAdapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list1);
        prlist = (ListView)findViewById(R.id.prlist);
        prlist.setAdapter(arrayAdapter);
        //prlist.setAdapter(arrayAdapter1);

    }
}