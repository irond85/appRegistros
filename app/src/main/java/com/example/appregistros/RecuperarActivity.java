package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class RecuperarActivity extends AppCompatActivity {

    //VARIABLES
    EditText txtCorreo;
    TextView lblEstado, lblAyuda;
    Button btnRecuperar;
    ImageButton btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        //RELACIONAMIENTO DE VARIABLES CON ENTORNO GRÁFICO
        txtCorreo = findViewById(R.id.txtCorreo);
        lblEstado = findViewById(R.id.lblEstado);
        lblAyuda = findViewById(R.id.lblAyuda);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnVolver = findViewById(R.id.imgBtnVolver);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recuperar();
            }
        });
        
        lblAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RecuperarActivity.this, "Contactandote con IronD", Toast.LENGTH_SHORT).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginAct();
            }
        });

    }

    //Metodos
    private boolean ValidarEmail(String mail) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(mail).matches();
    }

    public void LoginAct() {
        Intent Login = new Intent(RecuperarActivity.this, LoginActivity.class);
        startActivity(Login);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            LoginAct();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Recuperar() {
        String mail = txtCorreo.getText().toString();
        if (!ValidarEmail(mail)){
            txtCorreo.setError("Email no válido");
        }else {
            if(mail.equals("admin@admin.com")){
                lblEstado.setText(R.string.lblExisteCorreo);
                Toast.makeText(RecuperarActivity.this, R.string.lblExisteCorreo, Toast.LENGTH_SHORT).show();
                //COLOCAR "TIMER" PARA QUE SE ESPERE UN MOMENTICO XD
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // acciones que se ejecutan tras los milisegundos
                        LoginAct();
                    }
                }, 2000);
            }else {
                lblEstado.setText(R.string.lblNoExisteCorreo);
                Toast.makeText(RecuperarActivity.this, R.string.lblNoExisteCorreo, Toast.LENGTH_SHORT).show();
            }
        }
    }
}