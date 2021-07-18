package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AgregarActivity extends AppCompatActivity {

    Toolbar miActionBar;
    CardView cvDeudas, cvFacturas, cvCompras, cvOtros;
    RelativeLayout rlPadnum;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnCancelar, btnBorrar;
    TextView txtCantidad;
    Vibrator vibrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        miActionBar = findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cvDeudas = findViewById(R.id.cvDeudas);
        cvFacturas = findViewById(R.id.cvFacturas);
        cvCompras = findViewById(R.id.cvCompras);
        cvOtros = findViewById(R.id.cvOtros);
        cvDeudas.setOnClickListener(view -> {
            cvFacturas.setVisibility(View.GONE);
            cvCompras.setVisibility(View.GONE);
            cvOtros.setVisibility(View.GONE);
            mostrarPadNum();
        });
        cvFacturas.setOnClickListener(view -> {
            cvDeudas.setVisibility(View.GONE);
            cvCompras.setVisibility(View.GONE);
            cvOtros.setVisibility(View.GONE);
            mostrarPadNum();
        });
        cvCompras.setOnClickListener(view -> {
            cvDeudas.setVisibility(View.GONE);
            cvFacturas.setVisibility(View.GONE);
            cvOtros.setVisibility(View.GONE);
            mostrarPadNum();
        });
        cvOtros.setOnClickListener(view -> {
            cvDeudas.setVisibility(View.GONE);
            cvFacturas.setVisibility(View.GONE);
            cvCompras.setVisibility(View.GONE);
            mostrarPadNum();
        });

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnBorrar = findViewById(R.id.btnBorrar);
        txtCantidad = findViewById(R.id.txtCantidad);
        
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btnCancelar.setOnClickListener(view -> {
            vibrator.vibrate(100);
            txtCantidad.setText("");
            rlPadnum.setVisibility(View.GONE);
            cvDeudas.setVisibility(View.VISIBLE);
            cvFacturas.setVisibility(View.VISIBLE);
            cvCompras.setVisibility(View.VISIBLE);
            cvOtros.setVisibility(View.VISIBLE);
        });
    }

    //MOSTRAR PADNUM
    public void mostrarPadNum() {
        rlPadnum = findViewById(R.id.rlPadnum);
        rlPadnum.setVisibility(View.VISIBLE);
    }






    //METODO PARA REGRESAR CON EL BOTON O LA ACCION DE BACK DEL CELULAR
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mainAct();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void mainAct() {
        Intent main = new Intent(AgregarActivity.this, MainActivity.class);
        startActivity(main);
        finish();
    }
}