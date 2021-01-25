package com.example.registropersonas.presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.modelo.datos.PersonaDaoImplementacion;
import com.example.registropersonas.modelo.domain.Persona;
import com.example.registropersonas.vista.ConsultaRegistro;
import com.example.registropersonas.vista.CreaRegistro;
import com.example.registropersonas.vista.SeleccionAccion;

public class Presentador extends AppCompatActivity {

    private String identificacion, nombres, apellidos, telefono, temperatura, rol;
    public static final String SOLICITUD_REGISTRAR = "REGISTRAR";
    public static final String SOLICITUD_ACTUALIZAR = "ACTUALIZAR";
    public static final String SOLICITUD_CONSULTAR = "CONSULTAR";
    public static final String SOLICITUD_ELIMINAR = "ELIMINAR";
    public static final String SOLICITUD_EXITOSA = "SOLICITUD_EXITOSA";
    public static final String SOLICITUD_FALLIDA = "SOLICITUD_FALLIDA";
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
            instruccion.setTipoInstruccion("RECIBIR_OBJETO_PERSONA");
        }
        else if(instruccion.getTipoInstruccion().equals("OBJETO_PERSONA_ENTREGADO")){
             String resultadoInstruccion = instruccion.registraEnBD(context);
             instruccion.setTipoInstruccion(resultadoInstruccion);
        }
        else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_CONSULTAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            ConsultaRegistro consultaRegistro = new ConsultaRegistro();
            instruccion.setClaseSiguente(consultaRegistro.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_CONSULTAR_PERSONA_PRESIONADO")){
            PersonaDaoImplementacion personaDaoImplementacion = new PersonaDaoImplementacion();
            persona = personaDaoImplementacion.consultarPersona(persona, context);
            instruccion.recibirObjetoPersona(persona);
        }

        return instruccion;
    }
}
