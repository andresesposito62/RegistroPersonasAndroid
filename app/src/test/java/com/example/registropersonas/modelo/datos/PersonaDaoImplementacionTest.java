package com.example.registropersonas.modelo.datos;

import com.example.registropersonas.modelo.domain.Persona;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonaDaoImplementacionTest {

    private PersonaDaoImplementacion personaDaoImplementacion;
    Persona persona;

    @Before
    public void setUp() throws Exception {
       personaDaoImplementacion = new PersonaDaoImplementacion();
       persona = new Persona("123456","andres","esposito"
               ,"3106002979","36","partner");
    }

    @Test
    public void operacionNotNull(){
        assertNotNull(personaDaoImplementacion);
    }

     @Test
    public void registrarPersona(){
        assertEquals(true,personaDaoImplementacion.registrarPersona(persona));
    }

    /*
    @Test
    public void consultarPersona(){
        assertEquals(persona2,personaDaoImplementacion.consultarPersona(persona2));
    }*/

    @Test
    public void actualizarPersona(){
        assertEquals(true,personaDaoImplementacion.actualizarPersona(persona));
    }

    @Test
    public void eliminarPersona(){
        assertEquals(true,personaDaoImplementacion.eliminarPersona(persona));
    }

}