package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.regex.Pattern;

public class RegistrarActivity extends AppCompatActivity {

    //VARIABLES
    EditText txtName, txtCorreoR, txtPass, txtPassAgain;
    LottieAnimationView animOjo1, animOjo2;
    Button btnRegistrar;
    TextView lblPassword, lblAyuda;
    ImageButton btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        //RELACIONAMIENTO DE VARIABLES CON ENTORNO GRAFICO
        txtName = findViewById(R.id.txtNombre);
        txtCorreoR = findViewById(R.id.txtCorreoNuevo);
        txtPass = findViewById(R.id.txtPassword1);
        txtPassAgain = findViewById(R.id.txtPasswordAgain);
        btnRegistrar = findViewById(R.id.btnRegistrarse);
        lblPassword = findViewById(R.id.lblPassword);
        lblAyuda = findViewById(R.id.lblAyuda);
        btnVolver = findViewById(R.id.imgBtnVolver);
        animOjo1 = findViewById(R.id.animationViewOjo);
        animOjo2 = findViewById(R.id.animationViewOjoRepetir);


        final boolean[] estHide = {false};
        animOjo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!estHide[0]) {
                    animOjo1.setProgress(0);
                    animOjo1.setSpeed(5);
                    animOjo1.playAnimation();
                    txtPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); //Para mostrar contraseña
                    estHide[0] = true;
                }else {
                    animOjo1.setFrame(3);
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //Para ocultar contraseña
                    estHide[0] = false;
                }
            }
        });

        final boolean[] estHide2 = {false};
        animOjo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!estHide2[0]) {
                    animOjo2.setProgress(0);
                    animOjo2.setSpeed(5);
                    animOjo2.playAnimation();
                    txtPassAgain.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); //Para mostrar contraseña
                    estHide2[0] = true;
                }else {
                    animOjo2.setFrame(3);
                    txtPassAgain.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //Para ocultar contraseña
                    estHide2[0] = false;
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginAct();
            }
        });

        lblAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegistrarActivity.this, "Contactandote con IronD", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrar();
            }
        });

    }

    //Metodos
    public void LoginAct() {
        Intent Login = new Intent(this, LoginActivity.class);
        startActivity(Login);
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public void Registrar() {
        lblPassword.setText("");
        String name = txtName.getText().toString();
        String mail = txtCorreoR.getText().toString().toLowerCase();
        String pass1 = txtPass.getText().toString();
        String pass2 = txtPassAgain.getText().toString();

        if(name.equals("") || !validarEmail(mail) || pass1.equals("") || pass2.equals("")) {
            if(name.equals("")) {
                txtName.setError("Debes llenar este campo");
            }
            if(!validarEmail(mail)) {
                txtCorreoR.setError("Email no válido");
            }
            if(pass1.equals("")) {
                txtPass.setError("Debes ingresar una contraseña");
            }
            if(pass2.equals("")) {
                txtPassAgain.setError("Debes repetir la contraseña");
            }
        }else {
            if(pass2.equals(pass1)) {
                //Aqui va el code para ingresar el usuario a la Base de datos
                Toast.makeText(this, "Usuario creado: "+name+"\n"+mail, Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // acciones que se ejecutan tras los milisegundos
                        LoginAct();
                    }
                }, 2000);
            }else {
                lblPassword.setText("Las contraseñas deben coincidir");
            }
        }
    }

}