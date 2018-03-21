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
public class Booking {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private Shows show;

    public Booking(int id, User user, Shows show) {
        this.id = id;
        this.user = user;
        this.show = show;
    }

    public Booking(User user, Shows show) {
        this.user = user;
        this.show = show;
    }
  
    

}
