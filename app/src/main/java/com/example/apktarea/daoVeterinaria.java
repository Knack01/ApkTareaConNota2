package com.example.apktarea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoVeterinaria {

    SQLiteDatabase db;
    ArrayList<DBVeterinaria> lista = new ArrayList<DBVeterinaria>();
    DBVeterinaria vet;
    Context vc;
    String nombreDB = "BDVeterinaria";

    String tabla = "create table if not exists veterinaria(id integer primary key autoincrement, nomMas text, tipoMas text, raza text, nomDue text, motivo text, num text)";

    public daoVeterinaria(Context vet){
        this.vc = vet;
        db=vet.openOrCreateDatabase(nombreDB, Context.MODE_PRIVATE, null);
        db.execSQL(tabla);
    }
    public boolean insertar(DBVeterinaria v){
        ContentValues container = new ContentValues();
        container.put("nomMas", v.getNomMas());
        container.put("tipoMas", v.getTipoMas());
        container.put("raza", v.getRaza());
        container.put("nomDue", v.getNomDue());
        container.put("motivo", v.getMotivo());
        container.put("num", v.getNum());
        return (db.insert("veterinaria", null, container))>0;
    }

    public boolean eliminar(int id){
        return (db.delete("veterinaria", "id="+id, null))>0;
    }

    public boolean editar(DBVeterinaria v){
        ContentValues container = new ContentValues();
        container.put("nomMas", v.getNomMas());
        container.put("tipoMas", v.getTipoMas());
        container.put("raza", v.getRaza());
        container.put("nomDue", v.getNomDue());
        container.put("motivo", v.getMotivo());
        container.put("num", v.getNum());
        return (db.update("veterinaria", container, "id="+v.getId(), null))>0;
    }

    public ArrayList<DBVeterinaria>verTodo(){
        lista.clear();
        Cursor cursor = db.rawQuery("select * from veterinaria", null);
        if (cursor!= null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                lista.add(new DBVeterinaria(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return lista;
    }
    public DBVeterinaria verUno(int posicion){
        Cursor cursor = db.rawQuery("select * from veterinaria", null);
        cursor.moveToPosition(posicion);
        vet= new DBVeterinaria(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6));
        return vet;
    }
}
