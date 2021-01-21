package com.example.registropersonas.modelo.controlpersonal;

import com.example.registropersonas.modelo.domain.Persona;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlModeloTest {

    ControlModelo controlModelo;
    Persona persona;
    @Before
    public void setUp() throws Exception {
        controlModelo = new ControlModelo();
        persona = new Persona();
    }

    @Test
    public void operacionNotNull(){
        assertNotNull(controlModelo);
    }

    @Test
    public void solicitudBaseDeDatos() {

        //assertEquals(persona,controlModelo.SolicitudBaseDeDatos("REGISTRAR"));
        //assertEquals(persona,controlModelo.SolicitudBaseDeDatos("ACTUALIZAR"));
        assertEquals(persona,controlModelo.SolicitudBaseDeDatos("CONSULTAR"));
    }
}