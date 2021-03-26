package com.company;

import java.io.File;
import java.util.ArrayList;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres;
    private String data_urodzenia;
    private ArrayList<Pomieszczenie> wynajete_pomieszczenia;
    private ArrayList<File> pisma;

    public Osoba(String imie,String nazwisko,String pesel,String adres,String data_urodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres=adres;
        this.data_urodzenia = data_urodzenia;
        wynajete_pomieszczenia = new ArrayList<>();
        pisma = new ArrayList<>();
    }

    //metoda zwracajaca wynajete pomieszczenia
    public ArrayList<Pomieszczenie> sprawdz_posiadane_pomieszczenia(){
        return wynajete_pomieszczenia;
    }

    public String getinfoosoba(){
        return imie + "\n" + nazwisko + "\n" + pesel + "\n" + adres + "\n" + data_urodzenia;
    }

    public String getimie_nazwisko(){
        return imie + " " + nazwisko;
    }

    public void dodajpismo(Pomieszczenie m){
        pisma.add(new File(m.getIdpomieszcenie()));
    }

    public ArrayList<File> listapism(){
        return pisma;
    }

    public String getPesel(){
        return pesel;
    }



}
