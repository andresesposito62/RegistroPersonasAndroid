package com.example.registropersonas.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.*;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.Instruccion;
import com.example.registropersonas.presentador.Presentador;

public class EliminaRegistro extends AppCompatActivity {
    public static final String MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA";
    public static final String MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA";
    EditText editTextIdentificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina_registro);
        editTextIdentificacion = (EditText)findViewById(R.id.editTextIEliminacionIdentificacion);
    }

    public void eliminar(View view){

        String identificacion = editTextIdentificacion.getText().toString().trim();

        if(!identificacion.isEmpty()){

            Persona persona = new Persona();
            persona.setIdentificacion(identificacion);
            Presentador presentador = new Presentador(persona);
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_ELIMINAR_PERSONA_PRESIONADO");
            instruccion = presentador.solicitud(instruccion, EliminaRegistro.this);
            if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_EXITOSA)){
                Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show();
                editTextIdentificacion.setText("");
            } else if (instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_FALLIDA)){
                Toast.makeText(this, "No es posible eliminar el registro", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debes diligenciar el número de identificación", Toast.LENGTH_SHORT).show();
        }
    }
}