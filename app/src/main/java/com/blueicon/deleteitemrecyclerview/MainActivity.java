package com.blueicon.deleteitemrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Persona> personas;
    private AdapterListView adapterListView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    public void initViews(){
        listView = (ListView)findViewById(R.id.listview);
        personas =  new ArrayList<>();
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        personas.add( new Persona("Nombre","Apellido"));
        adapterListView  = new AdapterListView(personas,this);
        listView.setAdapter(adapterListView);

    }
}
