package com.ncrdesarrollo.sugarapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //llamamos al constructor
    public AdminSQLiteOpenHelper(Context context, String fecha, CursorFactory factory, int version) {
        super(context, fecha, factory, version);
    }

    //creamos la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table moliendas(num integer primary key, fecha text, pagobre integer, pagotra integer, cantiobt text, valorobt integer)");
    }

    //borrar la tabla y crear la nueva tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists moliendas");
        db.execSQL("create table moliendas(num integer primary key, fecha text, pagobre integer, pagotra integer, cantiobt text, valorobt integer)");
    }
}
