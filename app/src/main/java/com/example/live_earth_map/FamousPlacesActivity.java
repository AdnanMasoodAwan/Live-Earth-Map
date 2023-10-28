package com.example.live_earth_map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FamousPlacesActivity extends AppCompatActivity
{

    CardView Acropolis,kaba,Burj,Ben,Eiffel,LondonEye,B_Ber,Taj,Statue,T_B,louv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_places);

        Acropolis=(CardView)findViewById(R.id.Acropolis_Card);
        kaba=(CardView)findViewById(R.id.Kaba);
        Burj=(CardView)findViewById(R.id.Bur);
        Ben=(CardView)findViewById(R.id.Bi);
        Eiffel=(CardView)findViewById(R.id.Eiffel);
        LondonEye=(CardView)findViewById(R.id.London_eye);
        B_Ber=(CardView)findViewById(R.id.B_Berg);
        Taj=(CardView)findViewById(R.id.Taj);
        Statue=(CardView)findViewById(R.id.Statue_of_librty);
        T_B=(CardView)findViewById(R.id.T_Bridge);
        louv=(CardView)findViewById(R.id.Louvre);

        louv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Louvre_Activity.class);
                startActivity(intent);
            }
        });




        T_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),T_B_Activity.class);
                startActivity(intent);
            }
        });




        Statue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent=new Intent(getApplicationContext(),Statue_Activity.class);
                  startActivity(intent);
            }
        });


        Taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Taj_Activity.class);
                startActivity(intent);
            }
        });



        B_Ber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),B_Ber_Activity.class);
                startActivity(intent);
            }
        });


        LondonEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),London_Eye_Activity.class);
                startActivity(intent);
            }
        });

        Eiffel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Eiffel_Tower_Activity.class);
                startActivity(intent);
            }
        });

        Ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),BigBenActivity.class);
                startActivity(intent);
            }
        });



        Burj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Burjkaifa.class);
                startActivity(intent);
            }
        });

            kaba.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),KabaViewActivity.class);
                startActivity(intent);


            }
        });



        Acropolis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),AcropolisViewActivity.class);
                startActivity(intent);


            }
        });



    }



}