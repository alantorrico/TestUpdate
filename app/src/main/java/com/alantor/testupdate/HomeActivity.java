package com.alantor.testupdate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alan on 7/30/14.
 */
public class HomeActivity extends Activity {

    private TextView columnaRojo;
    private TextView columnaVerde;
    private Button btnContacto;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lineal_layout);

        btnContacto = (Button) findViewById(R.id.ButtonContactos);
        columnaRojo = (TextView) findViewById(R.id.textViewRojo);
        columnaVerde = (TextView) findViewById(R.id.textViewVerde);

        String datosLogin[] = getIntent().getStringArrayExtra("username");

        columnaRojo.setText(datosLogin[0]);
        columnaVerde.setText(datosLogin[1]);

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),UsuarioActivity.class));
            }
        });
        //Log.d("Usuario",userName);
    }
}
