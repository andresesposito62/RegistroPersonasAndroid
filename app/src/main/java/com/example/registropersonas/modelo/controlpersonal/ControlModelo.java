package com.example.registropersonas.modelo.controlpersonal;

import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.presentador.*;

public class ControlModelo {

   private String identificacion, nombres, apellidos, telefono, temperatura, rol;

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

   public String[] SolicitudBaseDeDatos(String solicitud){

       Persona persona = new Persona(identificacion,nombres,apellidos,telefono,temperatura,rol);
       GestionBaseDeDatos gestionBaseDeDatos = new GestionBaseDeDatos(persona);
       String[] vectorRespuesta = null;


       if(solicitud.equals("REGISTRAR")){
          boolean status= gestionBaseDeDatos.Registrar();
          if (status){
              vectorRespuesta[0] = "REGISTRO EXITOSO";
          }else {
              vectorRespuesta[0] = "REGISTRO NO EXITOSO";
          }
       }
       else if(solicitud.equals("ACTUALIZAR")){
           boolean status= gestionBaseDeDatos.Actualizar();
           if (status){
               vectorRespuesta[0] = "ACTUALIZACION EXITOSA";
           }else {
               vectorRespuesta[0] = "ACTUALIZACION NO EXITOSA";
           }
       }
       else if(solicitud.equals("ELIMINAR")){
           boolean status= gestionBaseDeDatos.Eliminar();
           if (status){
               vectorRespuesta[0] = "ACTUALIZACION EXITOSA";
           }else {
               vectorRespuesta[0] = "ACTUALIZACION NO EXITOSA";
           }
       }
       else if(solicitud.equals("CONSULTAR")){
           String vectorRespuesta2 [] = gestionBaseDeDatos.Consultar();
           if (!vectorRespuesta2.equals(null)){
               vectorRespuesta = vectorRespuesta2;
           }else {
               vectorRespuesta[0] = "CONSULTA NO EXITOSA";
           }
       }
       return vectorRespuesta;
   }


}
