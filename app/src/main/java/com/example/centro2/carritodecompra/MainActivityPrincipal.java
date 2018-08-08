package com.example.centro2.carritodecompra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);
    }
    public void  activity_main_menu(View v) {
        Intent MainActivityMenu = new Intent(this, MainActivityMenu.class);
        startActivity(MainActivityMenu);


    }}

