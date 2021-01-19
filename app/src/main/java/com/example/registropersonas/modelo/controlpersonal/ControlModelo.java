package com.example.registropersonas.modelo.controlpersonal;

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

   public ControlModelo(String identificacion, String nombres, String apellidos,
                        String telefono, String temperatura, String rol){
       this.identificacion = identificacion;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.temperatura = temperatura;
       this.rol = rol;
   }

   public Persona SolicitudBaseDeDatos(String solicitud){

       InterfazPersonaDao personaDao = new PersonaDaoImplementacion();
       Persona persona = new Persona(identificacion,nombres,apellidos,telefono,temperatura,rol);

       if(solicitud.equals(SOLICITUD_REGISTRAR)){
           if(personaDao.registrarPersona(persona)){
               //Registro Exitoso
               persona.setIdentificacion(SOLICITUD_EXITOSA);
           }else{
               //Registro NO Exitoso
               persona.setIdentificacion(SOLICITUD_FALLIDA);
           }
       }
       else if(solicitud.equals(SOLICITUD_ACTUALIZAR)){
           if(personaDao.actualizarPersona(persona)){
               //Registro Exitoso
               persona.setIdentificacion(SOLICITUD_EXITOSA);
           }else{
               //Registro NO Exitoso
               persona.setIdentificacion(SOLICITUD_FALLIDA);
           }
       }
       else if(solicitud.equals(SOLICITUD_ELIMINAR)){
           if(personaDao.eliminarPersona(persona)){
               //Registro Exitoso
               persona.setIdentificacion(SOLICITUD_EXITOSA);
           }else{
               //Registro NO Exitoso
               persona.setIdentificacion(SOLICITUD_FALLIDA);
           }
       }
       else if (solicitud.equals(SOLICITUD_CONSULTAR)){
           Persona persona1 = personaDao.consultarPersona(persona);
           persona = persona1;
           if (persona1.getIdentificacion().equals("")){
               persona.setIdentificacion(SOLICITUD_FALLIDA);
           }
       }
       return persona;
   }
}
