package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class datadisplay extends AppCompatActivity {
    ImageView iv;
    public TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadisplay);
        iv=findViewById(R.id.imageView);
        tv=findViewById(R.id.textView);
        bt=findViewById(R.id.button);
        //getting data from home
        Integer imageid=getIntent().getIntExtra("imgid",0);
        String description=getIntent().getStringExtra("desc");
        //setting data
        iv.setImageResource(imageid);
        tv.setText(description);
        //clickevent
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //do
            }
        });

    }
}