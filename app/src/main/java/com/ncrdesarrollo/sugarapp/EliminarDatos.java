package com.ncrdesarrollo.sugarapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;


public class EliminarDatos extends AppCompatActivity {
    private EditText et1, et2, et3, et4, et5, et6;
    private Cursor fila;
    private LinearLayout layoutAnimado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_datos);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbareliminar);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloeliminar);

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

    public void baja(View v) {


            AlertDialog.Builder pruebaaler = new AlertDialog.Builder(this);
            pruebaaler.setMessage(getString(R.string.elimo));
            pruebaaler.setTitle(getString(R.string.regismoli));
            pruebaaler.setIcon(R.mipmap.ic_launcher);

            pruebaaler.setPositiveButton(getString(R.string.elimina), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    try {

                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),
                                "administracion", null, 1);
                        SQLiteDatabase bd = admin.getWritableDatabase();
                        String num = et1.getText().toString();
                        int cant = bd.delete("moliendas", "num=" + num, null); // (votantes es la nombre de la tabla, condición)
                        bd.close();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");
                        et5.setText("");
                        et6.setText("");
                        if (cant == 1) {
                            Toast.makeText(getApplicationContext(), getString(R.string.borromoli),
                                    Toast.LENGTH_SHORT).show();


                            //para la notificacion
                            Intent prueba = new Intent(EliminarDatos.this, InicioDB.class);
                            TaskStackBuilder nuevo = TaskStackBuilder.create(getApplicationContext());
                            nuevo.addParentStack(InicioDB.class);
                            nuevo.addNextIntent(prueba);

                            PendingIntent intento = nuevo.getPendingIntent(123, PendingIntent.FLAG_UPDATE_CURRENT);

                            NotificationCompat.Builder noti = new NotificationCompat.Builder(getApplicationContext());
                            noti.setContentTitle("Sugar App");
                            noti.setContentText(getString(R.string.elire));
                            noti.setSmallIcon(R.drawable.ic_elimi);
                            noti.setContentIntent(intento);

                            //Agregando sonido y bibracion
                            noti.setDefaults(Notification.DEFAULT_SOUND);
                            noti.setVibrate(new long[]{100, 2000, 500, 2000});
                            noti.setLights(Color.GREEN, 400, 400);

                            Notification notificar = noti.build();
                            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                            nm.notify(1, notificar);

                        }else
                            Toast.makeText(getApplicationContext(), getString(R.string.noexmo),
                                    Toast.LENGTH_SHORT).show();




                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), getString(R.string.debeinmo),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            pruebaaler.setNegativeButton(getString(R.string.cance), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            AlertDialog dialog = pruebaaler.create();
            dialog.show();




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
