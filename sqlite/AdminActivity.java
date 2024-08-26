package com.example.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.adaptadores.ListaUsuarioAdapter;
import com.example.sqlite.db.DbHelper;
import com.example.sqlite.db.DbUsuarios;
import com.example.sqlite.entidades.Usuarios;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {


    RecyclerView listaUsuarios;
    ArrayList<Usuarios> listaArrayUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);

        listaUsuarios = findViewById(R.id.listaContactos);

        listaUsuarios.setLayoutManager(new LinearLayoutManager(this));

        DbUsuarios dbUsuarios = new DbUsuarios(AdminActivity.this);

        listaArrayUsuarios = new ArrayList<>();

        ListaUsuarioAdapter adapter = new ListaUsuarioAdapter(dbUsuarios.mostrarUsuarios());

        listaUsuarios.setAdapter(adapter);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Metodos

//    public void crearBase() {
//        DbHelper dbHelper = new DbHelper(MainActivity.this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        if (db != null) {
//            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
//        }
//    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_nuevo) {
            nuevoRegistro();
            return true;
        } else if (item.getItemId() == R.id.editar_registro) {
            editarRegistro();
        } else if(item.getItemId() == R.id.eliminar_registro){
            eliminarRegistro();
        }
        else {
            return super.onOptionsItemSelected(item);
        }

        return false;
    }



    private void nuevoRegistro(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    private void editarRegistro(){
        Intent intent = new Intent(this, Editar_Registro.class);
        startActivity(intent);
    }

    private void eliminarRegistro(){
        Intent intent = new Intent(this, Eliminar_Registro.class);
        startActivity(intent);
    }




}



