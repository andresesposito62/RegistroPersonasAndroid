package com.example.registropersonas.presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.modelo.controlpersonal.ControlModelo;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;

public class Instruccion {

    private String tipoInstruccion;
    private Class claseSiguente;
    Persona persona;

    public Instruccion(){}

    public Instruccion(String tipoInstruccion){
        this.tipoInstruccion = tipoInstruccion;
    }

    public Persona recibirObjetoPersona(Persona persona){
        this.persona = persona;
        return persona;
    }

    public Persona obtenerObjetoPersona(){
        return persona;
    }

    public String getTipoInstruccion() {
        return tipoInstruccion;
    }

    public void setTipoInstruccion(String tipoInstruccion) {this.tipoInstruccion = tipoInstruccion;}

    public Class getClaseSiguente() {
        return claseSiguente;
    }

    public void setClaseSiguente(Class claseSiguente) {
        this.claseSiguente = claseSiguente;
    }


}
