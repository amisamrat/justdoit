package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;

public class map2example extends AppCompatActivity {
    //SupportMapFragment supportMapFragment;

    FusedLocationProviderClient wyclient;

    Location LastLocation;

    double dlatitude, dlongitude;

    boolean flag = false ;

    //GoogleMap gasp;

    EditText etsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2example);
       // supportMapFragment = getSupportFragmentManager().findFragmentById(R.id.map);


    }
   // void initMap() {
    //    Toast.makeText(this, "Initialize Map", Toast.LENGTH_SHORT).show();
    //    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
     //       @SuppressLint("MissingPermission")
       //     @Override
         //   public void onMapReady(GoogleMap googleMap) {
           //     gmap = googleMap;
             //   if (flag) {
               //     LatLng mylatlng = new LatLng(dlatitude, dlongitude);
//To show camera on our map on current place which we get from current Latitude
// and longitude
           //         gmap.moveCamera(CameraUpdateFactory.newLatLng(mylatlng));

//in my case to workon this:SetMyLocationEnabled(true): i need to add to write
// following if statement.
        //            if (ActivityCompat.checkSelfPermission(this,
         //                   Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
           //                 && ActivityCompat.checkSelfPermission
             //               (this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
               //     {
// TODO: Consider calling
// ActivityCompat#requestPermissions
// here to request the missing permissions, and then overriding
// public void onRequestPermissionsResult(int requestCode, String[] permissions,
// int[] grantResults)
// to handle the case where the user grants the permission. See the documentation
// for ActivityCompat#requestPermissions for more details.
            //            return;
              //      }
             //       gmap.setMyLocationEnabled(true);;
//To show marker on our map on current place which we get from current Latitude and longitude
            //        MarkerOptions markerOptions = new MarkerOptions();
            //        markerOptions.position(mylatlng);
            //        markerOptions.title("You are here");

            //        gmap.addMarker(markerOptions);
}