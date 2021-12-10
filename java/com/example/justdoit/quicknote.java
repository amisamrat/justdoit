package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class quicknote extends AppCompatActivity {
    EditText qe;
    ImageButton qb;
    TextView qt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quicknote);
        qe=findViewById(R.id.qet);
        qb=findViewById(R.id.qb);
        qt=findViewById(R.id.qt);
        qb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qt.setText(""+qe.getText().toString());
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle status){
        super.onSaveInstanceState(status);
        status.putString("note",qe.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        String qnote= savedInstanceState.getString("note");
        qt.setText(qnote);

    }
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
            case R.id.th:
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}
}