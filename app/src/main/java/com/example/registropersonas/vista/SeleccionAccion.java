package com.example.registropersonas.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.*;
import com.example.registropersonas.presentador.Presentador;

public class SeleccionAccion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_accion);
    }

    public void registrarPersona(View view){

            Presentador presentador = new Presentador();
            Class siguientePantalla= presentador.siguientePantalla("BOTON REGISTRAR PERSONA");
            Intent intent = new Intent(this, siguientePantalla);
            startActivity(intent);
    }

    public void consultarPersona(View view){

        Presentador presentador = new Presentador();
        Class siguientePantalla= presentador.siguientePantalla("BOTON CONSULTAR PERSONA");
        Intent intent = new Intent(this, siguientePantalla);
        startActivity(intent);
    }

    public void actualizarPersona(View view){

        Presentador presentador = new Presentador();
        Class siguientePantalla= presentador.siguientePantalla("BOTON ACTUALIZAR PERSONA");
        Intent intent = new Intent(this, siguientePantalla);
        startActivity(intent);
    }

    public void eliminarPersona(View view){

        Presentador presentador = new Presentador();
        Class siguientePantalla= presentador.siguientePantalla("BOTON ELIMINAR PERSONA");
        Intent intent = new Intent(this, siguientePantalla);
        startActivity(intent);
    }

    /*
    public void consultarRegistro(View view){
        Presentador presentador = new Presentador("BOTON CONSULTAR",this);
    }

    public void actualizarRegistro(View view){
        Presentador presentador = new Presentador("BOTON ACTUALIZAR",this);
    }

    public void eliminarRegistro(View view){
        Presentador presentador = new Presentador("BOTON ELIMINAR",this);
    }*/
}