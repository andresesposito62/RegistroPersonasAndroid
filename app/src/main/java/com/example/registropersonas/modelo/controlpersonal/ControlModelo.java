package com.example.registropersonas.modelo.controlpersonal;

import android.content.Context;

import com.example.registropersonas.modelo.datos.InterfazPersonaDao;
import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.*;

public class ControlModelo {

    private String identificacion, nombres, apellidos, telefono, temperatura, rol;
    public static final String SOLICITUD_REGISTRAR = "REGISTRAR";
    public static final String SOLICITUD_ACTUALIZAR = "ACTUALIZAR";
    public static final String SOLICITUD_CONSULTAR = "CONSULTAR";
    public static final String SOLICITUD_ELIMINAR = "ELIMINAR";
    public static final String SOLICITUD_EXITOSA = "SOLICITUD_EXITOSA";
    public static final String SOLICITUD_FALLIDA = "SOLICITUD_FALLIDA";

    public ControlModelo(){

    }

    public ControlModelo(Persona persona){
        this.identificacion = persona.getIdentificacion();
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.telefono = persona.getTelefono();
        this.temperatura = persona.getTemperatura();
        this.rol = persona.getRol();
    }

    public Persona SolicitudBaseDeDatos(String solicitud, Context context){

        //InterfazPersonaDao personaDao = new PersonaDaoImplementacion();
        PersonaDaoImplementacion personaDao = new PersonaDaoImplementacion();
        Persona persona = new Persona(identificacion,nombres,apellidos,telefono,temperatura,rol);

        if(solicitud.equals(SOLICITUD_REGISTRAR)){
            long registrosAfectados = personaDao.registrarPersona(persona, context);
            persona.setIdentificacion(String.valueOf(registrosAfectados));
            /*if(registrosAfectados != -1){
                //Registro Exitoso
                persona.setIdentificacion("Registro Exitoso");
            }else{
                //Registro NO Exitoso
                persona.setIdentificacion("Registro Fallido");
            }*/
        }
        else if(solicitud.equals(SOLICITUD_ACTUALIZAR)){
            long registrosAfectados = personaDao.actualizarPersona(persona, context);
            persona.setIdentificacion(String.valueOf(registrosAfectados));
            /*if(registrosAfectados != -1){
                //Registro Exitoso
                persona.setIdentificacion(SOLICITUD_EXITOSA);
            }else{
                //Registro NO Exitoso
                persona.setIdentificacion(SOLICITUD_FALLIDA);
            }*/
        }
        else if(solicitud.equals(SOLICITUD_ELIMINAR)){
            long registrosAfectados = personaDao.eliminarPersona(persona, context);
            if(registrosAfectados != -1){
                //Registro Exitoso
                persona.setIdentificacion("Registro eliminado exitosamente");
            }else{
                //Registro NO Exitoso
                persona.setIdentificacion("Registro no eliminado");
            }
        }
        else if (solicitud.equals(SOLICITUD_CONSULTAR)){

            persona = personaDao.consultarPersona(persona, context);
            //persona.setIdentificacion(String.valueOf(registrosAfectados));
            /*if (registrosAfectados != -1){
                persona.setIdentificacion(SOLICITUD_FALLIDA);
            }else{
                //Registro NO Exitoso
                persona.setIdentificacion(SOLICITUD_FALLIDA);
            }*/
        }
        return persona;
    }
}