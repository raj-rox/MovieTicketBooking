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
public class User {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;
    
    @Getter
    @Setter
    private int walletBalance;

   
    
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.walletBalance = 0;
    }

    
    public User(int id, String name, String username, String password, int walletBalance) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.walletBalance = walletBalance;
    }

    public User(String name, String username, String password, int walletBalance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.walletBalance = walletBalance;
    }
    
        
    
}
