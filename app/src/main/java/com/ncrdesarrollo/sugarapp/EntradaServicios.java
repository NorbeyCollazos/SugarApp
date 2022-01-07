package com.ncrdesarrollo.sugarapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class EntradaServicios extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_servicios);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbarmaservicios);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.titulomaservi);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras



        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

        datos.add(new Lista_entrada(R.drawable.icongaleria, getString(R.string.titulogaleria), getString(R.string.teximg)));
        datos.add(new Lista_entrada(R.drawable.iconcalcusiembra, getString(R.string.calcusiem), getString(R.string.descalcusiembra)));
        datos.add(new Lista_entrada(R.drawable.iconcalcupanela, getString(R.string.calcucanpa), getString(R.string.titulocanticaña)));
        datos.add(new Lista_entrada(R.drawable.iconobase, getString(R.string.base), getString(R.string.titulobase)));



        lista = (ListView) findViewById(R.id.listViewentrada);
        lista.setAdapter(new Lista_adaptador(this, R.layout.activity_lista_entradaservicios, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
              /*  Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(EntradaProductos.this, texto, Toast.LENGTH_LONG);
                toast.show();*/
                switch (posicion){
                    case 0:
                        Intent galeri = new Intent(EntradaServicios.this,Galeria.class);
                        startActivity(galeri);
                        overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                        break;

                    case 1:
                        Intent cals = new Intent(EntradaServicios.this,CalcuSiembracana.class);
                        startActivity(cals);
                        overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar

                        break;

                    case 2:
                        Intent cal = new Intent(EntradaServicios.this,CalculoCana.class);
                        startActivity(cal);
                        overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                        break;

                    case 3:
                        Intent db = new Intent(EntradaServicios.this,InicioDB.class);
                        startActivity(db);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                        break;
                }

            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio_productos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                Intent infor = new Intent(EntradaServicios.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(EntradaServicios.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(EntradaServicios.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.idioma:
                Intent idio = new Intent(EntradaServicios.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(EntradaServicios.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.inici:
                Intent inicio = new Intent(EntradaServicios.this,Inicio.class);
                startActivity(inicio);
                overridePendingTransition(R.anim.zoom, R.anim.zoom);//para colocar transiccion al pasar
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
