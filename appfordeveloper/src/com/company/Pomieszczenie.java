package com.company;

import java.io.File;
import java.time.LocalDate;

public class Pomieszczenie {
    private int powierzchnia_użytkowa;
    private int Id_pomieszczenie = 0;
    private static int counter = 0;

    private LocalDate datanajmu;
    private LocalDate data_zakończenia;
    private int zajęte = 0;
    private Osoba własciciel;
    private int opłacone;

    public Pomieszczenie(int powierzchnia_użytkowa){
        this.powierzchnia_użytkowa = powierzchnia_użytkowa;
        this.Id_pomieszczenie = counter++;
    }

    public void wynajmij_pomieszczenie(Osoba a, Pomieszczenie b) throws ProblematicTenantException {

        if (zajęte == 0) {
            if(a.listapism().size()<3) {
                int counter_pomieszczen = 0;
                for (Pomieszczenie s : a.sprawdz_posiadane_pomieszczenia()) {
                    counter_pomieszczen++;
                }
                if (counter_pomieszczen == 5) {
                    System.out.println("Przykro mi nie możesz wynając nowego pomieszczenia, gdyż wynajmujesz ich 5.");
                } else {
                    this.datanajmu = LocalDate.now();
                    this.data_zakończenia = datanajmu.plusDays(30);
                    this.zajęte = 1;
                    this.własciciel = a;
                    this.opłacone = 1;
                    a.sprawdz_posiadane_pomieszczenia().add(b);
                }
            }else {
             throw new ProblematicTenantException("Osoba" + a.getimie_nazwisko() + " posiada już najem" + a.listapism() );
            }
        }else{
            System.out.println("To mieszkanie jest już zajęte i nie możesz go wynająć!");
    }
    }

    public void opłać_pomieszczenie(Osoba a){
        if(a.equals(getwlasciciel())){
            this.data_zakończenia = data_zakończenia.plusDays(30);
        }else {
            System.out.println("Nie jestes włascicielem pomieszczenia");
        }
    }

    public void  zakończnajem(){
      this.własciciel = null;
      this.datanajmu = null;
      this.data_zakończenia = null;
      this.zajęte = 0;

    }

    public void zakończnajemjakowłaściel(Osoba a){
        if(a.equals(getwlasciciel())){
            this.własciciel = null;
            this.datanajmu = null;
            this.data_zakończenia = null;
            this.zajęte = 0;
            for (File s: a.listapism() ){
                if(s.getName().equals(getIdpomieszcenie())){
                    s.delete();
                }
            }
        }else {
            System.out.println("Nie jesteś właścicielem pomieszczenia!");
        }
    }

    public int getOpłacone(){return opłacone;}

    public Osoba getwlasciciel(){
        return własciciel;
    }

    public LocalDate getDatanajmu(){
        return datanajmu;
    }

    public LocalDate getData_zakończenia(){ return data_zakończenia;}

    public int getId_pomieszczenie(){
        return Id_pomieszczenie;
    }

    public int getPowierzchnia_użytkowa(){
        return powierzchnia_użytkowa;
    }

    public String getIdpomieszcenie(){
        return Integer.toString(getId_pomieszczenie());
    }

    public int getZajęte(){
        return zajęte;
    }

    public String getinfoofpomieszczenie(){
        String czyopłacone = "";
        if(opłacone==0){
            czyopłacone = "nieopłacone";
        }
        if(opłacone==1){
            czyopłacone = "zapłacone";
        }
        return "ID pomieszczenia: " + Integer.toString(getId_pomieszczenie()) + "\n" + "Powierzchnia użytkowa: " + powierzchnia_użytkowa +
                "\n"  + "Data najmu: " + datanajmu + "\n" + "Data zakończenia najmu: " + data_zakończenia  +
                "\n"  + "Czy opłacone? " + czyopłacone;
    }

}
