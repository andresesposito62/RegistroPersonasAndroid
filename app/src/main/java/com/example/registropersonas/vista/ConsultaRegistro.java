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

    public static final String MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA";
    public static final String MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA";
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
        if(!identificacion.isEmpty()){
            Persona persona = new Persona();
            persona.setIdentificacion(identificacion);
            Presentador presentador = new Presentador(persona);
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_CONSULTAR_PERSONA_PRESIONADO");
            instruccion = presentador.solicitud(instruccion, ConsultaRegistro.this);

            if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_EXITOSA)){
                persona =  instruccion.obtenerObjetoPersona();
                editTextIdentificacion.setText(persona.getIdentificacion());
                editTextNombres.setText(persona.getNombres());
                editTextApellidos.setText(persona.getApellidos());
                editTextTelefono.setText(persona.getTelefono());
                editTextTemperatura.setText(persona.getTemperatura());
            }
            else if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_FALLIDA)){
                Toast.makeText(this, "No es posible consultar el registro", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show();
        }
    }
}