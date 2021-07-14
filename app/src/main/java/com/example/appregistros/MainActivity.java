package com.example.appregistros;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swpActualizar;
    PieChart graficoPastel;
    Toolbar miActionBar;
    FloatingActionButton fabAgregar;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        swpActualizar = findViewById(R.id.swpActualizar);
        graficoPastel = findViewById(R.id.graficoPastel);
        fabAgregar = findViewById(R.id.fabAgregar);

        llenarGraficoPastel();

        //METODO PARA ACTUALIZAR LA TABLA PERO EN EL MOMENTO MUESTRA UN SNACKBAR XD
        //ACA AGREGAMOS EL METODO OBVIA XD
        swpActualizar.setOnRefreshListener(this::actualizar);

        fabAgregar.setOnClickListener(view -> /*Snackbar.make(view, "Le diste al boton flotante", Snackbar.LENGTH_LONG)
                .setAnchorView(fabAgregar)
                .setAction("Accion", view1 -> Toast.makeText(MainActivity.this, "Funciona la accion del snackbar", Toast.LENGTH_SHORT).show())
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show()*/ agregarAct());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //CAMBIAR DE ACTS Y ELIMINAR THIS
    public void loginAct(){
        Intent Login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(Login);
        finish();
    }

    public void agregarAct() {
        Intent add = new Intent(MainActivity.this, AgregarActivity.class);
        startActivity(add);
    }

    //METODO PARA REGRESAR
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            loginAct();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void actualizar() {
        //SERIA BUENO AGREGAR UN SNACKBAR PARA MOSTRAR UN MENSAJE DE ACTUALIZADO O ALGO SIMILAR
        Toast.makeText(this, "Se está actualizando eweeeeeeee", Toast.LENGTH_SHORT).show();
        swpActualizar.setRefreshing(false);
        Toast.makeText(this, "Atualizaooo sociooo", Toast.LENGTH_SHORT).show();
    }

    public void llenarGraficoPastel() {
        Description description = new Description();
        description.setText("");
        graficoPastel.setDescription(description);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        int ventas = 35000;
        int compras = 100000;
        int Viajes = 50000;
        int juegos = 200000;

        pieEntries.add(new PieEntry(ventas,"Ventas"));
        pieEntries.add(new PieEntry(compras,"Compras"));
        pieEntries.add(new PieEntry(Viajes,"Viajes"));
        pieEntries.add(new PieEntry(juegos,"Juegos"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData = new PieData(pieDataSet);

        graficoPastel.setData(pieData);
    }
}