package com.ncrdesarrollo.sugarapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by AMBIENTE on 19/08/2016.
 */
public class ImageAdapter2 extends BaseAdapter {
    private Context mContext;

    public ImageAdapter2(Context c){
        mContext = c;
    }


    @Override
    public int getCount() {
        return mThumbIds.length;
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

        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100 ,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(6,6,6,6);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
       return imageView;
    }

    private Integer[]mThumbIds = {
            R.drawable.siembraportada,R.drawable.cultivo1,
            R.drawable.abonada,R.drawable.cultivo2,
            R.drawable.recoleccionc,R.drawable.cortecana,
            R.drawable.moler,R.drawable.bagazo,
            R.drawable.guarapoviewpager,R.drawable.mielviewpager,
            R.drawable.blanqueadoviewpager,R.drawable.caramelo1viewpager,
            R.drawable.panela1viewpager,R.drawable.cachazaviepager,
            R.drawable.cachazagallinas,R.drawable.abonobagazo

    };


}
