package com.ncrdesarrollo.sugarapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Galeria extends AppCompatActivity {

    ImageView imgPrincipal;
    int movil;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);



        Toolbar tb = (Toolbar)findViewById(R.id.tolbargaleria);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.titulogale);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                llamarIntent();



            }
        });





        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter2(this));

        imgPrincipal = (ImageView)findViewById(R.id.imgprincipal);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        imgPrincipal.setImageResource(R.drawable.siembraportada);
                        movil = R.drawable.siembraportada;

                        Toast toast= Toast.makeText(getApplicationContext(), getString(R.string.imgsiembra), Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast.show();
                        break;

                    case 1:
                        imgPrincipal.setImageResource(R.drawable.cultivo1);
                        movil = R.drawable.cultivo1;
                        Toast toast1= Toast.makeText(getApplicationContext(), getString(R.string.imgculticana), Toast.LENGTH_LONG);
                        toast1.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast1.show();
                        break;

                    case 2:
                        imgPrincipal.setImageResource(R.drawable.abonada);
                        movil = R.drawable.abonada;
                        Toast toast2= Toast.makeText(getApplicationContext(), getString(R.string.imgmancul), Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast2.show();
                        break;

                    case 3:
                        imgPrincipal.setImageResource(R.drawable.cultivo2);
                        movil = R.drawable.cultivo2;
                        Toast toast3= Toast.makeText(getApplicationContext(), getString(R.string.imgculticana), Toast.LENGTH_LONG);
                        toast3.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast3.show();
                        break;

                    case 4:
                        imgPrincipal.setImageResource(R.drawable.recoleccionc);
                        movil = R.drawable.recoleccionc;
                        Toast toast4= Toast.makeText(getApplicationContext(),getString(R.string.imgrecocana), Toast.LENGTH_LONG);
                        toast4.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast4.show();
                        break;

                    case 5:
                        imgPrincipal.setImageResource(R.drawable.cortecana);
                        movil = R.drawable.cortarcana;
                        Toast toast5= Toast.makeText(getApplicationContext(), getString(R.string.imgrecocana), Toast.LENGTH_LONG);
                        toast5.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast5.show();
                        break;

                    case 6:
                        imgPrincipal.setImageResource(R.drawable.moler);
                        movil = R.drawable.moler;
                        Toast toast6= Toast.makeText(getApplicationContext(), getString(R.string.imgmolicana), Toast.LENGTH_LONG);
                        toast6.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast6.show();
                        break;

                    case 7:
                        imgPrincipal.setImageResource(R.drawable.bagazo);
                        movil = R.drawable.bagazo;
                        Toast toast7= Toast.makeText(getApplicationContext(), getString(R.string.bagazo), Toast.LENGTH_LONG);
                        toast7.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast7.show();
                        break;

                    case 8:
                        imgPrincipal.setImageResource(R.drawable.guarapoviewpager);
                        movil = R.drawable.guarapoviewpager;
                        Toast toast8= Toast.makeText(getApplicationContext(), getString(R.string.guarapo), Toast.LENGTH_LONG);
                        toast8.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast8.show();
                        break;

                    case 9:
                        imgPrincipal.setImageResource(R.drawable.mielviewpager);
                        movil = R.drawable.mielviewpager;
                        Toast toast9= Toast.makeText(getApplicationContext(), getString(R.string.imgmielca), Toast.LENGTH_LONG);
                        toast9.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast9.show();
                        break;

                    case 10:
                        imgPrincipal.setImageResource(R.drawable.blanqueadoviewpager);
                        movil = R.drawable.blanqueadoviewpager;
                        Toast toast10= Toast.makeText(getApplicationContext(), getString(R.string.blanqueado), Toast.LENGTH_LONG);
                        toast10.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast10.show();
                        break;

                    case 11:
                        imgPrincipal.setImageResource(R.drawable.caramelo1viewpager);
                        movil = R.drawable.caramelo1viewpager;
                        Toast toast11= Toast.makeText(getApplicationContext(),getString(R.string.caramelo), Toast.LENGTH_LONG);
                        toast11.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast11.show();
                        break;

                    case 12:
                        imgPrincipal.setImageResource(R.drawable.panela1viewpager);
                        movil = R.drawable.panela1viewpager;
                        Toast toast12= Toast.makeText(getApplicationContext(), getString(R.string.panela), Toast.LENGTH_LONG);
                        toast12.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast12.show();
                        break;

                    case 13:
                        imgPrincipal.setImageResource(R.drawable.cachazaviepager);
                        movil = R.drawable.cachazaviepager;
                        Toast toast13= Toast.makeText(getApplicationContext(), getString(R.string.cachaza), Toast.LENGTH_LONG);
                        toast13.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast13.show();
                        break;

                    case 14:
                        imgPrincipal.setImageResource(R.drawable.cachazagallinas);
                        movil = R.drawable.cachazagallinas;
                        Toast toast14= Toast.makeText(getApplicationContext(), getString(R.string.imgcachaca), Toast.LENGTH_LONG);
                        toast14.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast14.show();
                        break;

                    case 15:
                        imgPrincipal.setImageResource(R.drawable.abonobagazo);
                        movil = R.drawable.abonobagazo;
                        Toast toast15= Toast.makeText(getApplicationContext(), getString(R.string.imgbagaca), Toast.LENGTH_LONG);
                        toast15.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
                        toast15.show();
                        break;
                }
            }
        });
    }



    private void llamarIntent() {


        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgPrincipal.setImageBitmap(imageBitmap);
        }
    }


}
