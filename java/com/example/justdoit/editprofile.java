package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editprofile extends AppCompatActivity {
    EditText proname,prophone,proemail;
    Button add,del,update;
    profiledatabase profiledatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        proname=findViewById(R.id.proname);
        prophone=findViewById(R.id.prophone);
        proemail=findViewById(R.id.propass);
        add=findViewById(R.id.proadd);
        del=findViewById(R.id.prodel);
        update=findViewById(R.id.proup);
        profiledatabase = new profiledatabase(this);

        // add.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   profiledatabase.addprofile(proname.getText().toString(),prophone.getText().toString(),proemail.getText().toString());
            //}
        //});
       // del.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   profiledatabase.deleteprofile(""+prophone.getText().toString());
            //}
        //});
     //   update.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View view) {

           //     profiledatabase.updateprofile(""+proname.getText().toString(),""+prophone.getText().toString(),""+proemail.getText().toString());
            //}
        //});
    }
    public void add(View view){
        profiledatabase = new profiledatabase(this);
        profiledatabase.addprofile("user name: ","","mail : ");


        profiledatabase.addprofile("user name: "+proname.getText().toString(),prophone.getText().toString(),"mail : "+proemail.getText().toString());

    }
    public void update(View view){
        profiledatabase = new profiledatabase(this);
        profiledatabase.updateprofile("user name: "+proname.getText().toString(),prophone.getText().toString(),"mail : "+proemail.getText().toString());

    }
    public void delete(View view){
        profiledatabase = new profiledatabase(this);
        profiledatabase.deleteprofile(prophone.getText().toString());
    }
}