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

public class ActualizaRegistro extends AppCompatActivity {

    EditText editTextIdentificacion, editTextNombres, editTextApellidos, editTextTelefono, editTextTemperatura; // rol;
    String rol="PARTNER";
    public static final String SOLICITUD_EXITOSA = "Solicitud Exitosa";
    public static final String SOLICITUD_FALLIDA = "Solicitud Fallida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza_registro);
        editTextIdentificacion = (EditText)findViewById(R.id.editTextIActualizacionIdentificacion);
        editTextNombres = (EditText)findViewById(R.id.editTextActualizacionNombres);
        editTextApellidos = (EditText)findViewById(R.id.editTextActualizacionApellidos);
        editTextTelefono = (EditText)findViewById(R.id.editTextActualizacionTelefono);
        editTextTemperatura = (EditText)findViewById(R.id.editTextActualizacionTemperatura);
    }
    public void actualizar(View view){

        String identificacion = editTextIdentificacion.getText().toString().trim();
        String nombres = editTextNombres.getText().toString().trim();
        String apellidos = editTextApellidos.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String temperatura = editTextTemperatura.getText().toString().trim();

        if(!identificacion.isEmpty() && !nombres.isEmpty()&& !apellidos.isEmpty()&& !telefono.isEmpty()
                && !temperatura.isEmpty()&& !rol.isEmpty()){

            Persona persona = new Persona(identificacion, nombres, apellidos,telefono,temperatura,rol);
            Presentador presentador = new Presentador(persona);
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_ACTUALIZAR_PERSONA_PRESIONADO");
            instruccion =presentador.solicitud(instruccion, ActualizaRegistro.this);
            if(instruccion.getTipoInstruccion().equals(SOLICITUD_EXITOSA)){
                Toast.makeText(this, SOLICITUD_EXITOSA, Toast.LENGTH_SHORT).show();
                editTextIdentificacion.setText("");
                editTextNombres.setText("");
                editTextApellidos.setText("");
                editTextTelefono.setText("");
                editTextTemperatura.setText("");
            } else{
                Toast.makeText(this, SOLICITUD_FALLIDA, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}