package com.example.registropersonas.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.R;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.Instruccion;
import com.example.registropersonas.presentador.Presentador;

public class CreaRegistro extends AppCompatActivity {

    public static final String MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA";
    public static final String MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA";
    EditText editTextIdentificacion, editTextNombres, editTextApellidos, editTextTelefono, editTextTemperatura; // rol;
    String rol="PARTNER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_registro);
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

            Persona persona = new Persona(identificacion, nombres, apellidos,telefono,temperatura,rol);
            Presentador presentador = new Presentador(persona);
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_REGISTRAR_PERSONA_PRESIONADO");
            instruccion =presentador.solicitud(instruccion, CreaRegistro.this);
            if(instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_EXITOSA)){
                Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
                editTextIdentificacion.setText("");
                editTextNombres.setText("");
                editTextApellidos.setText("");
                editTextTelefono.setText("");
                editTextTemperatura.setText("");
            } else if (instruccion.getTipoInstruccion().equals(MOSTRAR_SOLICITUD_FALLIDA)){
                Toast.makeText(this, "No es posible realizar el registro", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}