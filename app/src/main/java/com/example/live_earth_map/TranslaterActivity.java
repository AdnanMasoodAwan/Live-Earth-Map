package com.example.live_earth_map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.FirebaseExceptionMapper;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.ArrayList;
import java.util.Locale;

/** @noinspection deprecation*/
public class TranslaterActivity extends AppCompatActivity
{
    private Spinner spinner1,spinner2;
    private TextInputEditText  inputEditText;

    private ImageView micro;

    private MaterialButton TranslateText;
    private TextView TranslatedText;
    String[] fromLanguage={"from","English","Afrikaans","Arabic","Belarusian","Bulgarian","Bengali","Catalan","Czech"
    ,"Hindi","Urdu"};
    String[] ToLanguage={"To","English","Afrikaans","Arabic","Belarusian","Bulgarian","Bengali","Catalan","Czech"
            ,"Hindi","Urdu"};
    private  static  final  int REQUEST_PERMISSION_CODE=1;
    int languageCode,fromLanguageCode,toLanguageCode=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translater);

        spinner1=(Spinner)findViewById(R.id.Spinner1);
        spinner2=(Spinner)findViewById(R.id.Spinner2);
        inputEditText=(TextInputEditText)findViewById(R.id.EditSource);
        TranslateText=(MaterialButton)findViewById(R.id.Traslatebutton);
        TranslatedText=(TextView) findViewById(R.id.TraslatedText);
        micro=(ImageView)findViewById(R.id.microPhone);

        micro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
               intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something to translate");

                try
                {
                     startActivityForResult(intent,REQUEST_PERMISSION_CODE);
                }
                catch (Exception e)
                {

                }

            }
        });



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                 fromLanguageCode=GetLanguageCode(fromLanguage[i]);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        ArrayAdapter fromadapter=new ArrayAdapter(this,R.layout.spinner_item,fromLanguage);
        fromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(fromadapter);



        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                toLanguageCode=GetLanguageCode(ToLanguage[i]);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        ArrayAdapter toadapter=new ArrayAdapter(this,R.layout.spinner_item,ToLanguage);
        toadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(toadapter);


      TranslateText.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View view)
          {

           if(inputEditText.getText().toString().isEmpty())
           {
               Toast.makeText(TranslaterActivity.this,"Please enter text",Toast.LENGTH_SHORT).show();
           }
           else if(fromLanguageCode==0)
           {
               Toast.makeText(TranslaterActivity.this,"Please select source language",Toast.LENGTH_SHORT).show();
           }
           else if(toLanguageCode==0)
           {
               Toast.makeText(TranslaterActivity.this,"Please select language to Translate",Toast.LENGTH_SHORT).show();
           }
           else
           {

               TranslateText(fromLanguageCode,toLanguageCode,inputEditText.getText().toString());
           }



          }

      });



    }

    private void TranslateText(int fromLanguageCode, int toLanguageCode, String toString)
    {
        TranslatedText.setText("Downloading Model Please Wait......");
        TranslatorOptions options=new  TranslatorOptions.Builder()
                .setSourceLanguage(String.valueOf(fromLanguageCode))
                .setTargetLanguage(String.valueOf(toLanguageCode))
                .build();
        Toast.makeText(TranslaterActivity.this,"Downloading",Toast.LENGTH_SHORT).show();
      //  Translator firebaseTranslator= FirebaseNaturalLanguage.getInstance().getTranslator(options);
        Translator translator= Translation.getClient(options);
        DownloadConditions conditions=new  DownloadConditions.Builder().requireWifi().build();
        translator
                .downloadModelIfNeeded(conditions)
                .addOnSuccessListener(new OnSuccessListener<Void>()
                {
            @Override
            public void onSuccess(Void unused)
            {
               translator.translate(toString).addOnSuccessListener(new OnSuccessListener<String>()
               {
                   @Override
                   public void onSuccess(String s)
                   {
                        TranslatedText.setText(s);
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(TranslaterActivity.this,"Failed to Translate",Toast.LENGTH_SHORT).show();
                   }
               });
            }
        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TranslaterActivity.this,"Failed to Download Model",Toast.LENGTH_SHORT).show();
                    }
                });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_PERMISSION_CODE)
        {
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            inputEditText.setText(result.get(0));
        }

    }

    //    String[] fromLanguage={"from","English","Afrikaans","Arabic","Belarusian","Bulgarian","Bengali","Catalan","Czech"
//    ,"Hindi","Urdu"};
    private int GetLanguageCode(String s)
    {
      int languagecode=0;
      switch (s)
      {
          case "English":
              languagecode=FirebaseTranslateLanguage.EN;
              break;
          case "Afrikaans":
              languagecode=FirebaseTranslateLanguage.AF;
              break;
          case "Arabic":
              languagecode=FirebaseTranslateLanguage.AR;
              break;
          case "Belarusian":
              languagecode=FirebaseTranslateLanguage.BN;
              break;
          case "Bulgarian":
              languagecode=FirebaseTranslateLanguage.BG;
              break;
          case "Bengali":
              languagecode=FirebaseTranslateLanguage.BE;
              break;
          case "Catalan":
              languagecode=FirebaseTranslateLanguage.CA;
              break;
          case "Czech":
              languagecode=FirebaseTranslateLanguage.CY;

              break;
          case "":
              languagecode=FirebaseTranslateLanguage.EN;
              break;
          case "Hindi":
              languagecode=FirebaseTranslateLanguage.HI;
              break;
          case "Urdu":
              languagecode=FirebaseTranslateLanguage.UR;
              break;

          default:
              languagecode=0;
              break;

      }
      return languagecode;

    }


}