package com.ncrdesarrollo.sugarapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class Idioma extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbaridioma);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloidioma);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//flecha atras


        titulo = (TextView) findViewById(R.id.tituloelegir);
        String font_path = "font/Elephant.TTF";
        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);
        titulo.setTypeface(TF);


    }

    public void idomaespa(View view) {
        Locale idiom_es = new Locale("es", "ES");
        Locale.setDefault(idiom_es);
        Configuration config_es = new Configuration();
        config_es.locale = idiom_es;
        getBaseContext().getResources().updateConfiguration(config_es, getBaseContext().getResources().getDisplayMetrics());
        Intent ini = new Intent(Idioma.this,Inicio.class);
        startActivity(ini);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar

    }

    public void idiomaingles(View view) {
        Locale idiom_en = new Locale("en", "EN");
        Locale.setDefault(idiom_en);
        Configuration config_en = new Configuration();
        config_en.locale = idiom_en;
        getBaseContext().getResources().updateConfiguration(config_en, getBaseContext().getResources().getDisplayMetrics());
        Intent ini = new Intent(Idioma.this,Inicio.class);
        startActivity(ini);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar

    }
}
