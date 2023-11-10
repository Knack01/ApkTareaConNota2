package com.example.apktarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Localizacion(View view){
        Intent local = new Intent(this, Localizacion.class);
        startActivity(local);
    }
    public void Veterinaria(View view){
        Intent veteri = new Intent(this, Veterinaria.class);
        startActivity(veteri);
    }
    public void Creado(View view){
        Intent creado = new Intent(this, Creditos.class);
        startActivity(creado);
    }
}