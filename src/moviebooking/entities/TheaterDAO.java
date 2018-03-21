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
public class TheaterDAO {

    public static void save(Theater theater) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into theater(name) values (?)");
            preparedStatement.setString(1, theater.getName());
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static List<Theater> getAll() {
        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from theater");
            ArrayList<Theater> theaters = new ArrayList<>();
            while (result.next()) {
                theaters.add(new Theater(result.getInt(1), result.getString(2)));
            }

            return theaters;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static Theater get(int index) {
        try (Connection connection = getConnection()) {

            ResultSet rs = connection.createStatement().executeQuery("select * from theater where id = " + index + ";");
            rs.next();
            return new Theater(rs.getInt(1), rs.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static Theater getTheater(String theTheater) {

        try (Connection connection = getConnection()) {

            ResultSet result = connection.createStatement().executeQuery("select * from theater where name = \"" + theTheater + "\";");
            result.next();
            return new Theater(result.getInt(1), result.getString(2));

        } catch (Exception e) {
            return null;
        }

    }

}
