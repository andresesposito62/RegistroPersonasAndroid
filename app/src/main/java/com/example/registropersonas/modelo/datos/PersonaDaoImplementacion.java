package com.example.registropersonas.modelo.datos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.registropersonas.modelo.domain.*;



public class PersonaDaoImplementacion implements InterfazPersonaDao {

    public PersonaDaoImplementacion(){

    }

    @Override
    public boolean registrarPersona(Persona persona){

        String identificacion = persona.getIdentificacion();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String temperatura = persona.getTemperatura();
        String rol = persona.getRol();
        boolean status = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

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
                //Registro Exitoso
                status = true;
            }else{
                //status = "Registro no exitoso";
                status = false;
            }
        }else{
            //status = "Debes diligenciar todos los campos";
            status = false;
        }
        return status;
    }

    @Override
    public Persona consultarPersona(Persona persona2){

        String identificacion = persona2.getIdentificacion();
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
    public boolean eliminarPersona(Persona persona){

        boolean status = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String identificacion = persona.getIdentificacion();

        if(!identificacion.isEmpty()){
            int cantidad = BaseDeDatos.delete("visitantes","identificacion=" + identificacion,null);
            BaseDeDatos.close();

            if(cantidad == 1){
                //Registro eliminado exitosamente
                status = true;
            }else{
                //Registro no existe
                status = false;
            }
        }else{
            status = false;
        }
        return status;
    }

    public boolean actualizarPersona(Persona persona){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String identificacion = persona.getIdentificacion();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String temperatura = persona.getTemperatura();
        String rol = persona.getRol();
        boolean status = false;

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
                //Registro eliminado exitosamente
                status = true;
            }else {
                //Registro no actualizado
                status = false;
            }
        }else{
            //Registro no actualizado
            status = false;
        }
        return status;
    }
}
