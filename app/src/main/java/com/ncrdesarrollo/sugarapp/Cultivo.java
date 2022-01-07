package com.ncrdesarrollo.sugarapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class Cultivo extends AppCompatActivity implements SiembraCultivo.OnFragmentInteractionListener,
        ManejoCultivo.OnFragmentInteractionListener, RecoleccionCultivo.OnFragmentInteractionListener, View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultivo);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(R.string.titulocultivo);//titulo

        //getSupportActionBar().setSubtitle(R.string.subtitulo);//subtitulo

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//flecha atras

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
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
                Intent infor = new Intent(Cultivo.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(Cultivo.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(Cultivo.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.idioma:
                Intent idio = new Intent(Cultivo.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(Cultivo.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;



            case R.id.inici:
                Intent inicio = new Intent(Cultivo.this,Inicio.class);
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




    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {

    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new SiembraCultivo();
                case 1:
                    return new ManejoCultivo();

                case 2:
                    return new RecoleccionCultivo();

                default:
                    return new Fragment();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return getString(R.string.siem);
                case 1:
                    return getString(R.string.manecul);
                case 2:
                    return getString(R.string.reco);

                default:
                    return "Gracias Dios";
            }
        }

    }
}
