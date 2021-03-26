package com.company;

import java.util.ArrayList;

public class Blok {

    private String nazwa_bloku;
    private int ilosc_pomieszczen;
    private ArrayList<Pomieszczenie> pomieszczenia;

    public Blok(String nazwa_bloku, int ilosc_pomieszczen){
        this.nazwa_bloku = nazwa_bloku;
        this.ilosc_pomieszczen = ilosc_pomieszczen;
        pomieszczenia = new ArrayList<>();
    }


    //metoda pozwalajaca na dodanie pomieszczenia(przeznaczonego na wynajem) do bloku
    public ArrayList<Pomieszczenie> dodajpomieszczenie(Pomieszczenie m){
        if(pomieszczenia.size() < getIlosc_pomieszczen()){
            pomieszczenia.add(m);
            System.out.println("Poprawne dodanie mieszkania.");
        }else {
            System.out.println("W tym bloku nie ma miejsca na nowe mieszkanie!");
        }
        return pomieszczenia;
    }

    ///metoda zwracajaca ilosc mieszkan mozliwych do stworzenia w bloku
    public int getIlosc_pomieszczen(){
        return ilosc_pomieszczen;
    }

    public ArrayList<Pomieszczenie> getPomieszczenia(){
        return pomieszczenia;
    }
}
