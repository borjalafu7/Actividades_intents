package com.borjalapa.actividades;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
EditText etTexto;
TextView tvTexto;
final String TEXTO = "TEXTO";
final int RESPUESTA_ACT3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = (EditText)findViewById(R.id.etNombre);
        tvTexto = (TextView)findViewById(R.id.tvRespuesta);
    }

    public void irActividad2(View view) {
        //donde estamos y donde queremos ir
        Intent i = new Intent(this,Actividad2.class);

        //pasar valores a la otra actividad
        Bundle extra = new Bundle();
        extra.putString(TEXTO, etTexto.getText().toString());
        i.putExtras(extra);

        //ir a la actividad 2
        startActivity(i);
    }

    public void irActividad3(View view) {
        //donde estamos y donde queremos ir
        Intent i = new Intent(this,Actividad3.class);

        //iniciar actividad esperando un texto(resultado)
        startActivityForResult(i,RESPUESTA_ACT3);
    }

    //metodo para que cuando devuelva el resultado hacer lo que queremos con el
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESPUESTA_ACT3 && resultCode == RESULT_OK){
            tvTexto.setText(data.getExtras().getString("RESPUESTA"));
            etTexto.setText(data.getExtras().getString("RESPUESTA"));
        }
    }

    //guardar el estado del textView para cuando giramos la pantalla que se guarde el texto en una variable
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //guardamos en el string el texto que queramos en una variable con un id (TEXTO)
        String texto = tvTexto.getText().toString();
        savedInstanceState.putString(TEXTO,texto);
        super.onSaveInstanceState(savedInstanceState);
    }

    //para cuando giramos al estado recoja el texto de la variable guardada y lo setee al textView de nuevo
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String texto = savedInstanceState.getString(TEXTO);
        tvTexto.setText(texto);
    }
}
