package com.ncrdesarrollo.sugarapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;


public class Contactenos extends AppCompatActivity implements View.OnClickListener {
    ImageView   celL, celN, abrirL,abrirN,abrirS;
    Button emailL,limpiarL,canceL,emailN,limpiarN,canceN,emailS,limpiarS,canceS;
    EditText asuntoL, mensajeL,asuntoN, mensajeN,asuntoS, mensajeS;
    TextView textoenviar1,textoenviar2,textoenviar3;
    private LinearLayout layoutAnimado,layoutAnimado2,layoutAnimado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbarcontactenos);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        //getSupportActionBar().setTitle(R.string.titulocontactenos);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        getSupportActionBar().setIcon(R.drawable.ic_contac);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras

        /*textoenviar1 = (TextView) findViewById(R.id.txenviar1);
        String font_meri = "font/Brush Script MT.ttf";
        Typeface TM = Typeface.createFromAsset(getAssets(),font_meri);
        textoenviar1.setTypeface(TM);*/

        textoenviar2 = (TextView) findViewById(R.id.txenviarN);
        String font_meri2 = "font/Brush Script MT.ttf";
        Typeface TM2= Typeface.createFromAsset(getAssets(),font_meri2);
        textoenviar2.setTypeface(TM2);

        textoenviar3 = (TextView) findViewById(R.id.txenviarS);
        String font_meri3 = "font/Brush Script MT.ttf";

        layoutAnimado2 = (LinearLayout) findViewById(R.id.layoutanimado2);
        layoutAnimado3 = (LinearLayout) findViewById(R.id.layoutanimado3);


        abrirN = (ImageView)findViewById(R.id.abrirN);
        abrirN.setOnClickListener(this);

        asuntoN = (EditText)findViewById(R.id.etasuntoN);
        mensajeN = (EditText)findViewById(R.id.etmensajeN);

        limpiarN = (Button)findViewById(R.id.limpiarN);
        limpiarN.setOnClickListener(this);

        canceN = (Button) findViewById(R.id.cancelarN);
        canceN.setOnClickListener(this);

        emailN = (Button)findViewById(R.id.emailN);
        emailN.setOnClickListener(this);




        abrirS = (ImageView)findViewById(R.id.abrirS);
        abrirS.setOnClickListener(this);

        asuntoS = (EditText)findViewById(R.id.etasuntoS);
        mensajeS = (EditText)findViewById(R.id.etmensajeS);

        limpiarS = (Button)findViewById(R.id.limpiarS);
        limpiarS.setOnClickListener(this);

        canceS = (Button) findViewById(R.id.cancelarS);
        canceS.setOnClickListener(this);

        emailS = (Button)findViewById(R.id.emailS);
        emailS.setOnClickListener(this);


        celN = (ImageView)findViewById(R.id.celnor);
        celN.setOnClickListener(this);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cultivo, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.inicio:
                Intent inicio = new Intent(Contactenos.this,Inicio.class);
                startActivity(inicio);
                overridePendingTransition(R.anim.zoom, R.anim.zoom);//para colocar transiccion al pasar
                break;

            case R.id.salir:
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
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.emailN:
                String AsuntoN = asuntoN.getText().toString();
                String MensajeN = mensajeN.getText().toString();

                if (AsuntoN.equals("")){
                    Toast.makeText(getApplicationContext(),getString(R.string.escriasu),Toast.LENGTH_LONG).show();
                }else if (MensajeN.equals("")){
                    Toast.makeText(getApplicationContext(),getString(R.string.escrimen),Toast.LENGTH_LONG).show();
                }else {


                    if (layoutAnimado2.getVisibility() == View.VISIBLE) {
                        animar(true);
                        layoutAnimado2.setVisibility(View.GONE);
                    }

                    enviarEmailN();
                }
                break;



            case R.id.emailS:
                String AsuntoS = asuntoS.getText().toString();
                String MensajeS = mensajeS.getText().toString();

                if (AsuntoS.equals("")){
                    Toast.makeText(getApplicationContext(),getString(R.string.escriasu),Toast.LENGTH_LONG).show();
                }else if (MensajeS.equals("")){
                    Toast.makeText(getApplicationContext(),getString(R.string.escrimen),Toast.LENGTH_LONG).show();
                }else {


                    if (layoutAnimado3.getVisibility() == View.VISIBLE) {
                        animar(true);
                        layoutAnimado3.setVisibility(View.GONE);
                    }

                    enviarEmailS();
                }
                break;





            case R.id.abrirN:
                if (layoutAnimado2.getVisibility() == View.GONE)
                {
                    animar(true);
                    layoutAnimado2.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.limpiarN:
                asuntoN.setText("");
                mensajeN.setText("");
                asuntoN.requestFocus();
                break;


            case R.id.cancelarN:
                AlertDialog.Builder prueba2 = new AlertDialog.Builder(this);
                prueba2.setMessage(getString(R.string.salirsinmen));
                prueba2.setTitle("Sugar App");
                prueba2.setIcon(R.mipmap.ic_launcher);

                prueba2.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        asuntoN.setText("");
                        mensajeN.setText("");
                        asuntoN.requestFocus();

                        if (layoutAnimado2.getVisibility() == View.VISIBLE) {
                            animar(true);
                            layoutAnimado2.setVisibility(View.GONE);
                        }
                    }
                });

                prueba2.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                AlertDialog dialog2 = prueba2.create();
                dialog2.show();
                break;


            case R.id.abrirS:
                if (layoutAnimado3.getVisibility() == View.GONE)
                {
                    animar(true);
                    layoutAnimado3.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.limpiarS:
                asuntoS.setText("");
                mensajeS.setText("");
                asuntoS.requestFocus();
                break;


            case R.id.cancelarS:
                AlertDialog.Builder prueba3 = new AlertDialog.Builder(this);
                prueba3.setMessage(getString(R.string.salirsinmen));
                prueba3.setTitle("Sugar App");
                prueba3.setIcon(R.mipmap.ic_launcher);

                prueba3.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        asuntoS.setText("");
                        mensajeS.setText("");
                        asuntoS.requestFocus();

                        if (layoutAnimado3.getVisibility() == View.VISIBLE) {
                            animar(true);
                            layoutAnimado3.setVisibility(View.GONE);
                        }
                    }
                });

                prueba3.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                AlertDialog dialog3 = prueba3.create();
                dialog3.show();
                break;



        }

    }

    //Creamos el método enviarEmail Lorena
    public void enviarEmailL() {
        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lramirez552@misena.edu.co"});
        // Definimos un titulo para el Email
        emailIntent.putExtra(Intent.EXTRA_TITLE, "El Titulo");
        // Definimos un Asunto para el Email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asuntoL.getText().toString());
        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensajeL.getText());
        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            startActivity(Intent.createChooser(emailIntent, getString(R.string.enviarcorreo)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contactenos.this, getString(R.string.nocli), Toast.LENGTH_SHORT).show();
        }

    }


    //Creamos el método enviarEmail Norbey
    public void enviarEmailN() {
        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ncollazos1@misena.edu.co"});
        // Definimos un titulo para el Email
        emailIntent.putExtra(Intent.EXTRA_TITLE, "El Titulo");
        // Definimos un Asunto para el Email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,  asuntoN.getText().toString());
        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensajeN.getText());
        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            startActivity(Intent.createChooser(emailIntent,  getString(R.string.enviarcorreo)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contactenos.this, getString(R.string.nocli), Toast.LENGTH_SHORT).show();
        }

    }


    //Creamos el método enviarEmail SugarApp
    public void enviarEmailS() {
        //Instanciamos un Intent del tipo ACTION_SEND
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //Definimos la tipologia de datos del contenido dle Email en este caso text/html
        emailIntent.setType("text/html");
        // Indicamos con un Array de tipo String
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"proyectosugarapp@gmail.com"});
        // Definimos un titulo para el Email
        emailIntent.putExtra(Intent.EXTRA_TITLE, "El Titulo");
        // Definimos un Asunto para el Email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asuntoS.getText().toString());
        // Obtenemos la referencia al texto y lo pasamos al Email Intent
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensajeS.getText());
        try {
            //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
            startActivity(Intent.createChooser(emailIntent, getString(R.string.enviarcorreo)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contactenos.this, getString(R.string.nocli), Toast.LENGTH_SHORT).show();
        }

    }



    private void animar(boolean mostrar)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar)
        {
            //desde la esquina inferior derecha a la superior izquierda
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else
        {    //desde la esquina superior izquierda a la esquina inferior derecha
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        }
        //duración en milisegundos
        animation.setDuration(400);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);


        layoutAnimado2.setLayoutAnimation(controller);
        layoutAnimado2.startAnimation(animation);

        layoutAnimado3.setLayoutAnimation(controller);
        layoutAnimado3.startAnimation(animation);


    }


}
