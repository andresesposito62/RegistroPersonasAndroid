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

   public ControlModelo(Persona persona){
       this.identificacion = persona.getIdentificacion();
       this.nombres = persona.getNombres();
       this.apellidos = persona.getApellidos();
       this.telefono = persona.getTelefono();
       this.temperatura = persona.getTemperatura();
       this.rol = persona.getRol();
   }

   public Persona SolicitudBaseDeDatos(String solicitud){

       InterfazPersonaDao personaDao = new PersonaDaoImplementacion();
       Persona persona = new Persona(identificacion,nombres,apellidos,telefono,temperatura,rol);

       if(solicitud.equals(SOLICITUD_REGISTRAR)){
           try {
               if(personaDao.registrarPersona(persona)){
                   //Registro Exitoso
                   persona.setIdentificacion(SOLICITUD_EXITOSA);
               }else{
                   //Registro NO Exitoso
                   persona.setIdentificacion(SOLICITUD_FALLIDA);
               }
           } catch (Exception e) {
               e.printStackTrace();
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

           Persona personaResult = personaDao.consultarPersona(persona);
           if (personaResult.getIdentificacion()==""){
               personaResult.setIdentificacion(SOLICITUD_FALLIDA);
           }
           persona = personaResult;
       }
       return persona;
   }
}
