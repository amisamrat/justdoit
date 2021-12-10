package com.example.justdoit;

import static androidx.appcompat.app.AppCompatDelegate.getDefaultNightMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class highlight extends AppCompatActivity {
    private ArrayList<gsconstructor> con2;
    private RecyclerView rv2;
    public FloatingActionButton fb;
    profiledatabase profiledatabase2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlight);
         profiledatabase2 = new profiledatabase(this);
         ArrayList<String> al= profiledatabase2.getAllprofile();
        //al.notify();
        // String s=al.get(0).toString();
        //  int l=al.size();
        fb=findViewById(R.id.fb);
        rv2 = findViewById(R.id.rv2);
        con2 = new ArrayList<>();

        con2.add(new gsconstructor("highlight1", R.drawable.logo3));
        con2.add(new gsconstructor("Highlight2📻 ",  R.drawable.logo3));

         con2.add(new gsconstructor(" "+al.get(0).toString(),R.drawable.logo3));
        //   for (int i=0;i<l;i++){
        //       con.add(new gsconstructor(" " + al.get(i).toString(), R.drawable.logo3));
        //   }


        final myadapter2 ad2 = new myadapter2(this, con2);
        ad2.notifyDataSetChanged();
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //setting layoutmanager and adapter to recycler view
        rv2.setLayoutManager(llm);
        rv2.setAdapter(ad2);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.help, menu);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.th).setTitle("Sun Time");
        }
        else{
            menu.findItem(R.id.th).setTitle("Moon Time");
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.app_bar_search:
                Intent in=new Intent(getApplicationContext(),feedback.class);
                String linkfeedback1="https://www.bing.com";
                in.putExtra("link", linkfeedback1);
                startActivity(in);

                return true;
            case R.id.hpage:
                Intent it=new Intent(getApplicationContext(),help.class);
                startActivity(it);

                return true;
            case R.id.ask:
                Intent i=new Intent(getApplicationContext(),mail.class);
                startActivity(i);
                return true;
            case R.id.feedback:
                Intent intent=new Intent(getApplicationContext(),feedback.class);
                String linkfeedback="https://forms.gle/8MN1FCYXp1oejvdT7";
                intent.putExtra("link", linkfeedback);
                startActivity(intent);
                return true;
            case R.id.qn:
                Intent qn=new Intent(getApplicationContext(),quicknote.class);
                startActivity(qn);
                return true;
            case R.id.profile:
                Intent pro=new Intent(getApplicationContext(),profile.class);
                startActivity(pro);
                return true;
            case R.id.ep:
                Intent pr=new Intent(getApplicationContext(),editprofile.class);
                startActivity(pr);
                return true;
            case R.id.th:
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    recreate();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}