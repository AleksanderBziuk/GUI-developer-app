package com.company;

public class Amfibia extends Pojazd {
    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;
    private String kolor;

    public Amfibia(String nazwa,int powierzchnia,int pojemnosc_silnika,String typ_pojazdu, String kolor){
        super(nazwa,powierzchnia,pojemnosc_silnika,typ_pojazdu);
        this.kolor = kolor;
    }
}
