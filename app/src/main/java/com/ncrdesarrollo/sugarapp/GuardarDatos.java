package com.ncrdesarrollo.sugarapp;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class GuardarDatos extends AppCompatActivity implements View.OnClickListener {

    private EditText et1, et2, et3, et4, et5, et6;
    private Cursor fila;
    Button btnDatePicker;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_datos);


        Toolbar tb = (Toolbar)findViewById(R.id.tolbarguardar);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.tituloguardar);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras


        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnDatePicker.setOnClickListener(this);


        et1 = (EditText) findViewById(R.id.et_num);
        et2 = (EditText) findViewById(R.id.et_fecha);
        et3 = (EditText) findViewById(R.id.et_pagobreros);
        et4 = (EditText) findViewById(R.id.et_pagotra);
        et5 = (EditText) findViewById(R.id.et_cantiobt);
        et6 = (EditText) findViewById(R.id.et_valorobt);
    }


    public void alta(View v) {
        try {

            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();

            String num = et1.getText().toString();
            String fecha = et2.getText().toString();
            String pagobre = et3.getText().toString();
            String pagotra = et4.getText().toString();
            String cantiobt = et5.getText().toString();
            String valorobt = et6.getText().toString();



            Cursor fila = bd.rawQuery("select * from moliendas where num=" + num, null);


            if (!fila.moveToFirst()) {

                ContentValues registro = new ContentValues();  //es una clase para guardar datos


                registro.put("num", num);
                registro.put("fecha", fecha);
                registro.put("pagobre", pagobre);
                registro.put("pagotra", pagotra);
                registro.put("cantiobt", cantiobt);
                registro.put("valorobt", valorobt);


            if (num.equals("")){
                Toast.makeText(this, getString(R.string.innum),
                        Toast.LENGTH_LONG).show();
            }else
            if (fecha.equals("")){
                    Toast.makeText(this, getString(R.string.infecha),
                            Toast.LENGTH_LONG).show();
                }else if (pagobre.equals("")){
                    Toast.makeText(this, getString(R.string.inobre),
                            Toast.LENGTH_LONG).show();
                }else if (pagotra.equals("")){
                    Toast.makeText(this, getString(R.string.intra),
                            Toast.LENGTH_LONG).show();
                }else if (cantiobt.equals("")){
                    Toast.makeText(this, getString(R.string.canob),
                            Toast.LENGTH_LONG).show();
                }else if (valorobt.equals("")){
                    Toast.makeText(this, getString(R.string.inva),
                            Toast.LENGTH_LONG).show();
                }
                else {

                    bd.insert("moliendas", null, registro);
                    bd.close();

                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et1.requestFocus();






                    //para la notificacion
                    Intent prueba = new Intent(GuardarDatos.this, InicioDB.class);
                    TaskStackBuilder nuevo = TaskStackBuilder.create(getApplicationContext());
                    nuevo.addParentStack(InicioDB.class);
                    nuevo.addNextIntent(prueba);

                    PendingIntent intento = nuevo.getPendingIntent(123, PendingIntent.FLAG_UPDATE_CURRENT);

                    NotificationCompat.Builder noti = new NotificationCompat.Builder(this);
                    noti.setContentTitle("Sugar App");
                    noti.setContentText(getString(R.string.nre));
                    noti.setSmallIcon(R.drawable.ic_guardar);
                    noti.setContentIntent(intento);

                    //Agregando sonido y bibracion
                    noti.setDefaults(Notification.DEFAULT_SOUND);
                    noti.setVibrate(new long[]{100, 2000, 500, 2000});
                    noti.setLights(Color.GREEN, 400, 400);

                    Notification notificar = noti.build();
                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    nm.notify(1, notificar);


                Toast.makeText(this, getString(R.string.guamo),
                        Toast.LENGTH_SHORT).show();

                }

            } else {
                bd.close();
                Toast.makeText(this,getString(R.string.yaexis), Toast.LENGTH_SHORT).show();
            }

        }catch(Exception e){
            Toast.makeText(this,getString(R.string.innum),
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void limpiar(View view) {

        try {
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
            et1.requestFocus();
        }catch (Exception e){
            Toast.makeText(this, getString(R.string.nolim),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View view) {

        AlertDialog.Builder prueba = new AlertDialog.Builder(this);
        prueba.setMessage(getString(R.string.saligau));
        prueba.setTitle(getString(R.string.inmoli));
        prueba.setIcon(R.mipmap.ic_launcher);

        prueba.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
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
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder prueba = new AlertDialog.Builder(this);
        prueba.setMessage(getString(R.string.saligau));
        prueba.setTitle(getString(R.string.inmoli));
        prueba.setIcon(R.mipmap.ic_launcher);



        prueba.setPositiveButton(getString(R.string.si), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_date:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                et2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
        }
    }
}
