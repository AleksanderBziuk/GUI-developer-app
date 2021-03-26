package com.company;

public class Łódź extends Pojazd {
    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;
    private String rodzaj_łodzi;

    public Łódź(String nazwa,int powierzchnia,int pojemnosc_silnika,String typ_pojazdu,String rodzaj_łodzi){
        super(nazwa,powierzchnia,pojemnosc_silnika,typ_pojazdu);
        this.rodzaj_łodzi = rodzaj_łodzi;
    }
}
