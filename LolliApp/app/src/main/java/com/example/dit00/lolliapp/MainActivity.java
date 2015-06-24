package com.example.dit00.lolliapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.security.PublicKey;

public class MainActivity extends Activity {
    EditText nombre;
    EditText edad;
    DatePicker fecha;
    RadioGroup genero;
    TextView textView;
    String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembrev", "Diciembre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClic(View view) {
        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        fecha = (DatePicker) findViewById(R.id.txtFecha);
        genero = (RadioGroup) findViewById(R.id.txtGenero);


        //Validando EditText
        if(nombre.getText().toString().trim().equals("")){
            nombre.setError("Nombre requerido");
            return;
        }
        if(edad.getText().toString().trim().equals("")){
            edad.setError("Edad requerida");
            return;
        }
        if(Integer.parseInt(edad.getText().toString())<=0){
            edad.setError("Edad no válida");
            return;
        }
        int id= genero.getCheckedRadioButtonId();
        View radioButton = genero.findViewById(id);
        int radioId = genero.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) genero.getChildAt(radioId);
        String sexo = (String) btn.getText();

        String texto ="\n Nombre: "+ nombre.getText()+"\n Edad: "+edad.getText()+" años \n Fecha Nac.: "+fecha.getDayOfMonth()+" de "+MONTHS[fecha.getMonth()]+", "+fecha.getYear()+
                "\n Genero: "+sexo;



        Intent i = new Intent(this, Activity2Activity.class);
        Bundle bun = new Bundle();
        bun.putString("NOMBRE",texto);
        i.putExtras(bun);
        startActivity(i);
        //finish();
    }



}
