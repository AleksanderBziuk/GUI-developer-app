package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Osiedla:
        Osiedle kasztanowypark = new Osiedle("Kasztanowy Park");

        // Bloki:
        Blok A1 = new Blok("A1",4);
        Blok A2 = new Blok("A2", 10);
        Blok A3 = new Blok("A3",7);

        //Stworzenie listy i przypisanie do niej bloków
        ArrayList<Blok> bloki_w_kasztanowym_parku = new ArrayList<>();
        bloki_w_kasztanowym_parku.add(A1);
        bloki_w_kasztanowym_parku.add(A2);
        bloki_w_kasztanowym_parku.add(A3);

        //Mieszkania

        Mieszkanie m1 = new Mieszkanie(125);
        Mieszkanie m2 = new Mieszkanie(25);
        Mieszkanie m3 = new Mieszkanie(45);



        // Miejsca parkingowe

        Miejsce_parkingowe mp1 = new Miejsce_parkingowe(30);
        Miejsce_parkingowe mp2 = new Miejsce_parkingowe(30);
        Miejsce_parkingowe mp3 = new Miejsce_parkingowe(30);


        //Dodanie miejsc parkingowych i mieszkan do list, dzieki ktorym pozniej bedzie wiadomo jaki mamy obiekt
        Lista_mieszkan_i_miejscparkingowych lista_m_i_mp = new Lista_mieszkan_i_miejscparkingowych();
        lista_m_i_mp.dodajmiejsceparkingowe(mp1);
        lista_m_i_mp.dodajmiejsceparkingowe(mp2);
        lista_m_i_mp.dodajmiejsceparkingowe(mp3);
        lista_m_i_mp.dodajmieszkanie(m1);
        lista_m_i_mp.dodajmieszkanie(m2);
        lista_m_i_mp.dodajmieszkanie(m3);


        //Dodanie mieszkań i miejsc parkingowych do bloków
        A1.dodajpomieszczenie(m1);
        A1.dodajpomieszczenie(mp1);
        A2.dodajpomieszczenie(m3);
        A2.dodajpomieszczenie(mp3);


        // Pojazdy
        Samochód_Miejski Skoda = new Samochód_Miejski("Skoda Fabia",20,2000,"Samochód miejski",5);
        Samochód_Terenowy RangeRover = new Samochód_Terenowy("Range Rover",20,3000,"Samochód Terenowy","4x4");

        // Osoby
        Osoba Aleks = new Osoba("Aleksander","Bziuk","99120245","Wilanowska 150","25.11.1999");
        Osoba Arek = new Osoba("Arek","Kowalski","00280963794","Aleje Jerozolimskie 255","20.11.00");
        Osoba Paweł = new Osoba("Paweł", "Nowak","92082128293","Koszykowa 20","18.20.11");

        // Dodanie osob do listy, dzieki ktorej dany uzytkownik bedzie mogl sie "zalogowac" za pomoca swojego peselu
        ArrayList<Osoba> listaosob = new ArrayList<>();
        listaosob.add(Aleks);
        listaosob.add(Arek);
        listaosob.add(Paweł);

        //obiekt zegar odpowiedzialny za czas, tworzac go wiadomo jaki mamy dzien
        Zegar czas = new Zegar();

        //wyjatek 1 przesuwajacy czas co 5s
        Thread time = new Thread() {

            public void run() {
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    czas.settime();
                }
            }
        };

        //wyjatek 2 sprawdzajacy co 10 s stan wynajmu/oplat pomieszczen
        Thread checktime = new Thread(){
            public void  run(){

                while (true){
                    try {
                        sleep(10000);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    for (Blok b: bloki_w_kasztanowym_parku) {
                        for (Pomieszczenie p :b.getPomieszczenia()) {
                            if (p.getData_zakończenia() != null) {
                                if (czas.getTime().isAfter(p.getData_zakończenia())) {
                                    p.getwlasciciel().dodajpismo(p);
                                }
                                if (czas.getTime().isAfter(p.getData_zakończenia().plusDays(30))) {
                                    for (Mieszkanie m : lista_m_i_mp.getLista_mieszkan()) {
                                        if (p.equals(m)) {
                                            m.eksmisja();
                                            p.zakończnajem();
                                        }
                                    }

                                    for (Miejsce_parkingowe mp : lista_m_i_mp.getLista_miejsc_parkingowych()) {
                                        if (p.equals(mp)) {
                                            for (Przedmiot prz : mp.getLista_przedmiotow()) {
                                                if (prz.getClass().getSuperclass() == Pojazd.class) {
                                                    mp.getLista_przedmiotow().remove(prz);
                                                    mp.setData_zakończenia();
                                                } else {
                                                    mp.getLista_przedmiotow().clear();
                                                    mp.zakończnajem();
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        };
        time.start();
        checktime.start();


        System.out.println("Wybierz opcje, wpisująć w konsoli numer: " + "\n"+
                "1 - zakończenie programu" + "\n"+
                "2 - wypisz dane na swój temat" + "\n"+
                "3 - wyświetl wolne pomieszczenia" + "\n"+
                "4 - wynajmij nowe pomieszczenie" + "\n"+
                "5 - wybierz pomieszczenie oraz wyświetl jego zawartość" + "\n"+
                "6 - włóż nowy przedmiot/pojazd do swojego miejsca parkingowego" + "\n"+
                "7 - wyjmij przedmiot ze swojego miejsca parkingowego" + "\n"+
                "8 - zamelduj/wymelduj osobe z mieszkania" + "\n"+
                "9 - wyswietl liste osob zameldowanych w mieszkaniu" + "\n"+
                "10 - opłać pomieszczenie" + "\n"+
                "11 - sprawdź ilość zadłużeń" + "\n"+
                "12 - zapisz stan osiedla do pliku");

        Scanner scan = new Scanner(System.in);

        try {
            mp1.wynajmij_pomieszczenie(Aleks,mp1);
            m1.wynajmij_pomieszczenie(Aleks,m1);
            m2.wynajmij_pomieszczenie(Aleks,m2);
            mp3.wynajmij_pomieszczenie(Aleks,mp3);
        }catch (Exception e) {
            e.getMessage();
        }



        System.out.println("Wybierz opcje: ");
            int numer = scan.nextInt();
            if(numer<1 | numer > 12){
                System.out.println("Wpisano niepoprawny numer");
            }else {
                switch (numer) {
                    case 1:
                        System.exit(1);
                        break;
                    case 2:
                        String mojpesel = "";
                        System.out.println("Podaj pesel: ");
                        mojpesel = scan.next();
                        for (Osoba o : listaosob) {
                            if (mojpesel.equals(o.getPesel())) {
                                System.out.println(o.getinfoosoba());
                                for (Pomieszczenie s : o.sprawdz_posiadane_pomieszczenia()) {
                                    System.out.println();
                                    System.out.println(s.getinfoofpomieszczenie());
                                }
                            }else {
                                System.out.println("Nie ma takiej osoby.");
                            }
                        }
                        break;
                    case 3:
                        for (Blok b: bloki_w_kasztanowym_parku) {
                            for (Pomieszczenie s: b.getPomieszczenia()) {
                                if(s.getZajęte()==0){
                                    
                                }
                            }
                        }
                }
            }




    }
}
