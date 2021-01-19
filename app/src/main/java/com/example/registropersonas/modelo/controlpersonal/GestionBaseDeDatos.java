package com.example.registropersonas.modelo.controlpersonal;

import com.example.registropersonas.modelo.datos.PersonasSqlite;
import com.example.registropersonas.modelo.domain.Persona;

public class GestionBaseDeDatos {


    Persona persona;

    public GestionBaseDeDatos(){

    }

    public GestionBaseDeDatos(Persona persona){

        this.persona = persona;
    }

    public boolean Registrar(){
        PersonasSqlite personasSqlite = new PersonasSqlite();
        Persona personaResult = personasSqlite.registrar(persona.getIdentificacion(),persona.getNombres(),
                persona.getApellidos(),persona.getTelefono(), persona.getTemperatura(),persona.getRol());
        if(personaResult.equals(persona)){//Si el objeto recibido de la BD es el mismo recibido inicial
            return true;
        }else {
            return false;
        }
    }

    public boolean Actualizar(){
        PersonasSqlite personasSqlite = new PersonasSqlite();
        Persona personaResult = personasSqlite.actualizar(persona.getIdentificacion(),persona.getNombres(),
                persona.getApellidos(),persona.getTelefono(), persona.getTemperatura(),persona.getRol());
        if(personaResult.equals(persona)){//Si el objeto recibido de la BD es el mismo recibido inicial
            return true;
        }else {
            return false;
        }
    }

    public String [] Consultar(){ //retorna vector de strings
        String []vectorConsulta = null;
        PersonasSqlite personasSqlite = new PersonasSqlite();
        Persona personaResult = personasSqlite.consultar(persona.getIdentificacion());
        if(!personaResult.equals(persona)){//Si el objeto recibido de la BD es el distinto recibido inicial
            vectorConsulta[0] = personaResult.getIdentificacion();
            vectorConsulta[1] = personaResult.getNombres();
            vectorConsulta[2] = personaResult.getApellidos();
            vectorConsulta[3] = personaResult.getTelefono();
            vectorConsulta[4] = personaResult.getTemperatura();
            vectorConsulta[5] = personaResult.getRol();
            return vectorConsulta;
        }else {
            vectorConsulta = null;
            return vectorConsulta;
        }
    }

    public boolean Eliminar(){
        PersonasSqlite personasSqlite = new PersonasSqlite();
        Persona personaResult = personasSqlite.consultar(persona.getIdentificacion());
        if(!personaResult.equals(persona)){//Si el objeto recibido de la BD es el distinto recibido inicial
            return true;
        }else {
            return false;
        }
    }

}
