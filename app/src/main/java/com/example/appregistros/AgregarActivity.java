package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class AgregarActivity extends AppCompatActivity {

    Toolbar miActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        miActionBar = findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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