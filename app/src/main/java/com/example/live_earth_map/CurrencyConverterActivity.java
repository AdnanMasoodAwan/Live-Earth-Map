package com.example.live_earth_map;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrencyConverterActivity extends AppCompatActivity
{
    CountryItem countryItem;
    String ClickedCountryName;

    CountryItem countryItemTo;
    String ClickedCountryNameTo;
    private ArrayList<CountryItem> countryList;
    private  CountryAdapter adapter;

    private EditText Input;
    Spinner spinner1,spinner2;
    private  TextView ConvertedCurrency;
    Button ConvertCurrency;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        InitListCountry();



        spinner1=(Spinner)findViewById(R.id.Spinner1);
        spinner2=(Spinner)findViewById(R.id.Spinner2);
        Input=(EditText)findViewById(R.id.Amount_Edit_Text);
        ConvertedCurrency=(TextView) findViewById(R.id.Converted_Currency);
        ConvertCurrency=(Button)findViewById(R.id.Convert_Currency);

       spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
       {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
           {
               countryItem=(CountryItem) adapterView.getItemAtPosition(i);
               ClickedCountryName=countryItem.getCountyName();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView)
           {

           }
       });

       spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
       {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
           {
               countryItemTo=(CountryItem) adapterView.getItemAtPosition(i);
               ClickedCountryNameTo=countryItemTo.getCountyName();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView)
           {

           }
       });


       ConvertCurrency.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
              Double totalConvertedAmount;
              Double Amount=Double.parseDouble(Input.getText().toString());
              if(ClickedCountryName.equals("Pakistan") && ClickedCountryNameTo.equals("USA"))
              {
                  totalConvertedAmount=Amount*300.2323;
                  String tot=String.format("%.2f",totalConvertedAmount);
                  ConvertedCurrency.setText(tot);
              }
               if(ClickedCountryName.equals("USA") && ClickedCountryNameTo.equals("india"))
               {
                   totalConvertedAmount=Amount*74.19;
                   String tot=String.format("%.2f",totalConvertedAmount);
                   ConvertedCurrency.setText(tot);
               }
               if(ClickedCountryName.equals("USA") && ClickedCountryNameTo.equals("vietanam"))
               {
                   totalConvertedAmount=Amount*22681.00;
                   String tot=String.format("%.2f",totalConvertedAmount);
                   ConvertedCurrency.setText(tot);
               }
               if(ClickedCountryName.equals("india") && ClickedCountryNameTo.equals("Pakistan"))
               {
                   totalConvertedAmount=Amount*2.22;
                   String tot=String.format("%.2f",totalConvertedAmount);
                   ConvertedCurrency.setText(tot);
               }



           }
       });

        adapter=new CountryAdapter(CurrencyConverterActivity.this,countryList);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);


    }

    private void InitListCountry()
    {
        countryList=new ArrayList<>();
        countryList.add(new CountryItem("Pakistan",R.drawable.pakistan));
        countryList.add(new CountryItem("india",R.drawable.india));
        countryList.add(new CountryItem("vietanam",R.drawable.vietnam));
        countryList.add(new CountryItem("USA",R.drawable.unitedstates));



    }



}