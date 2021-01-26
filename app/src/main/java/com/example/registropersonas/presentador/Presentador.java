package com.example.registropersonas.presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.vista.ActualizaRegistro;
import com.example.registropersonas.vista.ConsultaRegistro;
import com.example.registropersonas.vista.CreaRegistro;
import com.example.registropersonas.vista.EliminaRegistro;
import com.example.registropersonas.vista.SeleccionAccion;

public class Presentador extends AppCompatActivity {

    public static final String MOSTRAR_SOLICITUD_EXITOSA = "MOSTRAR_SOLICITUD_EXITOSA";
    public static final String MOSTRAR_SOLICITUD_FALLIDA = "MOSTRAR_SOLICITUD_FALLIDA";
    Persona persona;

    public Presentador(){

    }

    public Presentador(Persona persona){
        this.persona = persona;
    }

    public Instruccion solicitud(Instruccion instruccion, Context context){
        if(instruccion.getTipoInstruccion().equals("BOTON_LOGIN_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            SeleccionAccion seleccionAccion = new SeleccionAccion();
            instruccion.setClaseSiguente(seleccionAccion.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_REGISTRAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            CreaRegistro creaRegistro = new CreaRegistro();
            instruccion.setClaseSiguente(creaRegistro.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_REGISTRAR_PERSONA_PRESIONADO")){
            PersonaDaoImplementacion personaDaoImplementacion = new PersonaDaoImplementacion();
            long resultadoInstruccion = personaDaoImplementacion.registrarPersona(persona, context);
            if(resultadoInstruccion != -1){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA);
            }else {
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA);
            }
        }
        else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_CONSULTAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            ConsultaRegistro consultaRegistro = new ConsultaRegistro();
            instruccion.setClaseSiguente(consultaRegistro.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_CONSULTAR_PERSONA_PRESIONADO")){
            PersonaDaoImplementacion personaDaoImplementacion = new PersonaDaoImplementacion();
            persona = personaDaoImplementacion.consultarPersona(persona, context);
            if(!persona.getIdentificacion().equals("")){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA);
                instruccion.recibirObjetoPersona(persona);
            }else{
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA);
            }
        }
        else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_ELIMINAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            EliminaRegistro eliminaRegistro = new EliminaRegistro();
            instruccion.setClaseSiguente(eliminaRegistro.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_ELIMINAR_PERSONA_PRESIONADO")){
            PersonaDaoImplementacion personaDaoImplementacion = new PersonaDaoImplementacion();
            long resultadoInstruccion = personaDaoImplementacion.eliminarPersona(persona, context);
            if(resultadoInstruccion != -1){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA);
            }else {
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA);
            }
        } else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_ACTUALIZAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            ActualizaRegistro actualizaRegistro = new ActualizaRegistro();
            instruccion.setClaseSiguente(actualizaRegistro.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_ACTUALIZAR_PERSONA_PRESIONADO")){
            PersonaDaoImplementacion personaDaoImplementacion = new PersonaDaoImplementacion();
            long resultadoInstruccion = personaDaoImplementacion.actualizarPersona(persona, context);
            if(resultadoInstruccion != -1){
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_EXITOSA);
            }else {
                instruccion.setTipoInstruccion(MOSTRAR_SOLICITUD_FALLIDA);
            }
        }
        return instruccion;
    }
}
