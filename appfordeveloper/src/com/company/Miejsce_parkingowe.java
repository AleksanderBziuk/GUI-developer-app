package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Miejsce_parkingowe extends Pomieszczenie {

    private LocalDate datanajmu;
    private LocalDate data_zakończenia;
    private int powierzchnia_użytkowa;
    private int przestrzen_zajeta;
    private ArrayList<Przedmiot> lista_przedmiotow;

    public Miejsce_parkingowe(int powierzchnia_użytkowa){
        super(powierzchnia_użytkowa);
        lista_przedmiotow = new ArrayList<>();
        this.przestrzen_zajeta = 0;
    }


    // metoda pozwalajaca na dodanie pojazdu do miejsca parkingowego
    public void Dodaj_przedmiot(Osoba a, Przedmiot p) throws TooManyThingsException{
        if(a.equals(getwlasciciel())) {
            if ((getPrzestrzenzajeta() + p.getpowierzchnia()) < getPowierzchnia_użytkowa()) {
                System.out.println("Udało ci sie włożyc element: " + p.getNazwa());
                lista_przedmiotow.add(p);
            } else {
                System.out.println("Nie udało ci sie włożyc przedmiotu: " + p.getNazwa());
                throw new TooManyThingsException("Usuń jakiś przedmiot żeby można było dodać kolejny!");
            }
        }else {
            System.out.println("To nie jest twoje miejsce parkingowe!");
        }
    }

    //metoda pozwalajaca wypisac przedmioty znajdujace sie na miejscu parkingowym danej osoby
    public void Wypisz_przedmioty(Osoba a){
        if(a.equals(getwlasciciel())) {
            for (int i = 0; i < lista_przedmiotow.size(); i++) {
                System.out.println(lista_przedmiotow.get(i).getNazwa() + " zajmuje: " + lista_przedmiotow.get(i).getpowierzchnia() + " m^3");
            }
            System.out.println("Ilość przestrzeni pozostałej do wypełnienia: " + (getPowierzchnia_użytkowa() - getPrzestrzenzajeta()) + " m^3");
        }else {
            System.out.println("To nie jest twoje miejsce parkingowe!");
        }
    }

    //metoda pozwalajaca na usuniecie przedmiotu/Pojazdu z miejsca parkingowego. Opiera sie na konkretnej nazwie danej rzeczy
    public void usun_przedmiot(Osoba a, String nazwa){

        if(a.equals(getwlasciciel())) {
            int indeks = 0;
            for (Przedmiot p : lista_przedmiotow) {
                if (p.getNazwa() == nazwa) {
                    indeks = lista_przedmiotow.indexOf(p);
                    lista_przedmiotow.remove(indeks);
                }
            }
        }else {
            System.out.println("To nie jest twoje miejsce parkingowe!");
        }
    }

    // metoda zliczajaca zajeta przestrzen przez przedmioty, ktore sa obecne na miejscu parkingowym
    public Integer getPrzestrzenzajeta(){
        przestrzen_zajeta = 0;
        for (Przedmiot p: lista_przedmiotow) {
            przestrzen_zajeta+=p.getpowierzchnia();
        }
        return przestrzen_zajeta;
    }

    public ArrayList<Przedmiot> getLista_przedmiotow(){
        return lista_przedmiotow;
    }

    public void setData_zakończenia(){
        this.data_zakończenia.plusMonths(2);
    }
}
