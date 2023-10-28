package com.example.live_earth_map;


import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

import java.io.IOException;
import java.util.List;

/**
 * This shows how to create a simple activity with streetview and a map
 */
public class  Statue_Activity extends AppCompatActivity
        implements GoogleMap.OnMarkerDragListener, StreetViewPanorama.OnStreetViewPanoramaChangeListener,OnMapReadyCallback {

    private static final String MARKER_POSITION_KEY = "MarkerPosition";

    // George St, Sydney37.97274920062355, 23.72819522147862

    private static final LatLng Acro = new LatLng(40.68937742393396, -74.04418033068045);

    private StreetViewPanorama streetViewPanorama;
    private  GoogleMap Map;

    private Marker marker;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_ben);

      /*  final LatLng markerPosition;
        if (savedInstanceState == null) {
            markerPosition = Acro;
        } else {
            markerPosition = savedInstanceState.getParcelable(MARKER_POSITION_KEY);
        }
       */



        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                        streetViewPanorama = panorama;
                        streetViewPanorama.setOnStreetViewPanoramaChangeListener(
                                Statue_Activity.this);
                        // Only need to set the position once as the streetview fragment will maintain
                        // its state.

                        streetViewPanorama.setPosition(Acro);

                    }
                });

        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }





    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(MARKER_POSITION_KEY, marker.getPosition());
    }

    @Override
    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location)
    {

//            marker.setPosition(location.position);

    }

    @Override
    public void onMarkerDragStart(Marker marker) {
    }

    @Override
    public void onMarkerDragEnd(Marker marker)
    {
        streetViewPanorama.setPosition(marker.getPosition(), 150);
    }

    @Override
    public void onMarkerDrag(Marker marker) {
    }

    @Override
    public void onMapReady( GoogleMap googleMap)
    {
        Map=googleMap;
        List<Address> addressList=null;

        Geocoder geocoder=new Geocoder(Statue_Activity.this);
        try
        {
            addressList=geocoder.getFromLocation(40.68937742393396, -74.04418033068045,1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Address address=addressList.get(0);
        // LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(Acro).title("Statue Of Liberty"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Acro,10));
        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        // map.setOnMarkerDragListener(KabaViewActivity.this);
        // Creates a draggable marker. Long press to drag.
        //   marker = googleMap.addMarker(new MarkerOptions()
        // .position(Acro)
        // .icon(BitmapDescriptorFactory.fromResource(R.drawable.f))
        // .title("Kaba"));

    }
}