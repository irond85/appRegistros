package com.example.appregistros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBienvenido = findViewById(R.id.txtBienvenida);

    }

    public void LoginAct(){
        Intent Login = new Intent(MainActivity.this, LoginActivity.class);
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
}