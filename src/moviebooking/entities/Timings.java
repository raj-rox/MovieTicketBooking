/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

/**
 *
 * @author sukhv
 */
public enum Timings {

    pm12(12), pm3(15), pm6(18), pm9(21);

    private final int time;

    private Timings(int theTime) {
        time = theTime;
    }
    
    public int getTime() {
        return time;
    }

    public static Timings fromTime(String time)
{
    for(Timings type : Timings.values())
        if(type.toString().equals(time))
            return type;

    return null; //not found
}
    
    @Override
    public String toString() {
        return time + "";
    }

}
