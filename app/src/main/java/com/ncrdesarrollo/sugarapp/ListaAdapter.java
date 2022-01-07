package com.ncrdesarrollo.sugarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by AMBIENTE on 19/08/2016.
 */
public class ListaAdapter extends BaseAdapter {
    Context context;
    String[] titulos;
    int[] imagenes;
    LayoutInflater inflater;

    public ListaAdapter(Context context, String[] titulos, int[] imagenes){
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txTitle;
        ImageView imgImg;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.lista, parent,false);

        txTitle = (TextView) itemView.findViewById(R.id.titulolista);
        imgImg = (ImageView) itemView.findViewById(R.id.iconlista);


        txTitle.setText(titulos[position]);
        imgImg.setImageResource(imagenes[position]);


        return itemView;
    }
}
