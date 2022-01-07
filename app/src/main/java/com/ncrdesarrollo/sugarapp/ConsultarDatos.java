package com.ncrdesarrollo.sugarapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ConsultarDatos extends AppCompatActivity {
    private EditText et1, et2, et3, et4, et5, et6;
    private Cursor fila;
    private LinearLayout layoutAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_datos);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbarconsul);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloconsul);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras


        et1 = (EditText) findViewById(R.id.et_num);
        et2 = (EditText) findViewById(R.id.et_fecha);
        et3 = (EditText) findViewById(R.id.et_pagobreros);
        et4 = (EditText) findViewById(R.id.et_pagotra);
        et5 = (EditText) findViewById(R.id.et_cantiobt);
        et6 = (EditText) findViewById(R.id.et_valorobt);

        layoutAnimado = (LinearLayout) findViewById(R.id.layoutanim);
    }

    public void consulta(View v) {
        try {


            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                    "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.
            String num = et1.getText().toString();
            Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
                    "select fecha,pagobre,pagotra,cantiobt,valorobt  from moliendas where num=" + num, null);
            if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
                et4.setText(fila.getString(2));
                et5.setText(fila.getString(3));
                et6.setText(fila.getString(4));
            } else
                Toast.makeText(this, getString(R.string.noexmo),
                        Toast.LENGTH_SHORT).show();
            bd.close();

            if (layoutAnimado.getVisibility() == View.GONE)
            {
                animar(true);
                layoutAnimado.setVisibility(View.VISIBLE);
            }


        }catch (Exception e){
            Toast.makeText(this, getString(R.string.debeinmo),
                    Toast.LENGTH_SHORT).show();
        }



    }

    public void inicio(View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        fila = bd.rawQuery(
                "select * from moliendas order by num asc ", null);

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
            et1.setText(fila.getString(0));
            et2.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            et4.setText(fila.getString(3));
            et5.setText(fila.getString(4));
            et6.setText(fila.getString(5));
        } else
            Toast.makeText(this, getString(R.string.nomolire) ,
                    Toast.LENGTH_SHORT).show();
        bd.close();

        if (layoutAnimado.getVisibility() == View.GONE)
        {
            animar(true);
            layoutAnimado.setVisibility(View.VISIBLE);
        }
    }



    public void anterior(View view) {

        try {
            if (!fila.isFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
                fila.moveToPrevious();
                et1.setText(fila.getString(0));
                et2.setText(fila.getString(1));
                et3.setText(fila.getString(2));
                et4.setText(fila.getString(3));
                et5.setText(fila.getString(4));
                et6.setText(fila.getString(5));
            } else
                Toast.makeText(this, getString(R.string.primerre),
                        Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void siguiente(View view) {

        try {
            if (!fila.isLast()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
                fila.moveToNext();
                et1.setText(fila.getString(0));
                et2.setText(fila.getString(1));
                et3.setText(fila.getString(2));
                et4.setText(fila.getString(3));
                et5.setText(fila.getString(4));
                et6.setText(fila.getString(5));
            } else
                Toast.makeText(this, getString(R.string.nomasre),
                        Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void fin(View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery(
                "select * from moliendas order by num asc ", null);

        if (fila.moveToLast()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
            et1.setText(fila.getString(0));
            et2.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            et4.setText(fila.getString(3));
            et5.setText(fila.getString(4));
            et6.setText(fila.getString(5));
        } else
            Toast.makeText(this, getString(R.string.nomolire) ,
                    Toast.LENGTH_SHORT).show();
        bd.close();

        if (layoutAnimado.getVisibility() == View.GONE)
        {
            animar(true);
            layoutAnimado.setVisibility(View.VISIBLE);
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
        animation.setDuration(300);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);


    }

}
