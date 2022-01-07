package com.ncrdesarrollo.sugarapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class ProconsuHumano extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Panela.OnFragmentInteractionListener, View.OnClickListener {

    RelativeLayout mens;
    ImageView men;

    Animation fade_in ,fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proconsu_humano);

        viewFlipper = (ViewFlipper)this.findViewById(R.id.contenimg);


        fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();


        mens = (RelativeLayout)findViewById(R.id.contenedor);
        mens.setOnClickListener(this);

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, getString(R.string.clicezquina), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

        Toast.makeText(getApplicationContext(),getString(R.string.clicezquina),Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*ImageView img1 = (ImageView)findViewById(R.id.imgpro);

        Animation anin = AnimationUtils.loadAnimation(this,  R.anim.animacion2);
        img1.setAnimation(anin);*/




        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloconsumohumano);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
       // getSupportActionBar().setIcon(R.drawable.ic_tool_bar);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent atras = new Intent(ProconsuHumano.this,EntradaProductos.class);
                startActivity(atras);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);//para colocar transiccion al pasar
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //para conservar los colores del icono
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
                Intent infor = new Intent(ProconsuHumano.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(ProconsuHumano.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(ProconsuHumano.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.idioma:
                Intent idio = new Intent(ProconsuHumano.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(ProconsuHumano.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.inici:
                Intent inicio = new Intent(ProconsuHumano.this,Inicio.class);
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




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean FragmentSeleccionado = false;


        if (id == R.id.guarapo) {
            // Handle the camera action
            Intent guara = new Intent(this,Guarapo.class);
            startActivity(guara);
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar
        } else if (id == R.id.miel) {
            Intent miel = new Intent(this,Miel.class);
            startActivity(miel);
            overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar

        } else if (id == R.id.blanqueado) {
            Intent blanq = new Intent(this,Blanqueado.class);
            startActivity(blanq);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar

        } else if (id == R.id.caramelo) {
            Intent carame = new Intent(this,Caramelo.class);
            startActivity(carame);
            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);//para colocar transiccion al pasar

        } else if (id == R.id.panela) {
            Intent panela = new Intent(this,Ppanela.class);
            startActivity(panela);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar


            //fragment = new Panela();
            //FragmentSeleccionado = true;
        }else if (id == R.id.web) {
            Intent web = new Intent(this,PaginaWeb.class);
            startActivity(web);
            overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar

        }

        if (FragmentSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.contenedor:
                Toast.makeText(getApplicationContext(),getString(R.string.clicezquina),Toast.LENGTH_LONG).show();



                break;
        }
    }
}
