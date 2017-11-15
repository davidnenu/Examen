package com.example.dm2.examen;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Ej2_2 extends AppCompatActivity {
    ListView lstLocalidades;
    private String tipo,nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2_2);

        Bundle extras = getIntent().getExtras();
        tipo = extras.getString("tipo");
        nombre = extras.getString("nombre");

        ArrayList<Localidad> arrayListLocalidades = new ArrayList<Localidad>();
        Localidad localidad;

        localidad = new Localidad("Orduña", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.orduna),"http://www.urduna.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Ondarroa", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.ondarroa),"http://www.ondarroa.eu/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Areatza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.areatza),"http://www.areatza.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Gernika", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.gernika), "http://www.gernika-lumo.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Bermeo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.bermeo),"http://www.bermeo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Balmaseda", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.balmaseda),"http://www.balmaseda.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Karrantza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.karrantza),"http://www.karrantza.org/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Lekeitio", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.lekeitio),"http://www.lekeitio.com/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Getxo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.getxo),"http://www.getxo.eus/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Laguardia", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.laguardia),"http://www.laguardia-alava.net/");
        //arrayListLocalidades.add(localidad);
       // localidad = new Localidad("Hondarribia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.hondarribia),"http://www.hondarribia.eus/es/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Zarautz", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.zarautz),"http://www.zarautz.org/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Pasaia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.pasaia),"http://www.pasaia.eus/es");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Astigarraga", "Gipuzkoa", "Interior", ContextCompat.getDrawable(this, R.drawable.astigarraga),"http://astigarraga.eus");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Donostia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.donostia),"http://www.donostia.eus");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Vitoria-Gasteiz", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");
        //arrayListLocalidades.add(localidad);
        //localidad = new Localidad("Añana", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.anana),"http://www.cuadrilladeanana.es/anana/");
        //arrayListLocalidades.add(localidad);


        AdaptadorLocalidades adaptador =
                new AdaptadorLocalidades(this, arrayListLocalidades);

        lstLocalidades = (ListView)findViewById(R.id.lstLocalidades);
        lstLocalidades.setAdapter(adaptador);

        //Eventos
        lstLocalidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {

                String url =
                        ((Localidad)a.getItemAtPosition(position)).getUrl();
                //long opcion = a.getItemIdAtPosition(position);

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });



    }

    class AdaptadorLocalidades extends ArrayAdapter<Localidad> {

        public AdaptadorLocalidades(Context context, ArrayList dat) {
            super(context, R.layout.listitem_provincias,dat);

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_provincias, null);

            if(super.getItem(position).getProvincia().equals(nombre)&&super.getItem(position).getTipo().equals(tipo)) {

                TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
                lblNombre.setText(super.getItem(position).getNombre());

                ImageView icon = (ImageView) item.findViewById(R.id.iconLocalidad);
                icon.setImageDrawable(super.getItem(position).getIcono());
            }

            return (item);
        }

    }



    class Localidad {
        private String nombre;
        private String provincia;
        private String tipo;
        private Drawable icono;
        private String url;
        public Localidad(String n, String p,String t,Drawable i,String u){
            nombre=n;
            url=u;
            icono=i;
            provincia=p;
            tipo=t;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public Drawable getIcono() {
            return icono;
        }

        public void setIcono(Drawable icono) {
            this.icono = icono;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
