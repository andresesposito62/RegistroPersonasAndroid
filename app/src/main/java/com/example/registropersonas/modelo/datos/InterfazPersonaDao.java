package com.example.registropersonas.modelo.datos;

import android.content.Context;

import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.modelo.datos.*;

public interface InterfazPersonaDao {
    public long registrarPersona(Persona persona, Context context);
    public long actualizarPersona(Persona persona, Context context);
    public long eliminarPersona(Persona persona, Context context);
    public Persona consultarPersona(Persona persona, Context context);
}
