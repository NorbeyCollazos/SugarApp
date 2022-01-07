package com.ncrdesarrollo.sugarapp;

import android.app.NotificationManager;
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

public class InicioDB extends AppCompatActivity {
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_db);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbariniciodb);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.titulobaseinicio);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(1);




        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

        datos.add(new Lista_entrada(R.drawable.iconguardar, getString(R.string.tituloguardar),getString(R.string.tgure)));
        datos.add(new Lista_entrada(R.drawable.iconlistar, getString(R.string.tituloconsul),getString(R.string.tconre)));
        datos.add(new Lista_entrada(R.drawable.iconeditar, getString(R.string.modificar),getString(R.string.tmore)));
        datos.add(new Lista_entrada(R.drawable.iconeliminar, getString(R.string.eliminar), getString(R.string.telire)));



        lista = (ListView) findViewById(R.id.contentlistview);
        lista.setAdapter(new Lista_adaptador(this, R.layout.activity_lista_entradainiciodb, datos){
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





        /*final ListView lista = (ListView)findViewById(R.id.contentlistview);
        adapter = new ListaAdapter(this, titulo,imagenes);
        lista.setAdapter(adapter);*/

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Clic sobre"+position,Toast.LENGTH_LONG).show();
                switch (position){
                    case 0:
                        Intent guardar = new Intent(InicioDB.this,GuardarDatos.class);
                        startActivity(guardar);
                        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
                        break;

                    case 1:
                        Intent consul = new Intent(InicioDB.this,ConsultarDatos.class);
                        startActivity(consul);
                        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                        break;

                    case 2:
                        Intent editar = new Intent(InicioDB.this,EditarDatos.class);
                        startActivity(editar);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                        break;

                    case 3:
                        Intent eliminar = new Intent(InicioDB.this,EliminarDatos.class);
                        startActivity(eliminar);
                        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
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
                Intent infor = new Intent(InicioDB.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(InicioDB.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(InicioDB.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.idioma:
                Intent idio = new Intent(InicioDB.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(InicioDB.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.inici:
                Intent inicio = new Intent(InicioDB.this,Inicio.class);
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
