package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    //Declaracion de variables a utilizar
    LottieAnimationView animOjo;
    EditText txtPass,txtMail;
    TextView lblRecuperar, lblCrearCuenta;
    Button btnIngresar;
    CheckBox cboxRecordarDatos;
    String mail,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Relacionamiento de variables con entorno grafico
        txtMail = findViewById(R.id.txtCorreo);
        txtPass = findViewById(R.id.txtContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
        cboxRecordarDatos = findViewById(R.id.checkBoxRecordarDatos);
        lblRecuperar = findViewById(R.id.lblOlvideContraseña);
        lblCrearCuenta = findViewById(R.id.lblCrearCuenta);
        animOjo = findViewById(R.id.animationViewOjo);

        final boolean[] estHide = {false};

        //Métodos con el clic
        animOjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!estHide[0]) {
                    animOjo.setProgress(0);
                    animOjo.setSpeed(5);
                    animOjo.playAnimation();
                    txtPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); //Para mostrar contraseña
                    estHide[0] = true;
                }else {
                    animOjo.setFrame(3);
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //Para ocultar contraseña
                    estHide[0] = false;
                }
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMail.setError(null);
                txtPass.setError(null);
                //ingresar();
                mainAct();
            }
        });

        lblRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarAct();
            }
        });

        lblCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarAct();
            }
        });

    }

    //Métodos que serán llamados en algún momento
    public void recuperarAct() {
        //Metodo para cambiar entre activity
        txtMail.setError(null);
        txtPass.setError(null);
        Intent Recuperar = new Intent(this,RecuperarActivity.class);
        startActivity(Recuperar);
        finish();
    }
    
    public void registrarAct() {
        txtMail.setError(null);
        txtPass.setError(null);
        Intent Registro = new Intent(this,RegistrarActivity.class);
        startActivity(Registro);
        finish();
    }

    public void ingresar() {
        mail = txtMail.getText().toString();
        password = txtPass.getText().toString();
       if(!validarEmail(mail) || password.equals("")) {
           if (!validarEmail(mail)){
               txtMail.setError("Email no válido");
           }
           if(password.equals("")) {
               txtPass.setError("Por favor introduce una contraseña");
           }
       }else {
           //Acá va la validación con la base de datos o el firebase Auth para entrar a la app
           /*if(mail.equals("admin@admin.com") && password.equals("1234")){
               Toast.makeText(this, "Bienvenido Iron", Toast.LENGTH_SHORT).show();*/
               if(!cboxRecordarDatos.isChecked()) {
                   limpiarLogin();
               }else if(cboxRecordarDatos.isChecked()){
                   Toast.makeText(this, "Entra al if del recordar ok", Toast.LENGTH_SHORT).show();
               }
               mainAct();
           /*}else {
               Toast.makeText(this, "Usuario no existente por favor registrese!", Toast.LENGTH_SHORT).show();
           }*/
       }
    }

    public void mainAct() {
        txtMail.setError(null);
        txtPass.setError(null);
        Intent Main = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(Main);
        finish();
    }

    public void limpiarLogin() {
        txtMail.setText("");
        txtPass.setText("");
    }

    public boolean validarEmail(String mail) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(mail).matches();
    }

}