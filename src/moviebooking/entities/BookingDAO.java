/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static myutility.Utils.getConnection;

/**
 *
 * @author Parth Shah
 */
public class BookingDAO {
    
    
    public static void save(Booking booking) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into bookings(user,shows) values (?,?)");
            preparedStatement.setInt(1, booking.getUser().getId());
            preparedStatement.setInt(2, booking.getShow().getId());
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    
    public static ArrayList<Booking> getBookings(User user) {
        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from bookings where user = " + user.getId() + ";");
            ArrayList<Booking> bookings = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt(1);
                Shows shows = ShowsDAO.get(result.getInt(3));
                bookings.add(new Booking(id,user,shows));
            }
            return bookings;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
