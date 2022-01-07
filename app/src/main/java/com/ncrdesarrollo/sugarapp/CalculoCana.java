package com.ncrdesarrollo.sugarapp;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class CalculoCana extends AppCompatActivity {
    private View contenedorK;
    private View contenedorA;
    EditText kilos, arrobas;
    Button calkilos,calarrobas,limpiark,limpiara;
    TextView resulkilos,resularrobas, tituloresul;

    private LinearLayout layoutAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_cana);

        Toolbar tb = (Toolbar)findViewById(R.id.tolbarcalcucana);
        //agrgamos la compatibilidad con otras versiones
        setSupportActionBar(tb);
        //Agregamos el titulo
        getSupportActionBar().setTitle(R.string.titulocalca);

        //Agregamos el subtitulo
        //getSupportActionBar().setSubtitle(R.string.exelente);

        //Agregamos un icono
        //getSupportActionBar().setIcon(R.drawable.ic_tool_img);

        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //para la flecha hacia atras



        contenedorK = findViewById(R.id.contenedor_kilos);
        contenedorA = findViewById(R.id.contenedor_arrobas);

        layoutAnimado = (LinearLayout) findViewById(R.id.layoutanimado);

        kilos = (EditText) findViewById(R.id.etkiloo);
        arrobas = (EditText) findViewById(R.id.etarrobas);

        resulkilos = (TextView) findViewById(R.id.tvresultkilos);
        resularrobas = (TextView) findViewById(R.id.tvresultarrobas);

        tituloresul = (TextView) findViewById(R.id.texresultado);


        calkilos = (Button) findViewById(R.id.btncalkilos);
        calarrobas = (Button) findViewById(R.id.btncalarrobas);

        limpiark = (Button) findViewById(R.id.btnlimpiarkilos);
        limpiara = (Button) findViewById(R.id.btnlimpiararrobas);

        limpiark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilos.setText("");
                resulkilos.setText("");
                resularrobas.setText("");
                kilos.requestFocus();
            }
        });
        limpiara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrobas.setText("");
                resulkilos.setText("");
                resularrobas.setText("");
                arrobas.requestFocus();
            }
        });



        calkilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{


                    double kilosr = Double.parseDouble(kilos.getText().toString());


                    double operkilos = kilosr * 9;
                    double operArrobas = kilosr * 0.72;

                    String resultadok = String.valueOf(operkilos);
                    resultadok = resultadok.substring(0,5);
                    operkilos = Double.parseDouble(resultadok);
                    resulkilos.setText(operkilos+" Kilos");

                    String resultadoa = String.valueOf(operArrobas);

                    resularrobas.setText(resultadoa+" "+getString(R.string.arroba));


                    if (layoutAnimado.getVisibility() == View.GONE)
                    {
                        animar(true);
                        layoutAnimado.setVisibility(View.VISIBLE);
                    }



                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),getString(R.string.ingrek),Toast.LENGTH_LONG).show();
                }
            }
        });


        calarrobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{


                    double Arrobas = Double.parseDouble(arrobas.getText().toString());


                    double operA = Arrobas * 9;
                    double operki = Arrobas * 112.5;

                    String resultadoA = String.valueOf(operki);
                    resulkilos.setText(resultadoA+" Kilos");

                    String resultadok = String.valueOf(operA);
                    resularrobas.setText(resultadok+" "+getString(R.string.arroba));


                    if (layoutAnimado.getVisibility() == View.GONE)
                    {
                        animar(true);
                        layoutAnimado.setVisibility(View.VISIBLE);
                    }


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),getString(R.string.ingrea),Toast.LENGTH_LONG).show();
                }

            }
        });



    }

    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.rb_kilos:
                if (marcado) {
                    mostrarparticular(false);
                }

                break;

            case R.id.rb_arrobas:
                if (marcado){
                    mostrarparticular(true);
                }


        }
    }

    private void mostrarparticular(boolean b) {
        contenedorA.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorK.setVisibility(b ? View.GONE : View.VISIBLE);
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

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);


    }

}


