package com.example.registropersonas.presentador;

import com.example.registropersonas.vista.SeleccionAccion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresentadorTest {
    Presentador presentador;
    SeleccionAccion seleccionAccion;

    @Before
    public void setUp() throws Exception {
        presentador = new Presentador();
        seleccionAccion = new SeleccionAccion();
    }

    @Test
    public void operacionNotNull(){
        assertNotNull(presentador);
    }

    @Test
    public void siguientePantalla() {
        assertEquals(seleccionAccion.getClass(),presentador.siguientePantalla("BOTON LOGIN"));
    }
}