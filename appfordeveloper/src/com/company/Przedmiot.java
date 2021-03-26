package com.company;

public class Przedmiot {
    private String nazwa;
    private int powierzchnia;

    public Przedmiot(String nazwa, int powierzchnia){
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
    }
    public int getpowierzchnia(){
        return powierzchnia;
    }
    public String getNazwa(){
        return nazwa;
    }
}
