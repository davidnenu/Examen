package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ej2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    ArrayList<String> a= new ArrayList<>();
    private RadioGroup rg;
    RadioButton c,i;
    private TextView ubicacion;
    private Button lista;
    private String tipo,nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);
        lista=(Button)findViewById(R.id.btnVisualizar);
        rg=(RadioGroup)findViewById(R.id.radioGroup2);
        ubicacion=(TextView)findViewById(R.id.textUbicacion);
        c=(RadioButton)findViewById(R.id.radioCosta);
        i=(RadioButton)findViewById(R.id.radioInterior);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.valores_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        a.add(0,"0");
        a.add(1,"1");
        a.add(2,"1");
        a.add(3,"0");
        a.add(4,"0");
        a.add(5,"0");
        a.add(6,"0");
        a.add(7,"0");
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int position, long l) {

        TextView tvMensaje=(TextView) view;
        nombre=tvMensaje.getText().toString();
        if(a.get(position).equals("1")){
            rg.setVisibility(View.VISIBLE);
            ubicacion.setVisibility(View.VISIBLE);

        }
        else{
            rg.setVisibility(View.INVISIBLE);
            ubicacion.setVisibility(View.INVISIBLE);
        }

        //t.setText(a.get(position));
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    public void visualizar(View v){
        if(rg.getVisibility()==View.VISIBLE){
            if(c.isChecked())
                tipo="costa";
            else
                tipo="interior";
        }
        else
            tipo="nada";


        Intent intent = new Intent(Ej2.this, Ej2_2.class);
        intent.putExtra("provincia", nombre);
        intent.putExtra("tipo", tipo);
        startActivity(intent);

    }
}
