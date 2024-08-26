package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlite.db.DbUsuarios;

public class Eliminar_Registro extends AppCompatActivity {

    EditText idRegistro;

    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eliminar_registro);

        idRegistro = findViewById(R.id.eliminarID);
        btnDelete = findViewById(R.id.btnEliminar);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbUsuarios dbUsuarios = new DbUsuarios(Eliminar_Registro.this);
                long id = dbUsuarios.eliminarUsuario(idRegistro.getText().toString());

                if(id > 0){
                    Toast.makeText(Eliminar_Registro.this, "REGISTRO ELIMINADO", Toast.LENGTH_LONG).show();
                    limpliar();
                }else{
                    Toast.makeText(Eliminar_Registro.this, "ERROR DE ELIMINACION", Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void limpliar(){
        idRegistro.setText("");
    }


}