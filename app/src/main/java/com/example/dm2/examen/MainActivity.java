package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button ej1;
    private Button ej2;
    private Button ej3;
    private Button ej4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ej1=(Button)findViewById(R.id.ej1);

        ej1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Ej1.class);
                startActivity(intent);

            }
        });
        ej2=(Button)findViewById(R.id.ej2);

        ej2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Ej2.class);
                startActivity(intent);

            }
        });

        ej3=(Button)findViewById(R.id.ej3);

        ej3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"Actividad no implementado por el momento", Toast.LENGTH_SHORT).show();

            }
        });

        ej4=(Button)findViewById(R.id.ej4);

        ej4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"Actividad no implementado por el momento", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
