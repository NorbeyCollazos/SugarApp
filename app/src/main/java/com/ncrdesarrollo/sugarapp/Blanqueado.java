package com.ncrdesarrollo.sugarapp;

import android.net.Uri;
import android.os.Bundle;

import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Blanqueado extends AppCompatActivity {
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blanqueado);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbarblanqueado);
    //agrgamos la compatibilidad con otras versiones
    setSupportActionBar(tb);
    //Agregamos el titulo
    getSupportActionBar().setTitle(R.string.tituloproh);

    //Agregamos el subtitulo
    //getSupportActionBar().setSubtitle(R.string.exelente);

    //Agregamos un icono
    //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

    //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras

      /*  video = (VideoView)findViewById(R.id.videoView);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoblan;
        video.setVideoURI(Uri.parse(ruta));
        video.start();*/
    }
}
