package com.example.live_earth_map;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.live_earth_map.databinding.ActivitySateliteMapBinding;

import java.io.IOException;
import java.util.List;

public class SateliteMapActivity extends AppCompatActivity implements OnMapReadyCallback
{

   // private AppBarConfiguration appBarConfiguration;
   // private ActivitySateliteMapBinding binding;
    private  GoogleMap googleMap;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satelite_map);

        //binding = ActivitySateliteMapBinding.inflate(getLayoutInflater());
     ////   setContentView(binding.getRoot());

        searchView=(SearchView)findViewById(R.id.Search_View);
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                String location=searchView.getQuery().toString();
                List<Address> addressList=null;
                if(location!=null)
                {
                    Geocoder geocoder=new Geocoder(SateliteMapActivity.this);
                    try
                    {
                      addressList=geocoder.getFromLocationName(location,1);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    Address address=addressList.get(0);
                    LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                }



                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap mgoogleMap)
    {
        googleMap=mgoogleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    }
}
