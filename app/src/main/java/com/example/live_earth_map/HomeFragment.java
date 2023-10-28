package com.example.live_earth_map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class HomeFragment extends Fragment
{
  CardView Satelite,MyLocation,RoutFinder,NearByPlaces,AddressFinder,StreetView;


    public HomeFragment()
    {
        // Required empty public constructor
    }


   // @Override
  //  public void onCreate(Bundle savedInstanceState)
   // {
     //   super.onCreate(savedInstanceState);



   // }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Satelite= (CardView) getView() .findViewById(R.id.clothingCard);
        MyLocation= (CardView) getView() .findViewById(R.id.MyLocation);
        RoutFinder= (CardView) getView() .findViewById(R.id.Route_Finder);
        NearByPlaces= (CardView) getView() .findViewById(R.id.NearbyPlaces);
        AddressFinder= (CardView) getView() .findViewById(R.id.Address_Finder);
        StreetView= (CardView) getView() .findViewById(R.id.StreetView);

        StreetView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(), FamousPlacesActivity.class);
                startActivity(intent);
            }
        });

        Satelite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(),SateliteMapActivity.class);
                startActivity(intent);
            }
        });


        MyLocation .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(),MyLocationActivity.class);
                startActivity(intent);
            }
        });

        RoutFinder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri=Uri.parse("https://www.google.com/maps/dir/");
               Intent intent=new Intent(Intent.ACTION_VIEW,uri  );
               intent.setPackage("com.google.android.apps.maps");
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
            }

        });


        NearByPlaces.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri=Uri.parse("https://www.google.com/maps/dir/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri  );
                intent.setPackage("com.google.android.apps.maps");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });


        AddressFinder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri=Uri.parse("https://www.google.com/maps/dir/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri  );
                intent.setPackage("com.google.android.apps.maps");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}