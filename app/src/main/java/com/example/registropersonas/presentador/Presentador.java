package com.example.registropersonas.presentador;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.modelo.controlpersonal.ControlModelo;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.vista.ActualizaPersona;
import com.example.registropersonas.vista.ConsultaRegistro;
import com.example.registropersonas.vista.EliminaRegistro;
import com.example.registropersonas.vista.RegistroPersona;
import com.example.registropersonas.vista.SeleccionAccion;

public class Presentador extends AppCompatActivity {


    public Presentador(){

    }

    public Class siguientePantalla(String botonPresionado){
        Presentador presentador = new Presentador();
        Class sigPantalla = presentador.getClass();

        if(botonPresionado.equals("BOTON LOGIN")){
            SeleccionAccion seleccionAccion = new SeleccionAccion();
            sigPantalla = seleccionAccion.getClass();
        }

        if(botonPresionado.equals("BOTON REGISTRAR PERSONA")){
            RegistroPersona registroPersona = new RegistroPersona();
            sigPantalla = registroPersona.getClass();
        }
        if(botonPresionado.equals("BOTON ACTUALIZAR PERSONA")){
            ActualizaPersona actualizaRegistro = new ActualizaPersona();
            sigPantalla = actualizaRegistro.getClass();
        }
        if(botonPresionado.equals("BOTON ELIMINAR PERSONA")){
            EliminaRegistro eliminaRegistro = new EliminaRegistro();
            sigPantalla = eliminaRegistro.getClass();
        }
        if(botonPresionado.equals("BOTON CONSULTAR PERSONA")){
            ConsultaRegistro consultaRegistro = new ConsultaRegistro();
            sigPantalla = consultaRegistro.getClass();
        }
        return sigPantalla;
    }


}
