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

    private String identificacion, nombres, apellidos, telefono, temperatura, rol;
    public static final String SOLICITUD_REGISTRAR = "REGISTRAR";
    public static final String SOLICITUD_ACTUALIZAR = "ACTUALIZAR";
    public static final String SOLICITUD_CONSULTAR = "CONSULTAR";
    public static final String SOLICITUD_ELIMINAR = "ELIMINAR";
    public static final String SOLICITUD_EXITOSA = "SOLICITUD_EXITOSA";
    public static final String SOLICITUD_FALLIDA = "SOLICITUD_FALLIDA";

    public Presentador(){

    }

    public Presentador(String identificacion, String nombres, String apellidos,
                       String telefono, String temperatura, String rol){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.temperatura = temperatura;
        this.rol = rol;
    }

    public Class siguientePantalla(String botonPresionado){

        Class sigPantalla = this.getClass();

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
        if(botonPresionado.equals("BOTON REALIZAR REGISTRO")){
            RegistroPersona registroPersona = new RegistroPersona();
            sigPantalla = registroPersona.getClass();
        }
        return sigPantalla;
    }
}
