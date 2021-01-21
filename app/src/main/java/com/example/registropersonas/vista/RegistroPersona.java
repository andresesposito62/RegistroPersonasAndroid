package com.example.registropersonas.vista;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.security.identity.PersonalizationData;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.R;
import com.example.registropersonas.modelo.controlpersonal.ControlModelo;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.Presentador;

public class RegistroPersona extends AppCompatActivity {

    EditText editTextIdentificacion, editTextNombres, editTextApellidos, editTextTelefono, editTextTemperatura; // rol;
    String rol="PARTNER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_persona);
        editTextIdentificacion = (EditText)findViewById(R.id.editTextRegistroIdentificacion);
        editTextNombres = (EditText)findViewById(R.id.editTextRegistroNombres);
        editTextApellidos = (EditText)findViewById(R.id.editTextRegistroApellidos);
        editTextTelefono = (EditText)findViewById(R.id.editTextRegistroTelefono);
        editTextTemperatura = (EditText)findViewById(R.id.editTextRegistroTemperatura);

    }
    public void registrar(View view){

        String identificacion = editTextIdentificacion.getText().toString().trim();
        String nombres = editTextNombres.getText().toString().trim();
        String apellidos = editTextApellidos.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String temperatura = editTextTemperatura.getText().toString().trim();


        if(!identificacion.isEmpty() && !nombres.isEmpty()&& !apellidos.isEmpty()&& !telefono.isEmpty()
                && !temperatura.isEmpty()&& !rol.isEmpty()){

        }
        else{
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }



}