/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sukhv
 */
public class Theater {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

//    @Getter
//    @Setter
//    private List<Shows> shows = new ArrayList<>();
//
//    @Getter
//    @Setter
//    private List<Booking> bookings = new ArrayList<>();

    public Theater(String name) {
        this.name = name;
    }

    public Theater(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    
    

}
