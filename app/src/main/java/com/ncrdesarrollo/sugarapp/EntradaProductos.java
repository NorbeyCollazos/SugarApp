package com.ncrdesarrollo.sugarapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EntradaProductos extends AppCompatActivity {

    private ListView lista;

    Animation left_in ,left_out;
    ViewFlipper viewFlipper;

/*
    int[] imagenes = {
            R.drawable.panela1viewpager,
            R.drawable.caramelo1viewpager,
            R.drawable.guarapoviewpager,
            R.drawable.mielviewpager,
            R.drawable.blanqueadoviewpager,
            R.drawable.cachazaviepager,
            R.drawable.abonoviewpager
    };

    ManejadoraGaleria manejadorGaleria;
    ViewPager mViewPager;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_productos);

        /*Toast toast= Toast.makeText(getApplicationContext(),getString(R.string.deslice), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER,0,-100);
        toast.show();*/

        Toolbar tb = (Toolbar)findViewById(R.id.toolbarimagenes);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloinicioproductos);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras

        viewFlipper = (ViewFlipper)this.findViewById(R.id.contenimg);

        left_in = AnimationUtils.loadAnimation(this, R.anim.left_in);
        left_out = AnimationUtils.loadAnimation(this, R.anim.left_out);

        viewFlipper.setInAnimation(left_in);
        viewFlipper.setOutAnimation(left_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();



        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

        datos.add(new Lista_entrada(R.drawable.iconpanela, getString(R.string.consuh), "Guarapo, Miel, Blanqueado, Caramelo, Panela"));
        datos.add(new Lista_entrada(R.drawable.cachazaredon, getString(R.string.consua), "Cachaza"));
        datos.add(new Lista_entrada(R.drawable.bagazoredondo, getString(R.string.abono), "Bagazo, Cachaza"));



        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.activity_lista_entrada, datos){
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
                        Intent pasar = new Intent(EntradaProductos.this,ProconsuHumano.class);
                        startActivity(pasar);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);//para colocar transiccion al pasar
                        break;

                    case 1:
                       // Toast.makeText(getApplicationContext(),"Consumo animal",Toast.LENGTH_LONG).show();
                        Intent pasarani = new Intent(EntradaProductos.this,CachazaConsuanimal.class);
                        startActivity(pasarani);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);//para colocar transiccion al pasar

                        break;

                    case 2:
                        Intent pasara = new Intent(EntradaProductos.this,Abonos.class);
                        startActivity(pasara);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);//para colocar transiccion al pasar
                        break;
                }

            }
        });

        //galeria de imagenes

      /*  manejadorGaleria = new ManejadoraGaleria(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[3]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[4]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[5]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[6]));

        mViewPager.setAdapter(manejadorGaleria);*/

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
                Intent infor = new Intent(EntradaProductos.this,Informacion.class);
                startActivity(infor);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//para colocar transiccion al pasar
                break;
            case R.id.cont:
                Intent con = new Intent(EntradaProductos.this,Contactenos.class);
                startActivity(con);
                overridePendingTransition(R.anim.move_up, R.anim.move_up);//para colocar transiccion al pasar
                break;

            case R.id.ubicacion:
                Intent ubica = new Intent(EntradaProductos.this,Ubicacion.class);
                startActivity(ubica);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.idioma:
                Intent idio = new Intent(EntradaProductos.this,Idioma.class);
                startActivity(idio);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;


            case R.id.manual:
                Intent manual = new Intent(EntradaProductos.this,Manual.class);
                startActivity(manual);
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);//para colocar transiccion al pasar
                break;

            case R.id.inici:
                Intent inicio = new Intent(EntradaProductos.this,Inicio.class);
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








    public void evento(View view) {
        /*
        Intent pas = new Intent(MyActivity.this,MainActivity.class);
        startActivity(pas);*/

    }


    public class ManejadoraGaleria extends FragmentPagerAdapter {

        List<Fragment> fragmentos;
        public ManejadoraGaleria(FragmentManager fm) {
            super(fm);
            fragmentos = new ArrayList<Fragment>();
        }

        public void agregarFragmentos(Fragment xfragmento){
            fragmentos.add(xfragmento);
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }
    }


    public static class FragmentosImagenes extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static FragmentosImagenes newInstance(int imagen) {
            FragmentosImagenes fragment = new FragmentosImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentosImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView1);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }

}
