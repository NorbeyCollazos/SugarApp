package com.ncrdesarrollo.sugarapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Inicio extends AppCompatActivity implements View.OnClickListener{

    Button cultivo, productos, contacto;
    TextView bienvenido, descripcion;


    Animation fade_in ,fade_out;
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbarinicio);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloinicio);
        //icono
        getSupportActionBar().setIcon(R.drawable.ic_inicio);



        viewFlipper = (ViewFlipper)this.findViewById(R.id.contenimg);

        fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();




        cultivo = (Button)findViewById(R.id.btncultivo);
        cultivo.setOnClickListener(this);

        productos = (Button)findViewById(R.id.btnproductos);
        productos.setOnClickListener(this);

        contacto = (Button)findViewById(R.id.btncontacto);
        contacto.setOnClickListener(this);


        bienvenido = (TextView) findViewById(R.id.tvbienvenido);
        String font_path = "font/JOKERMAN.TTF";
        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);
        bienvenido.setTypeface(TF);

        Animation anin = AnimationUtils.loadAnimation(this,  R.anim.zoom);
        bienvenido.setAnimation(anin);


        descripcion = (TextView) findViewById(R.id.descri);
        String font_meri = "font/Merienda One.ttf";
        Typeface TM = Typeface.createFromAsset(getAssets(),font_meri);
        descripcion.setTypeface(TM);


        ImageView img = (ImageView)findViewById(R.id.imglogin);
        Animation anin2 = AnimationUtils.loadAnimation(this,  R.anim.rotate);
        img.setAnimation(anin2);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncultivo:

                Intent cult = new Intent(Inicio.this,Cultivo.class);
                startActivity(cult);

                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
                break;

            case R.id.btnproductos:
                Intent pro = new Intent(Inicio.this,EntradaProductos.class);
                startActivity(pro);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

           case R.id.btncontacto:
                Intent con = new Intent(Inicio.this,EntradaServicios.class);
                startActivity(con);
               overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
        }
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder prueba = new AlertDialog.Builder(this);
        prueba.setMessage(getString(R.string.salirapli));
        prueba.setTitle("Sugar App");
        prueba.setIcon(R.mipmap.ic_launcher);


        prueba.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();

            }
        });

        prueba.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        AlertDialog dialog = prueba.create();
        dialog.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                Intent infor = new Intent(Inicio.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(Inicio.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(Inicio.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.idioma:
                Intent idio = new Intent(Inicio.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(Inicio.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.sali:
                AlertDialog.Builder prueba = new AlertDialog.Builder(this);
                prueba.setMessage(getString(R.string.salirapli));
                prueba.setTitle("Sugar App");
                prueba.setIcon(R.mipmap.ic_launcher);



                prueba.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });

                prueba.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                AlertDialog dialog = prueba.create();
                dialog.show();
                break;

        }


        return super.onOptionsItemSelected(item);
    }



}
