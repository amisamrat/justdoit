package com.example.justdoit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class map1example extends AppCompatActivity {
    Button show,map;
    TextView lo,la;
    FusedLocationProviderClient myclient;
    double lat,lon;
    Location lastlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1example);
    lo=findViewById(R.id.longitute);
    la=findViewById(R.id.lat);
    show=findViewById(R.id.button2);
    map=findViewById(R.id.button3);
    myclient= LocationServices.getFusedLocationProviderClient(this);


    }
    public void mapf(View view){startActivity(new Intent(this,map2example.class));}
    public void dothis(View v){
        checkLOcationPermission();
    }
    private void checkLOcationPermission(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }else{
            Toast.makeText(this,"granted",Toast.LENGTH_LONG).show();

            myclient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>(){
                @Override
                public void onSuccess(Location location){
                    if(location!=null){
                        lastlocation=location;
                        double lat=lastlocation.getLatitude();
                        double lon=lastlocation.getLongitude();
                        la.setText((int) lat);
                        lo.setText((int) lon);
                        Geocoder geocoder=new Geocoder(map1example.this, Locale.getDefault());
                        try {
                            List<Address> locationList=geocoder.getFromLocation(lat,lon,1);
                            if (locationList.size()>0) {
                            Address address=locationList.get(0);

                            }
                            }catch(IOException e){
                            e.printStackTrace();
                        }
                        }

                    }

            });
        }
    }

    public void onRequestPermissionResult(int requestcode, @NonNull String[] permissions,@NonNull int[] grantResults){
    super.onRequestPermissionsResult(requestcode,permissions,grantResults);
    if(requestcode==1){
        if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            checkLOcationPermission();
        }else{
            Toast.makeText(this,"denied",Toast.LENGTH_LONG).show();
        }
    }
    }
}