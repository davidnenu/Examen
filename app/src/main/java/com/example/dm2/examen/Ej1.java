package com.example.dm2.examen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Ej1 extends AppCompatActivity {

    Button btnEmpezar;
    Button btnEvaluar;
    EditText soluciones,respuesta;
    RadioButton s,r,m;
    int x=0,y=0,total=0,correctas=0;
    String op="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);
        soluciones=(EditText)findViewById(R.id.txtSoluciones);
        btnEmpezar=(Button)findViewById(R.id.btnEmpezar);
        btnEvaluar=(Button)findViewById(R.id.btnEvaluar);
        s=(RadioButton)findViewById(R.id.radioSumas);
        r=(RadioButton)findViewById(R.id.radioRestas);
        m=(RadioButton)findViewById(R.id.radioMultiplicaciones);
        respuesta=(EditText)findViewById(R.id.txtSolucionesEdit);

    }
    public void empezar(View v){

        if(s.isChecked())
            op="+";
        else if(r.isChecked())
            op="-";
        else if (m.isChecked())
            op="*";
        else {
            Toast.makeText(Ej1.this, "Selecciona operacion para poder operar", Toast.LENGTH_SHORT).show();
            return;
        }

        btnEmpezar.setVisibility(View.INVISIBLE);
        btnEvaluar.setVisibility(View.VISIBLE);
        mostrarOperacion();

    }
    public void evaluar(View v){
if(respuesta.length()==0)
    return;
else {

    if (op.equals("+")) {
        if (x + y == Integer.parseInt(respuesta.getText().toString())) {
            total++;
            correctas++;
            mostrarOperacion();
        } else
            total++;

    } else if (op.equals("-")) {
        if (x - y == Integer.parseInt(respuesta.getText().toString())) {
            total++;
            correctas++;
            mostrarOperacion();
        } else
            total++;

    } else if (op.equals("*")) {
        if (x * y == Integer.parseInt(respuesta.getText().toString())) {
            total++;
            correctas++;
            mostrarOperacion();
        } else
            total++;

    }


    if (total == 10) {
        Toast.makeText(Ej1.this, "Aciertos: " + (correctas * 100) / 10 + " %", Toast.LENGTH_SHORT).show();
        total = 0;
        correctas = 0;
        op = "";
        btnEmpezar.setVisibility(View.VISIBLE);
        btnEvaluar.setVisibility(View.INVISIBLE);
        return;
    }
    mostrarOperacion();
}

    }
    public void mostrarOperacion(){
        x=(int)(Math.random()*100);
        y=(int)(Math.random()*100);
        soluciones.setText(x+" "+op+" "+y+" = ");
        respuesta.setText("");
    }
    public void volver(View v){

        finish();
    }

}
