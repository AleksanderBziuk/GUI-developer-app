package com.company;

public class Motocykl extends Pojazd {
    private String nazwa;
    private int powierzchnia;
    private int pojemnosc_silnika;
    private String typ_pojazdu;
    private String typ_motocyklu;

    public Motocykl(String nazwa,int powierzchnia,int pojemnosc_silnika,String typ_pojazdu, String typ_motocyklu){
        super(nazwa,powierzchnia,pojemnosc_silnika,typ_pojazdu);
        this.typ_motocyklu = typ_motocyklu;
    }
}
