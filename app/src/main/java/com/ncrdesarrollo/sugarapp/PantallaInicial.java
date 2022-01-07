package com.ncrdesarrollo.sugarapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PantallaInicial extends AppCompatActivity {
    ProgressBar progressBar;
    ImageView inicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);

        TextView tex1 = (TextView) findViewById(R.id.textitulo);
        Animation anin2 = AnimationUtils.loadAnimation(this,  R.anim.translate);
        tex1.setAnimation(anin2);

        TextView tex2 = (TextView) findViewById(R.id.textView9);
        Animation anin3 = AnimationUtils.loadAnimation(this,  R.anim.zoom);
        tex2.setAnimation(anin3);


        ImageView img = (ImageView)findViewById(R.id.imglogo);
        Animation anin = AnimationUtils.loadAnimation(this,  R.anim.animacion);
        img.setAnimation(anin);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        ObjectAnimator animl = ObjectAnimator.ofInt(progressBar, "progress", 0,100);
        animl.setDuration(4000);
        animl.setInterpolator(new DecelerateInterpolator());

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(PantallaInicial.this,Idioma.class));

                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
                finish();

            }
        },4000);



        inicial = (ImageView) findViewById(R.id.imglogo);
        inicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar = new Intent(PantallaInicial.this,Idioma.class);
                startActivity(pasar);
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
            }
        });

    }
}
