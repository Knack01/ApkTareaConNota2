package com.example.apktarea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Veterinaria extends AppCompatActivity {
    daoVeterinaria dao;
    Adaptador adapter;
    ArrayList<DBVeterinaria> lista;
    DBVeterinaria vet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinaria);

        dao = new daoVeterinaria(Veterinaria.this);
        lista= dao.verTodo();
        adapter = new Adaptador(this, lista, dao);
        ListView list = findViewById(R.id.lista);
        Button insertar = findViewById(R.id.btn_insertar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Veterinaria.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nomMas = dialog.findViewById(R.id.et_nomMas);
                final EditText tipoMas = dialog.findViewById(R.id.et_tipo);
                final EditText raza = dialog.findViewById(R.id.et_raza);
                final EditText nomDue = dialog.findViewById(R.id.et_nomDue);
                final EditText motivo = dialog.findViewById(R.id.et_motivo);
                final EditText num = dialog.findViewById(R.id.et_num);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                guardar.setText("Agregar");
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            vet = new DBVeterinaria(nomMas.getText().toString(),
                                    tipoMas.getText().toString(),
                                    raza.getText().toString(),
                                    nomDue.getText().toString(),
                                    motivo.getText().toString(),
                                    num.getText().toString());
                            dao.insertar(vet);
                            lista=dao.verTodo();
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    public void volver(View view){
        Intent volver = new Intent(this, Menu.class);
        startActivity(volver);
    }
}