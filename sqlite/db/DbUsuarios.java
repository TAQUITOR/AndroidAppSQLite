package com.example.sqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.sqlite.entidades.Usuarios;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long registroUsuario(String nombre, String paterno, String materno,String genero,String curp ,String edad){

        long id = 0;

        try {

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("paterno", paterno);
            values.put("materno", materno);
            values.put("genero", genero);
            values.put("curp", curp);
            values.put("edad", edad);

            id = db.insert(TABLE_SOCIOS, null, values);

        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public long editarUsuario(String id, String nombre, String paterno, String materno,String genero,String curp ,String edad){
        int rowsAffected = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("paterno", paterno);
            values.put("materno", materno);
            values.put("genero", genero);
            values.put("curp", curp);
            values.put("edad", edad);

            String selection = "id = ?";
            String[] selectionArgs = { id };

            rowsAffected = db.update(TABLE_SOCIOS, values, selection, selectionArgs);
        } catch (Exception ex) {
            ex.toString();
        }
        return rowsAffected;
    }

    public int eliminarUsuario(String id) {
        int rowsAffected = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String selection = "id = ?";
            String[] selectionArgs = { id };

            rowsAffected = db.delete(TABLE_SOCIOS, selection, selectionArgs);
        } catch (Exception ex) {
            ex.toString();
        }
        return rowsAffected;
    }

    //Metodo para traer los datos de la base de datos y poder mostrarlos

    public ArrayList<Usuarios> mostrarUsuarios(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        Usuarios usuario = null;
        Cursor cursorUsuarios = null;

        cursorUsuarios = db.rawQuery("SELECT * FROM " + TABLE_SOCIOS, null);

        if(cursorUsuarios.moveToFirst()){
            do{
                usuario = new Usuarios();
                usuario.setId(cursorUsuarios.getInt(0));
                usuario.setNombre(cursorUsuarios.getString(1));
                usuario.setA_paterno(cursorUsuarios.getString(2));
                usuario.setA_materno(cursorUsuarios.getString(3));
                usuario.setCurp(cursorUsuarios.getString(4));
                usuario.setEdad(cursorUsuarios.getString(5));
                usuario.setGenero(cursorUsuarios.getString(6));

                listaUsuarios.add(usuario);

            } while(cursorUsuarios.moveToNext());
        }

        cursorUsuarios.close();

        return listaUsuarios;

    }

}
