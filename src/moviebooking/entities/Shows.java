/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sukhv
 */
public class Shows {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private Timings time;
    @Getter
    @Setter
    private Movie movie;
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private Theater theater;

    @Getter
    @Setter
    private int amount;

    public Shows(int id, Timings time, Movie movie, LocalDate date, Theater theater, int amount) {
        this.id = id;
        this.time = time;
        this.movie = movie;
        this.date = date;
        this.theater = theater;
        this.amount = amount;
    }

    public Shows(Timings time, Movie movie, LocalDate date, Theater theater, int amount) {
        this.time = time;
        this.movie = movie;
        this.date = date;
        this.theater = theater;
        this.amount = amount;
    }

}
