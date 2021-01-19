package com.example.registropersonas.modelo.datos;

import com.example.registropersonas.modelo.domain.Persona;

public interface InterfazPersonaDao {
    public boolean registrarPersona(Persona persona);
    public boolean actualizarPersona(Persona persona);
    public boolean eliminarPersona(Persona persona);
    public Persona consultarPersona(Persona persona);
}
