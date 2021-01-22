package com.example.registropersonas.presentador;

import android.content.Context;

import com.example.registropersonas.modelo.controlpersonal.ControlModelo;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;

public class Instruccion {

    private String tipoInstruccion, resultadoInstruccion;
    private Class claseSiguente;
    Persona persona;
    Context context;

    public Instruccion(){

    }

    public Instruccion(String tipoInstruccion){
        this.tipoInstruccion = tipoInstruccion;
    }

    public void recibirObjetoPersona(Persona persona){
        this.persona = persona;
    }

    public String registraEnBD(){
        ControlModelo controlModelo = new ControlModelo(persona);
        Persona persona2 = controlModelo.SolicitudBaseDeDatos("REGISTRAR");
        resultadoInstruccion =  persona2.getIdentificacion();
        return resultadoInstruccion;
    }


    public String getTipoInstruccion() {
        return tipoInstruccion;
    }

    public void setTipoInstruccion(String tipoInstruccion) {
        this.tipoInstruccion = tipoInstruccion;
    }

    public Class getClaseSiguente() {
        return claseSiguente;
    }

    public void setClaseSiguente(Class claseSiguente) {
        this.claseSiguente = claseSiguente;
    }

    public String getResultadoInstruccion() {
        return resultadoInstruccion;
    }

    public void setResultadoInstruccion(String resultadoInstruccion) {
        this.resultadoInstruccion = resultadoInstruccion;
    }
}
