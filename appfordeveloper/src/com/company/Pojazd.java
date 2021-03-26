package com.company;

import java.util.ArrayList;

public class Pojazd extends Przedmiot {
    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;

    public Pojazd(String nazwa, int powierzchnia, int pojemnosc_silnika,String typ_pojazdu){
        super(nazwa,powierzchnia);
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.typ_pojazdu = typ_pojazdu;
    }
}
