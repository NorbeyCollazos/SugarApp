package com.ncrdesarrollo.sugarapp;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class CalcuSiembracana extends AppCompatActivity {
    private View contenedorK;
    private View contenedorA;
    EditText kilos, arrobas;
    Button calkilos,calarrobas,limpiark,limpiara;
    TextView resulkilos, tituloresul,resulkilos2, tituloresul2,hecta;
    private LinearLayout layoutAnimado,layoutAnimado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu_siembracana);

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
        layoutAnimado2 = (LinearLayout) findViewById(R.id.layoutanimado2);

        kilos = (EditText) findViewById(R.id.etkilos);
        arrobas = (EditText) findViewById(R.id.etarrobas);

        resulkilos = (TextView) findViewById(R.id.tvresultkilos);
        resulkilos2 = (TextView) findViewById(R.id.tvresultkilos2);
        hecta = (TextView) findViewById(R.id.tvresultkilos3);


        tituloresul = (TextView) findViewById(R.id.texresultado);
        tituloresul2 = (TextView) findViewById(R.id.texresultado2);



        calkilos = (Button) findViewById(R.id.btncalkilos);
        calarrobas = (Button) findViewById(R.id.btncalarrobas);

        limpiark = (Button) findViewById(R.id.btnlimpiarkilos);
        limpiara = (Button) findViewById(R.id.btnlimpiararrobas);

        limpiark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilos.setText("");
                resulkilos.setText("");
                kilos.requestFocus();
            }
        });
        limpiara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrobas.setText("");
                hecta.setText("");
                resulkilos2.setText("");
                arrobas.requestFocus();
            }
        });



        calkilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{


                    double kilosr = Double.parseDouble(kilos.getText().toString());


                    double operki = kilosr / 1.5;
                    double resu = operki *2;

                    String resultadok = String.valueOf(resu);
                    resultadok = resultadok.substring(0,05);
                    resu = Double.parseDouble(resultadok);
                    resulkilos.setText(resu+"");


                    if (layoutAnimado.getVisibility() == View.GONE)
                    {
                        animar(true);
                        layoutAnimado.setVisibility(View.VISIBLE);
                    }





                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),getString(R.string.ingrem),Toast.LENGTH_LONG).show();
                }
            }
        });


        calarrobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{


                    double Arrobas = Double.parseDouble(arrobas.getText().toString());
//formulara para un tallo 1.5 y operki /10000
                    double operki = Arrobas * 0.75;
                    double operh = operki /10000;

                    String resultadoA = String.valueOf(operki);
                    resulkilos2.setText(resultadoA+" "+getString(R.string.mtroscua));

                    String resultadoH = String.valueOf(operh);
                    hecta.setText(resultadoH+" "+getString(R.string.hecta));




                    if (layoutAnimado2.getVisibility() == View.GONE)
                    {
                        animar(true);
                        layoutAnimado2.setVisibility(View.VISIBLE);
                    }




                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),getString(R.string.ingret),Toast.LENGTH_LONG).show();
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
                if(layoutAnimado2.getVisibility()== View.VISIBLE){

                    animar(true);
                    layoutAnimado2.setVisibility(View.GONE);
                }

                break;

            case R.id.rb_arrobas:
                if (marcado){
                    mostrarparticular(true);
                }

                if(layoutAnimado.getVisibility()== View.VISIBLE){

                    animar(true);
                    layoutAnimado.setVisibility(View.GONE);
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
        animation.setDuration(000);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);


    }

}


