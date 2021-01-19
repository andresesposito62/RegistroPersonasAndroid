package com.example.registropersonas.modelo.domain;

public class Persona {

    private String identificacion, nombres, apellidos, telefono, temperatura, rol;

    public Persona(){

    }

    public Persona(String identificacion, String nombres, String apellidos,
                   String telefono,String temperatura, String rol){
         this.identificacion = identificacion;
         this.nombres = nombres;
         this.apellidos = apellidos;
         this.telefono = telefono;
         this.temperatura = temperatura;
         this.rol = rol;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "identificacion='" + identificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", temperatura=" + temperatura +
                ", rol='" + rol + '\'' +
                '}';
    }
}
