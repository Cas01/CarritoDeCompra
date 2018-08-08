package com.example.centro2.carritodecompra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void activity_main_usuario(View v) {
        Intent MainActivityUsuario = new Intent(this, MainActivityUsuario.class);
        startActivity(MainActivityUsuario);

    }
    public void activity_main_producto(View v) {
        Intent MainActivityProducto = new Intent(this, MainActivityProducto.class);
        startActivity(MainActivityProducto);

    }
}