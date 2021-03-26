package com.company;

public class Samochód_Miejski extends Pojazd {
    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;
    private int ilosc_drzwi;

    public Samochód_Miejski(String nazwa,int powierzchnia,int pojemnosc_silnika,String typ_pojazdu, int ilosc_drzwi){
        super(nazwa,powierzchnia,pojemnosc_silnika,typ_pojazdu);
        this.ilosc_drzwi = ilosc_drzwi;

    }
}
