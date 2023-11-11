package com.example.apktarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    private TextView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu = findViewById(R.id.et_bienvenido);
        String nombreUsuario = getIntent().getStringExtra("Usuario");
        menu.setText("Bienvenido: "+nombreUsuario);
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