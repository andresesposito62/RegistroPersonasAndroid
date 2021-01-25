package com.example.registropersonas.vista;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.*;
import com.example.registropersonas.modelo.datos.AdminSQLiteOpenHelper;
import com.example.registropersonas.presentador.Instruccion;
import com.example.registropersonas.presentador.Presentador;

public class SeleccionAccion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_accion);
    }

    public void registrarPersona(View view){

        Presentador presentador = new Presentador();
        Instruccion instruccion = new Instruccion();
        instruccion.setTipoInstruccion("IMAGE_BUTTON_REGISTRAR_PERSONA_PRESIONADO");
        instruccion = presentador.solicitud(instruccion, this);
        if (instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            Intent intent = new Intent(this, instruccion.getClaseSiguente());
            startActivity(intent);
        }
    }

    public void consultarPersona(View view){
        Presentador presentador = new Presentador();
        Instruccion instruccion = new Instruccion();
        instruccion.setTipoInstruccion("IMAGE_BUTTON_CONSULTAR_PERSONA_PRESIONADO");
        instruccion = presentador.solicitud(instruccion, this);
        if (instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            Intent intent = new Intent(this, instruccion.getClaseSiguente());
            startActivity(intent);
        }
    }

    public void actualizarPersona(View view){
        Presentador presentador = new Presentador();
        Instruccion instruccion = new Instruccion();
        instruccion.setTipoInstruccion("IMAGE_BUTTON_ACTUALIZAR_PERSONA_PRESIONADO");
        instruccion = presentador.solicitud(instruccion, this);
        if (instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            Intent intent = new Intent(this, instruccion.getClaseSiguente());
            startActivity(intent);
        }
    }

    public void eliminarPersona(View view){
        Presentador presentador = new Presentador();
        Instruccion instruccion = new Instruccion();
        instruccion.setTipoInstruccion("IMAGE_BUTTON_ELIMINAR_PERSONA_PRESIONADO");
        instruccion = presentador.solicitud(instruccion, this);
        if (instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
            Intent intent = new Intent(this, instruccion.getClaseSiguente());
            startActivity(intent);
        }
    }
}