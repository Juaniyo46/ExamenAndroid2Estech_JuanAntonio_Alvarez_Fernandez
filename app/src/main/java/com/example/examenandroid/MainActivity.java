package com.example.examenandroid;

import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> enemigos;
    public ArrayList<String> enemigosEdad;
    public ArrayList<String> enemigosDes;
    private ArrayAdapter<String> adaptador;
    private ListView list;
    private EditText etnombre;
    private EditText etedad;
    private EditText etdes;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enemigos = new ArrayList<String>();
        enemigosEdad = new ArrayList<String>();
        enemigosDes = new ArrayList<String>();
        enemigos.add("Juan");
        enemigosEdad.add("21");
        enemigosDes.add("Descripcion del enemigo");


        adaptador = new ArrayAdapter<>(this,R.layout.items_enemigos,enemigos);

        list = (ListView) findViewById(R.id.lista);
        list.setAdapter(adaptador);

        etnombre = (EditText) findViewById(R.id.nombre);
        etedad = (EditText) findViewById(R.id.edad);
        etdes = (EditText) findViewById(R.id.descripcion);











        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               ShowDialog(view);

            }
        });







    }

    public void ShowDialog(View view){
        DialogFragment dialogFragment = new Dialogo();
        dialogFragment.show(getSupportFragmentManager(),"undialog");
    }

    public void agregar (View v) {
        enemigos.add(etnombre.getText().toString());
        enemigosEdad.add(etedad.getText().toString());
        enemigosDes.add(etdes.getText().toString());
        adaptador.notifyDataSetChanged();
        etnombre.setText("");
        etedad.setText("");
        etdes.setText("");
    }
}
