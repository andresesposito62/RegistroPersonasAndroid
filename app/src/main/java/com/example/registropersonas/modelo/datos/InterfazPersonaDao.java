package com.example.registropersonas.modelo.datos;

import android.content.Context;

import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.modelo.datos.*;

public interface InterfazPersonaDao {
    public boolean registrarPersona(Persona persona) throws Exception;
    public boolean actualizarPersona(Persona persona);
    public boolean eliminarPersona(Persona persona);
    public Persona consultarPersona(Persona persona);
}
