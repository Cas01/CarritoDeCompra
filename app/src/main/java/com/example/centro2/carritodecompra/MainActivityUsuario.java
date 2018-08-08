package com.example.centro2.carritodecompra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.centro2.carritodecompra.modelos.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivityUsuario extends AppCompatActivity {

    EditText text_cedula;
    EditText text_nombre;
    EditText text_apellido;
    EditText text_direccion;
    EditText text_telefono;
    Button boton_registrar;
    Button boton_mostrar;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario);

        text_cedula = (EditText)findViewById(R.id.editTextcedula);
        text_nombre = (EditText)findViewById(R.id.editTextnombre);
        text_apellido = (EditText)findViewById(R.id.editTextapellido);
        text_direccion = (EditText)findViewById(R.id.editTextdireccion);
        text_telefono = (EditText)findViewById(R.id.editTexttelefono);
        boton_registrar =(Button)findViewById(R.id.buttonregrabar);

        databaseReference= FirebaseDatabase.getInstance().getReference(getString(R.string.nodo_usuario));




        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cedula=text_cedula.getText().toString();
                String nombre=text_nombre.getText().toString();
                String apellido=text_apellido.getText().toString();
                String direccion=text_direccion.getText().toString();
                String telefono= text_telefono.getText().toString();



                if (!TextUtils.isEmpty(cedula)){
                    if (!TextUtils.isEmpty(nombre)){
                        if (!TextUtils.isEmpty(apellido)){
                            if (!TextUtils.isEmpty(direccion)){
                                if (!TextUtils.isEmpty(telefono)) {




                                    Usuarios u = new Usuarios(cedula,nombre,apellido,direccion,telefono);


                                    String clave = databaseReference.push().getKey();

                                    databaseReference.child(clave).setValue(u);

                                    Toast.makeText(MainActivityUsuario.this,"Usuario Registrado...",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(MainActivityUsuario.this,"falta telefono",Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivityUsuario.this,"falta direccion",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivityUsuario.this,"falta apellido",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivityUsuario.this,"falta nombre",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivityUsuario.this,"falta cedula",Toast.LENGTH_LONG).show();
                }
            }
        });


                }


    }
