package com.example.registropersonas.vista;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registropersonas.*;
import com.example.registropersonas.presentador.Instruccion;
import com.example.registropersonas.presentador.Presentador;

public class Login extends AppCompatActivity {

    EditText editTextUsuario, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsuario = (EditText)findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
    }

    public void iniciarSesion(View view){

        String usuario = editTextUsuario.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(!usuario.isEmpty() && !password.isEmpty()){
            Presentador presentador = new Presentador();
            Instruccion instruccion = new Instruccion();
            instruccion.setTipoInstruccion("BOTON_LOGIN_PRESIONADO");
            instruccion =presentador.solicitud(instruccion, this);
            if (instruccion.getTipoInstruccion().equals("CAMBIAR_PANTALLA")){
                Intent intent = new Intent(this, instruccion.getClaseSiguente());
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(this, "Debes diligenciar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

}