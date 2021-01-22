package com.example.registropersonas.presentador;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.vista.RegistroPersona;
import com.example.registropersonas.vista.SeleccionAccion;

public class Presentador extends AppCompatActivity {

    private String identificacion, nombres, apellidos, telefono, temperatura, rol;
    public static final String SOLICITUD_REGISTRAR = "REGISTRAR";
    public static final String SOLICITUD_ACTUALIZAR = "ACTUALIZAR";
    public static final String SOLICITUD_CONSULTAR = "CONSULTAR";
    public static final String SOLICITUD_ELIMINAR = "ELIMINAR";
    public static final String SOLICITUD_EXITOSA = "SOLICITUD_EXITOSA";
    public static final String SOLICITUD_FALLIDA = "SOLICITUD_FALLIDA";

    public Presentador(){

    }

    public Presentador(String identificacion, String nombres, String apellidos,
                       String telefono, String temperatura, String rol){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.temperatura = temperatura;
        this.rol = rol;
    }

    public Instruccion solicitud(Instruccion instruccion){
        if(instruccion.getTipoInstruccion().equals("BOTON_LOGIN_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            SeleccionAccion seleccionAccion = new SeleccionAccion();
            instruccion.setClaseSiguente(seleccionAccion.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("IMAGE_BUTTON_REGISTRAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("CAMBIAR_PANTALLA");
            RegistroPersona registroPersona = new RegistroPersona();
            instruccion.setClaseSiguente(registroPersona.getClass());
        }
        else if(instruccion.getTipoInstruccion().equals("BOTON_REGISTRAR_PERSONA_PRESIONADO")){
            instruccion.setTipoInstruccion("RECIBIR_OBJETO_PERSONA");
        }
        else if(instruccion.getTipoInstruccion().equals("OBJETO_PERSONA_ENTREGADO")){
             String resultadoInstruccion = instruccion.registraEnBD();
             instruccion.setTipoInstruccion(resultadoInstruccion);
        }
        return instruccion;
    }
}
