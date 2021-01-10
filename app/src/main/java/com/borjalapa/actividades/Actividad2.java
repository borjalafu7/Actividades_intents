package com.borjalapa.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        textView = (TextView) findViewById(R.id.tvActivity2);

        //recoger los datos de la otra actividad
        Bundle extras = getIntent().getExtras();
        String texto = extras.getString("TEXTO");

        //seteamos el texto del textView con el string recogido de la otra actividad
        textView.setText(texto);
    }

    public void volver(View view) {
        finish();
    }
}