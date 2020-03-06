package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

EditText edtDireccion, edtNombre,profesional,edtFecha;
Spinner documento;
    RadioButton rdMujer,rdHomnbe;
    Button btnGuardar,btnFecha;

    String doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDireccion = (EditText)findViewById(R.id.edi_direcion);
        edtNombre = (EditText)findViewById(R.id.edi_nombre);
        profesional = (EditText)findViewById(R.id.edi_profesional);
        rdMujer = (RadioButton)findViewById(R.id.rdMujer);
        rdHomnbe = (RadioButton)findViewById(R.id.rdHombre);
        documento =(Spinner)findViewById(R.id.spinner_selecion_doc);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnFecha = (Button)findViewById(R.id.btnFecha);
        edtFecha = (EditText)findViewById(R.id.edi_fecha);

        btnFecha.setOnClickListener(this);
        documento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String direccion = edtDireccion.getText().toString();
                String nombre = edtNombre.getText().toString();
                String hombre = rdHomnbe.getText().toString();
                String mujer = rdMujer.getText().toString();
                String sexo;
                if (!direccion.isEmpty() && !nombre.isEmpty()){
                    if (rdMujer.isChecked() ){
                        Intent intent = new Intent(MainActivity.this, Registro.class);
                        intent.putExtra("nombre",edtNombre.getText().toString());
                        intent.putExtra("direccion",edtDireccion.getText().toString());
                        intent.putExtra("profesion",profesional.getText().toString());
                        intent.putExtra("sexo",rdMujer.getText().toString());
                        intent.putExtra("documento",documento.getSelectedItem().toString());
                        intent.putExtra("fecha",edtFecha.getText().toString());
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(MainActivity.this, Registro.class);
                        intent.putExtra("nombre",edtNombre.getText().toString());
                        intent.putExtra("direccion",edtDireccion.getText().toString());
                        intent.putExtra("profesion",profesional.getText().toString());
                        intent.putExtra("sexo",rdHomnbe.getText().toString());
                        intent.putExtra("documento",documento.getSelectedItem().toString());
                        intent.putExtra("fecha",edtFecha.getText().toString());
                        startActivity(intent);
                    }

                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view == btnFecha) {
            final Calendar calendario = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                    Calendar calendarResultado = Calendar.getInstance();
                    calendarResultado.set(Calendar.YEAR, year);
                    calendarResultado.set(Calendar.MONTH, mes);
                    calendarResultado.set(Calendar.DAY_OF_MONTH, dia);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    Date date = calendarResultado.getTime();
                    String fechaDeNacimientoTexto = simpleDateFormat.format(date).toString();
                    edtFecha.setText(fechaDeNacimientoTexto);
                }
            }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();


        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        doc =(String)documento.toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
