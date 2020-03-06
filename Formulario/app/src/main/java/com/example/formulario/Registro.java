package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    public TextView txtNombre,txtFecha,txtHombre,txtDocumento,txtDireccion,txtProfesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = (TextView)findViewById(R.id.txt_titulo_list);
        txtDocumento = (TextView)findViewById(R.id.txt_direccion);
        txtHombre = (TextView)findViewById(R.id.txt_descripcion_list);
        txtDireccion = (TextView)findViewById(R.id.txtDireccion);
        txtProfesion = (TextView)findViewById(R.id.txt_profesion);
        txtFecha = (TextView)findViewById(R.id.txt_fecha);

        final String nombre = getIntent().getStringExtra("nombre");
        final String documento = getIntent().getStringExtra("documento");
        final String profesion = getIntent().getStringExtra("profesion");
        final String sexo = getIntent().getStringExtra("sexo");
        final String direccion = getIntent().getStringExtra("direccion");

        final String fecha = getIntent().getStringExtra("fecha");

    txtNombre.setText(nombre);
        txtFecha.setText(fecha);
        txtHombre.setText(sexo);
        txtDocumento.setText(documento);
txtDireccion.setText(direccion);
        txtProfesion.setText(profesion);
    }
}
