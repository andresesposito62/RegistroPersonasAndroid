package com.example.registropersonas.modelo.datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.registropersonas.modelo.datos.*;
import com.example.registropersonas.modelo.domain.*;


public class PersonasSqlite {

    public PersonasSqlite(){

    }

    public Persona registrar(String identificacion, String nombres, String apellidos,
                          String telefono, String temperatura, String rol){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Persona persona= new Persona();

        if(!identificacion.isEmpty() && !nombres.isEmpty() &&
                !apellidos.isEmpty() && !telefono.isEmpty() &&
                !temperatura.isEmpty()&&
                !rol.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("nombres",nombres);
            registro.put("apellidos",apellidos);
            registro.put("telefono",telefono);
            registro.put("temperatura",temperatura);
            registro.put("rol",rol);

            long cantidad = BaseDeDatos.insert("personas", null, registro);
            BaseDeDatos.close();
            if(cantidad == 1){
                persona.setIdentificacion(identificacion);
                persona.setNombres(nombres);
                persona.setApellidos(apellidos);
                persona.setTelefono(telefono);
                persona.setTemperatura(temperatura);
                persona.setRol(rol);
                //status = "Registro Exitoso";
            }else{
                //status = "Registro no exitoso";
                persona.setIdentificacion("");
                persona.setNombres("");
                persona.setApellidos("");
                persona.setTelefono("");
                persona.setTemperatura("");
                persona.setRol("");
            }

        }else{
            //status = "Debes diligenciar todos los campos";
            persona.setIdentificacion("");
            persona.setNombres("");
            persona.setApellidos("");
            persona.setTelefono("");
            persona.setTemperatura("");
            persona.setRol("");
        }
        return persona;
    }

    public Persona consultar(String identificacion){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Persona persona = new Persona();

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

                BaseDeDatos.close();
            }else{
                persona.setNombres("");
                persona.setApellidos("");
                persona.setTelefono("");
                persona.setTemperatura("");
                persona.setRol("");
                persona.setIdentificacion("");

                BaseDeDatos.close();
            }
        }else{
            persona.setNombres("");
            persona.setApellidos("");
            persona.setTelefono("");
            persona.setTemperatura("");
            persona.setRol("");
        }
        return persona;
    }

    public Persona eliminar(String identificacion){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Persona persona = consultar(identificacion);

        if(!identificacion.isEmpty()){
            int cantidad = BaseDeDatos.delete("visitantes","identificacion=" + identificacion,null);
            BaseDeDatos.close();

            if(cantidad == 1){
                //Toast.makeText(this, "Registro eliminado exitosamente", Toast.LENGTH_SHORT).show();
                persona.setNombres("");
                persona.setApellidos("");
                persona.setTelefono("");
                persona.setTemperatura("");
                persona.setRol("");
                persona.setIdentificacion("");
            }else{
                //Toast.makeText(this, "No existe el registro", Toast.LENGTH_SHORT).show();
            }
        }else{
            //Toast.makeText(this, "Debes introducir el numero de identificacion", Toast.LENGTH_SHORT).show();
        }
        return persona;
    }

    public Persona actualizar(String identificacion, String nombres, String apellidos,
                           String telefono, String temperatura, String rol){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Persona persona = new Persona();

        if(!identificacion.isEmpty() && !nombres.isEmpty() &&
                !apellidos.isEmpty() && !telefono.isEmpty() &&
                !temperatura.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("identificacion",identificacion);
            registro.put("nombres",nombres);
            registro.put("apellidos",apellidos);
            registro.put("telefono",telefono);
            registro.put("temperatura",temperatura);
            registro.put("rol",rol);

            int cantidad = BaseDeDatos.update("visitantes", registro, "identificacion=" + identificacion, null);
            BaseDeDatos.close();
            if(cantidad == 1){
                persona.setIdentificacion(identificacion);
                persona.setNombres(nombres);
                persona.setApellidos(apellidos);
                persona.setTelefono(telefono);
                persona.setTemperatura(temperatura);
                persona.setRol(rol);
                //Toast.makeText(this, "Registro modificado correctamente", Toast.LENGTH_SHORT).show();
            }else {
                persona.setNombres("");
                persona.setApellidos("");
                persona.setTelefono("");
                persona.setTemperatura("");
                persona.setRol("");
                persona.setIdentificacion("");
                //Toast.makeText(this, "El registro no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            persona.setNombres("");
            persona.setApellidos("");
            persona.setTelefono("");
            persona.setTemperatura("");
            persona.setRol("");
            persona.setIdentificacion("");
            //Toast.makeText(this, "Debes introducir el número de identificacion", Toast.LENGTH_SHORT).show();
        }
        return persona;
    }
}
