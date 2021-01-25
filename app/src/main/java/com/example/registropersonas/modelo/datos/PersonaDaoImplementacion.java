package com.example.registropersonas.modelo.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.modelo.domain.*;
import com.example.registropersonas.presentador.Instruccion;


public class PersonaDaoImplementacion implements InterfazPersonaDao{

    public PersonaDaoImplementacion(){

    }


    @Override
    public long registrarPersona(Persona persona, Context context) {
        long registrosAfectados = 0;
        //Metodo Registrar
        String identificacion = persona.getIdentificacion();
        String nombres = persona.getNombres();
        String apellidos =  persona.getApellidos();
        String telefono =  persona.getTelefono();
        String temperatura =  persona.getTemperatura();
        String rol = persona.getRol();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion9", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(persona !=null){
            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("nombres",nombres);
            registro.put("apellidos",apellidos);
            registro.put("telefono",telefono);
            registro.put("temperatura",temperatura);
            registro.put("rol",rol);
            registrosAfectados = BaseDeDatos.insert("personas", null, registro);
            BaseDeDatos.close();
        }
        return registrosAfectados;
    }


    @Override
    public Persona consultarPersona(Persona persona, Context context){

        String identificacion = persona.getIdentificacion();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion9", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!identificacion.isEmpty()){

            Cursor fila = BaseDeDatos.rawQuery
                    ("select nombres, apellidos, telefono, temperatura, rol from personas where identificacion=" + identificacion, null);
            if(fila.moveToFirst()){

                persona.setNombres(fila.getString(0));
                persona.setApellidos(fila.getString(1));
                persona.setTelefono(fila.getString(2));
                persona.setTemperatura(fila.getString(3));
                persona.setRol(fila.getString(4));
                persona.setIdentificacion(identificacion);
                //consulta exitosa
                BaseDeDatos.close();
            }else{
                //consulta no exitosa
                persona.setNombres("");
                persona.setApellidos("");
                persona.setTelefono("");
                persona.setTemperatura("");
                persona.setRol("");
                persona.setIdentificacion("");
                BaseDeDatos.close();
            }
        }else{
            //consulta no exitosa
            persona.setNombres("");
            persona.setApellidos("");
            persona.setTelefono("");
            persona.setTemperatura("");
            persona.setRol("");
            persona.setIdentificacion("");
        }
        return persona;
    }

    @Override
    public long eliminarPersona(Persona persona, Context context){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion9", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        long cantidad = 0;
        String identificacion = persona.getIdentificacion();

        if(!identificacion.isEmpty()){
            cantidad = BaseDeDatos.delete("personas","identificacion=" + identificacion,null);
            BaseDeDatos.close();
        }
        return  cantidad;
    }

    @Override
    public long actualizarPersona(Persona persona, Context context){
        long registrosAfectados = 0;
        //Metodo Registrar
        String identificacion = persona.getIdentificacion();
        String nombres = persona.getNombres();
        String apellidos =  persona.getApellidos();
        String telefono =  persona.getTelefono();
        String temperatura =  persona.getTemperatura();
        String rol = persona.getRol();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion9", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(persona !=null){
            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("nombres",nombres);
            registro.put("apellidos",apellidos);
            registro.put("telefono",telefono);
            registro.put("temperatura",temperatura);
            registro.put("rol",rol);
            registrosAfectados = BaseDeDatos.update("personas", registro, "identificacion=" + identificacion, null);
            BaseDeDatos.close();
        }
        return registrosAfectados;
    }


}
