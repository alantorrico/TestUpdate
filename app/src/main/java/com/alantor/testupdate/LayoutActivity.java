package com.alantor.testupdate;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LayoutActivity extends Activity {

    private EditText userName;
    private EditText pass;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        userName = (EditText)findViewById(R.id.editTextUsername);
        pass = (EditText) findViewById(R.id.editTextPassword);



        submitButton = (Button)findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = userName.getText().toString();
                String password = pass.getText().toString();

                if(username.equalsIgnoreCase("") && password.equalsIgnoreCase("")){

                    Toast.makeText(getBaseContext(), "Usuario Correcto",Toast.LENGTH_SHORT).show();
                    String datos[] = {username,password};

                    Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                    i.putExtra("username",datos);
                    startActivity(i);
                }else{
                    Toast.makeText(getBaseContext(), "Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //i.putExtra("ValorTest","otro valor");

        //startActivity(i);
        //access();
    }

    public void access(){
        ContentResolver cr = getContentResolver();

        Cursor cur = cr.query(Contacts.People.CONTENT_URI,null,null,null,null);

        if (cur.getCount() > 0){
            while(cur.moveToNext()){
                String id = cur.getString(cur.getColumnIndex(Contacts.People._ID));
                String contactos = cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));
                Log.d("nombres", contactos);

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
