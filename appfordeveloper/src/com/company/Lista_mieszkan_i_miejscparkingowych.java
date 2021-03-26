package com.company;

import java.util.ArrayList;

public class Lista_mieszkan_i_miejscparkingowych {

    private ArrayList<Mieszkanie> lista_mieszkan;
    private ArrayList<Miejsce_parkingowe> lista_miejsc_parkingowych;

    public Lista_mieszkan_i_miejscparkingowych(){
        lista_mieszkan = new ArrayList<>();
        lista_miejsc_parkingowych = new ArrayList<>();
    }

    public void dodajmieszkanie(Mieszkanie m){
        lista_mieszkan.add(m);
    }
    public void dodajmiejsceparkingowe(Miejsce_parkingowe mp){
        lista_miejsc_parkingowych.add(mp);
    }

    public ArrayList<Miejsce_parkingowe> getLista_miejsc_parkingowych(){
        return lista_miejsc_parkingowych;
    }

    public ArrayList<Mieszkanie> getLista_mieszkan(){
        return lista_mieszkan;
    }
}
