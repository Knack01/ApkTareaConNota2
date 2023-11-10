package com.example.apktarea;

public class DBVeterinaria {
    int id;

    String nomMas;
    String tipoMas;
    String raza;
    String nomDue;
    String motivo;
    String num;

    public DBVeterinaria(){

    }

    public DBVeterinaria(String nomMas, String tipoMas, String raza, String nomDue, String motivo, String num){
        this.nomMas = nomMas;
        this.tipoMas = tipoMas;
        this.raza = raza;
        this.nomDue = nomDue;
        this.motivo = motivo;
        this.num = num;
    }
    public DBVeterinaria(int id, String nomMas, String tipoMas, String raza, String nomDue, String motivo, String num){
        this.id = id;
        this.nomMas = nomMas;
        this.tipoMas = tipoMas;
        this.raza = raza;
        this.nomDue = nomDue;
        this.motivo = motivo;
        this.num = num;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNomMas(){
        return  nomMas;
    }
    public void setNomMas(String nomMas){
        this.nomMas = nomMas;
    }
    public String getTipoMas(){
        return tipoMas;
    }
    public void setTipoMas(String tipoMas){
        this.tipoMas = tipoMas;
    }
    public  String getRaza(){
        return  raza;
    }
    public void setRaza(String raza){
        this.raza = raza;
    }
    public String getNomDue(){
        return nomDue;
    }
    public void setNomDue(String nomDue){
        this.nomDue = nomDue;
    }
    public String getMotivo(){
        return  motivo;
    }
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    public String getNum(){
        return num;
    }
    public void setNum(String num){
        this.num = num;
    }
}
