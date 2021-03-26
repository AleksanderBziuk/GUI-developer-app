package com.company;

public class Samochód_Terenowy extends Pojazd {

    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;
    private String naped;

    public Samochód_Terenowy(String nazwa,int powierzchnia,int pojemnosc_silnika,String typ_pojazdu, String naped){
        super(nazwa,powierzchnia,pojemnosc_silnika,typ_pojazdu);
        this.naped = naped;
    }
}
