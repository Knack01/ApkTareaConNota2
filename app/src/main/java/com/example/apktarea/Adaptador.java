package com.example.apktarea;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    ArrayList<DBVeterinaria> lista;
    daoVeterinaria dao;
    DBVeterinaria vet;
    Activity a;
    int id  = 0;

    public Adaptador(Activity a, ArrayList<DBVeterinaria> lista, daoVeterinaria dao ){
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        vet=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        vet=lista.get(i);
        return vet.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);
        }
        vet = lista.get(posicion);
        TextView nomMas= v.findViewById(R.id.nomMas);
        TextView tipoMas = v.findViewById(R.id.tipoMas);
        TextView raza = v.findViewById(R.id.raza);
        TextView nomDue = v.findViewById(R.id.nomDue);
        TextView motivo = v.findViewById(R.id.motivo);
        TextView num = v.findViewById(R.id.num);
        Button editar = v.findViewById(R.id.btn_editar);
        Button eliminar = v.findViewById(R.id.btn_eliminar);
        nomMas.setText(vet.getNomMas());
        tipoMas.setText(vet.getTipoMas());
        raza.setText(vet.getRaza());
        nomDue.setText(vet.getNomDue());
        motivo.setText(vet.getMotivo());
        num.setText(vet.getNum());
        editar.setTag(posicion);
        eliminar.setTag(posicion);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                final Dialog dialog =new Dialog(a);
                dialog.setTitle("Editar Registro");
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
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                vet = lista.get(pos);
                setId(vet.getId());
                nomMas.setText(vet.getNomMas());
                tipoMas.setText(vet.getTipoMas());
                raza.setText(vet.getRaza());
                nomDue.setText(vet.getNomDue());
                motivo.setText(vet.getMotivo());
                num.setText(vet.getNum());
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try{
                            vet = new DBVeterinaria(getId(), nomMas.getText().toString(),
                                    tipoMas.getText().toString(),
                                    raza.getText().toString(),
                                    nomDue.getText().toString(),
                                    motivo.getText().toString(),
                                    num.getText().toString());
                            dao.editar(vet);
                            lista=dao.verTodo();
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(a, "ERROR", Toast.LENGTH_SHORT).show();
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
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(view.getTag().toString());
                vet = lista.get(posicion);
                setId(vet.getId());
                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("Estas seguro de eliminar");
                del.setCancelable(false);
                del.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dao.eliminar(getId());
                        lista=dao.verTodo();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                del.show();
            }
        });
        return v;
    }
}
