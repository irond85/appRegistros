package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swpActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swpActualizar = findViewById(R.id.swpActualizar);

        //METODO PARA ACTUALIZAR LA TABLA PERO EN EL MOMENTO MUESTRA UN SNACKBAR XD
        swpActualizar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //ACA AGREGAMOS EL METODO OBVIA XD
                Actualizar();
            }
        });

    }

    //CAMBIAR DE ACTS Y ELIMINAR THIS
    public void LoginAct(){
        Intent Login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(Login);
        finish();
    }

    //METODO PARA REGRESAR
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            LoginAct();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Actualizar() {
        //SERIA BUENO AGREGAR UN SNACKBAR PARA MOSTRAR UN MENSAJE DE ACTUALIZADO O ALGO SIMILAR
        Toast.makeText(this, "Se está actualizando eweeeeeeee", Toast.LENGTH_SHORT).show();
        swpActualizar.setRefreshing(false);
        Toast.makeText(this, "Atualizaooo sociooo", Toast.LENGTH_SHORT).show();
    }
}