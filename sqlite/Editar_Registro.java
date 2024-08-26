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

public class Editar_Registro extends AppCompatActivity {

    EditText idID, edNombre, edPaterno, edMaterno, edCurp, edGenero, edEdad;
    Button btnEditar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_registro);

        idID = findViewById(R.id.id_ID);
        edNombre = findViewById(R.id.nombreID);
        edPaterno = findViewById(R.id.paternoID);
        edMaterno = findViewById(R.id.maternoID);
        edCurp = findViewById(R.id.curpID);
        edGenero = findViewById(R.id.generoID);
        edEdad = findViewById(R.id.edadID);
        btnEditar = findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbUsuarios dbUsuarios = new DbUsuarios(Editar_Registro.this);
                long id = dbUsuarios.editarUsuario(idID.getText().toString(),edNombre.getText().toString(),edPaterno.getText().toString()
                        ,edMaterno.getText().toString(), edGenero.getText().toString(),edCurp.getText().toString(),edEdad.getText().toString());

                if(id > 0){
                    Toast.makeText(Editar_Registro.this, "REGISTRO EDITADO", Toast.LENGTH_LONG).show();
                    limpliar();
                }else{
                    Toast.makeText(Editar_Registro.this, "ERROR DE EDICION", Toast.LENGTH_LONG).show();
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
        idID.setText("");
        edNombre.setText("");
        edPaterno.setText("");
        edMaterno.setText("");
        edGenero.setText("");
        edCurp.setText("");
        edEdad.setText("");
    }


}