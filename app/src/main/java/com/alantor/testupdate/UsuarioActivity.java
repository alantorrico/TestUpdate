package com.alantor.testupdate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alan on 8/1/14.
 */
public class UsuarioActivity extends Activity {

    private EditText mNombre;
    private EditText mtelefono;
    private Button mAgregar;
    private ListView mLista;

    private ArrayList<Contacto> listaContactos;

    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.usuario_layout);

        mNombre = (EditText) findViewById(R.id.EditTextNombre);
        mtelefono = (EditText) findViewById(R.id.EditTextTelefono);
        mAgregar = (Button) findViewById(R.id.ButtonAgregar);
        mLista = (ListView) findViewById(R.id.listViewContactos);

        listaContactos = new ArrayList<Contacto>();

        mAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = mNombre.getText().toString();
                String telefono = mtelefono.getText().toString();

                if(!nombre.equalsIgnoreCase("") && !telefono.equalsIgnoreCase("")){

                    Contacto contacto = new Contacto(nombre, telefono);

                    listaContactos.add(contacto);
                    UsersAdapter adapter = new UsersAdapter(getBaseContext(), listaContactos);
                    //ArrayAdapter<Contacto> adapter = new ArrayAdapter<Contacto>(getBaseContext(), android.R.layout.simple_list_item_1, listaContactos);

                    mLista.setAdapter(adapter);

                }
                else{
                    Toast.makeText(getBaseContext(),"Llene datos",Toast.LENGTH_SHORT).show();
                }

                Log.d("nombre: ",nombre);
                Log.d("telefono: ",telefono);
            }
        });
    }
}
