package com.example.sqlite;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {
    Button btnGoAdmin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGoAdmin = findViewById(R.id.btnGoAdmin);
        btnGoAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAdminMenu();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    //Metodos

    private void goAdminMenu(){
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }



}