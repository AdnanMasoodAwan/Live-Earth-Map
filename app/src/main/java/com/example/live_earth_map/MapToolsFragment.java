package com.example.live_earth_map;

import android.content.ComponentName;
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


public class MapToolsFragment extends Fragment
{
    private CardView Translater,CurrencyConverter,Weat,FaPlaces;


    public MapToolsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_tools, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Translater=(CardView)view.findViewById(R.id.Translator);
        CurrencyConverter=(CardView)view.findViewById(R.id.Currency_Converter);
        Weat=(CardView)view.findViewById(R.id.Weat);
        FaPlaces=(CardView)view.findViewById(R.id.FamousPlaces);

        FaPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), FamousPlacesActivity.class);
                startActivity(intent);
            }
        });

        Weat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri=Uri.parse("https://weather.com/en-PK/weather/today/l/PKXX0006:1:PK?Goto=Redirected");
               // Uri uri=Uri.parse("https://www.google.com/weather/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri  );
                //intent.setPackage("com.google.android.apps.weather");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        CurrencyConverter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(),CurrencyConverterActivity.class);
                startActivity(intent);

            }
        });


        Translater.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(),TranslaterActivity.class);
                startActivity(intent);

            }
        });

    }
}