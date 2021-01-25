package com.example.registropersonas.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.*;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.Instruccion;
import com.example.registropersonas.presentador.Presentador;

public class ConsultaRegistro extends AppCompatActivity {

    EditText editTextIdentificacion, editTextNombres, editTextApellidos, editTextTelefono, editTextTemperatura; // rol;
    String rol="PARTNER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_registro);
        editTextIdentificacion = (EditText)findViewById(R.id.editTextConsultaIdentificacion);
        editTextNombres = (EditText)findViewById(R.id.editTextConsultaNombres);
        editTextApellidos = (EditText)findViewById(R.id.editTextConsultaApellidos);
        editTextTelefono = (EditText)findViewById(R.id.editTextConsultaTelefono);
        editTextTemperatura = (EditText)findViewById(R.id.editTextConsultaTemperatura);
    }

    public void consultar(View view){

        String identificacion = editTextIdentificacion.getText().toString().trim();
        String nombres = editTextNombres.getText().toString().trim();
        String apellidos = editTextApellidos.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String temperatura = editTextTemperatura.getText().toString().trim();

        if(!identificacion.isEmpty()){

            Persona persona = new Persona(identificacion, nombres, apellidos,telefono,temperatura,rol);

            Presentador presentador = new Presentador(persona);
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_CONSULTAR_PERSONA_PRESIONADO");
            instruccion = presentador.solicitud(instruccion, ConsultaRegistro.this);

            Toast.makeText(this, instruccion.obtenerObjetoPersona().toString(), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show();
        }
    }
}