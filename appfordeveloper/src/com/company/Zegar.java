package com.company;

import java.time.LocalDate;

public class Zegar {
    private LocalDate time;

    public Zegar(){
        this.time = LocalDate.now();
    }
    public void settime(){
        this.time = time.plusDays(1);
    }
    public LocalDate getTime(){
        return time;
}
}
