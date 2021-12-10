package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mail extends AppCompatActivity {
    EditText asket;
    Button askbt;
    public String body,sub,to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        askbt=findViewById(R.id.askbt);
        asket=findViewById(R.id.asket);
        body=asket.getText().toString();
        sub="question";
        to="samratariful@gmail.com";

        askbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,asket.getText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
    }
}