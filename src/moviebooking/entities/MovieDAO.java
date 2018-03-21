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
public class MovieDAO {

    public static Movie get(int id) {

        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from movie where id = " + id + ";");
            result.next();
            return new Movie(result.getInt(1), result.getString(2), result.getFloat(3));

        } catch (Exception e) {
            return null;
        }

    }
    
    public static Movie getMovie(String theMovie) {

        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from movie where name = \"" + theMovie + "\";");
            result.next();
            return new Movie(result.getInt(1), result.getString(2), result.getFloat(3));

        } catch (Exception e) {
            return null;
        }

    }

    public static void insert(Movie theMovie) {
        try (Connection connection = getConnection()) {

            connection.createStatement().execute("insert into movie(name,ratings) values(" + theMovie.getName() + theMovie.getRatings() + ");");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Movie> getAll() {
        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from movie");
            ArrayList<Movie> movies = new ArrayList<>();
            while (result.next()) {
                movies.add(new Movie(result.getInt(1), result.getString(2), result.getFloat(3)));
            }

            return movies;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void save(Movie movie) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into movie(name,ratings) values (?,?)");
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setFloat(2, movie.getRatings());
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
