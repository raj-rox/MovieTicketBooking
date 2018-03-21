/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sukhv
 */
public class Movie {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private float ratings;

    public Movie(int id, String name, float ratings) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
    }

    public Movie(String name, float ratings) {
        this.name = name;
        this.ratings = ratings;
    }

    
    
}
