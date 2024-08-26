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

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre, txtEdad, txtPaterno, txtMaterno, txtCurp, txtGenero;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtPaterno = findViewById(R.id.txtPaterno);
        txtMaterno = findViewById(R.id.txtMaterno);
        txtGenero  = findViewById(R.id.txtGenero);
        txtCurp = findViewById(R.id.txtCurp);
        txtEdad = findViewById(R.id.txtEdad);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbUsuarios dbUsuarios = new DbUsuarios(RegistroActivity.this);
                long id = dbUsuarios.registroUsuario(txtNombre.getText().toString(),txtPaterno.getText().toString()
                        ,txtMaterno.getText().toString(), txtGenero.getText().toString(),txtCurp.getText().toString(),txtEdad.getText().toString());

                if(id > 0){
                    Toast.makeText(RegistroActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpliar();
                }else{
                    Toast.makeText(RegistroActivity.this, "ERROR DE REGISTRO", Toast.LENGTH_LONG).show();
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
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtGenero.setText("");
        txtCurp.setText("");
        txtEdad.setText("");
    }

}