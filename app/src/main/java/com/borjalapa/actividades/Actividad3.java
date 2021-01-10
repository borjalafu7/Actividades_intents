package com.borjalapa.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Actividad3 extends AppCompatActivity {
EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        etText = (EditText)findViewById(R.id.etNombreAct3);
    }

    public void responder(View view) {
        //recogemos la respuesta para mandarla a la actividad main
        Intent i = getIntent();
        i.putExtra("RESPUESTA",etText.getText().toString());

        //seteamos que el resultado es correcto y devolvemos el intent
        setResult(RESULT_OK,i);
        finish();
    }
}