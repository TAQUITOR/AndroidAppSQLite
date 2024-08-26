package com.example.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "controlSocios.db";
    public static final String TABLE_SOCIOS = "t_socios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        crearTabla(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_SOCIOS);
        onCreate(db);
    }
    //Metodos

    public void crearTabla(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_SOCIOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT  NULL," +
                "paterno TEXT NOT NULL,"+
                "materno TEXT NOT NULL,"+
                "genero TEXT NOT NULL," +
                "curp TEXT NOT NULL," +
                "edad TEXT)");
    }

}
