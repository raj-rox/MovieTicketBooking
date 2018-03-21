/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static myutility.Utils.getConnection;

/**
 *
 * @author Parth Shah
 */
public class ShowsDAO {

    public static void save(Shows shows) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into shows(time,amount,movie,date,theater) values(?,?,?,?,?);");
            preparedStatement.setString(1, shows.getTime().toString());
            preparedStatement.setInt(2, shows.getAmount());
            preparedStatement.setInt(3, shows.getMovie().getId());
            preparedStatement.setDate(4, Date.valueOf(shows.getDate()));
            preparedStatement.setInt(5, shows.getTheater().getId());
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Shows> getshows(Theater theater) {

        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from shows where theater = " + theater.getId() + ";");
            ArrayList<Shows> shows = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt(1);
                Timings time = Timings.fromTime(result.getString(2));
                int amount = result.getInt(3);
                Movie movie = MovieDAO.get(result.getInt(4));
                LocalDate date = result.getDate(5).toLocalDate();
                Theater t = TheaterDAO.get(result.getInt(6));
                shows.add(new Shows(id, time, movie, date, t, amount));
            }
            return shows;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

    }
    
    
    public static List<Shows> getshows(Movie movie) {

        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from shows where movie = " + movie.getId() + ";");
            ArrayList<Shows> shows = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt(1);
                Timings time = Timings.fromTime(result.getString(2));
                int amount = result.getInt(3);
                Movie m = MovieDAO.get(result.getInt(4));
                LocalDate date = result.getDate(5).toLocalDate();
                Theater theater = TheaterDAO.get(result.getInt(6));
                shows.add(new Shows(id, time, m, date, theater, amount));
            }
            return shows;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

    }
    
    public static Shows get(int index) {
        try (Connection connection = getConnection()) {

            ResultSet rs = connection.createStatement().executeQuery("select * from shows where id = " + index + ";");
            rs.next();
            int id = rs.getInt(1);
            Timings time = Timings.fromTime(rs.getString(2));
            int amount = rs.getInt(3);
            Movie movie = MovieDAO.get(rs.getInt(4));
            LocalDate date = rs.getDate(5).toLocalDate();
            Theater t = TheaterDAO.get(rs.getInt(6));
            return new Shows(id, time, movie, date, t, amount);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

}
