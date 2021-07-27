package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class AgregarActivity extends AppCompatActivity {

    Toolbar miActionBar;
    CardView cvDeudas, cvFacturas, cvCompras, cvOtros;
    RelativeLayout rlPadnum;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnCancelar, btnBorrar, btnGuardar;
    TextView txtCantidad;
    EditText txtDescripcion;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtDescripcion = findViewById(R.id.txtDescripcion);

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
        btnGuardar = findViewById(R.id.btnGuardar);
        txtCantidad = findViewById(R.id.txtCantidad);
        
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btn0.setOnClickListener(view -> colocarNum("0"));
        btn1.setOnClickListener(view -> colocarNum("1"));
        btn2.setOnClickListener(view -> colocarNum("2"));
        btn3.setOnClickListener(view -> colocarNum("3"));
        btn4.setOnClickListener(view -> colocarNum("4"));
        btn5.setOnClickListener(view -> colocarNum("5"));
        btn6.setOnClickListener(view -> colocarNum("6"));
        btn7.setOnClickListener(view -> colocarNum("7"));
        btn8.setOnClickListener(view -> colocarNum("8"));
        btn9.setOnClickListener(view -> colocarNum("9"));

        btnBorrar.setOnClickListener(view -> {
            String cant = txtCantidad.getText().toString();
            txtCantidad.setText("");
            vibrator.vibrate(50);
        });

        btnCancelar.setOnClickListener(view -> {
            vibrator.vibrate(100);
            txtCantidad.setText("");
            rlPadnum.setVisibility(View.GONE);
            cvDeudas.setVisibility(View.VISIBLE);
            cvFacturas.setVisibility(View.VISIBLE);
            cvCompras.setVisibility(View.VISIBLE);
            cvOtros.setVisibility(View.VISIBLE);
        });
        
        btnGuardar.setOnClickListener(view -> {
            String cantidad = txtCantidad.getText().toString();
            String descripcion = txtDescripcion.getText().toString();
            if (cantidad.equals("") || descripcion.equals("")) {
                Toast.makeText(this, "Por favor llene los datos!", Toast.LENGTH_SHORT).show();
            }else {
                int total = Integer.parseInt(cantidad);
                if (total == 0){
                    Toast.makeText(this, "Por favor valida la cantidad ingresada!", Toast.LENGTH_SHORT).show();
                }else {
                    Snackbar.make(view,"Se ha registrado el movimiento", Snackbar.LENGTH_LONG)
                            .setAction("Menú Principal", view1 -> mainAct())
                            .setActionTextColor(getResources().getColor(R.color.colorWhite))
                            .setBackgroundTint(getResources().getColor(R.color.colorPrimary))
                            .show();
                }
            }
        });

    }

    //MOSTRAR PADNUM
    public void mostrarPadNum() {
        rlPadnum = findViewById(R.id.rlPadnum);
        rlPadnum.setVisibility(View.VISIBLE);
    }

    public void colocarNum(String num) {
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        String cant = txtCantidad.getText().toString();
        txtCantidad.setText(cant + num);
        vibrator.vibrate(50);
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