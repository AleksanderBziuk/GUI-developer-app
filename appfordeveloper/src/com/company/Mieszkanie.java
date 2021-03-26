package com.company;
import java.time.LocalDate;
import java.util.ArrayList;

public class Mieszkanie extends Pomieszczenie {


    private LocalDate datanajmu;
    private LocalDate data_zakończenia;
    private int zajęte = 0;
    private Osoba własciciel;

    private ArrayList<Osoba> listalokatorow; //pierwsza osoba na liscie lokatorów jest właściciel

    public Mieszkanie(int powierzchnia_użytkowa){
        super(powierzchnia_użytkowa);
        listalokatorow = new ArrayList<>();

    }


    public void zameldujOsobe(Osoba a, Osoba b){
        if(a.equals(getwlasciciel())){
            listalokatorow.add(b);
        }else {
            System.out.println("Nie możesz zameldować lokatora, gdyż nie jesteś wlascicielem");
        }
    }

    public void wymeldujOsobe(Osoba a, Osoba b){
        if(a.equals(getwlasciciel())){
            listalokatorow.remove(b);
        }else {
            System.out.println("Nie możesz zameldować lokatora, gdyż nie jesteś wlascicielem");
        }
    }



    public void wypiszlokatorow(){
        System.out.println("Lista osób zameldowanych w mieszkaniu: ");
        System.out.println("1) " + getwlasciciel().getinfoosoba());
        int i = 1;
        for (Osoba a:listalokatorow) {
            System.out.println(++i + ") " + a.getinfoosoba());
        }
    }

    public void eksmisja(){
        for (Osoba a: listalokatorow) {
            listalokatorow.remove(a);
        }
    }
}
