/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static myutility.Utils.getConnection;

/**
 *
 * @author Parth Shah
 */
public class UserDAO {

    public static User getUser(String theUsername, String thePassword) {
        try (Connection connection = getConnection()) {

            ResultSet resultSet = connection.createStatement().executeQuery("select * from user where username = \"" + theUsername + "\" and password = \"" + thePassword + "\";");

            resultSet.next();
            return new User(resultSet.getInt(1), resultSet.getString(4), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(5));

        } catch (Exception e) {
            return null;
        }

    }
    
    public static User getUser(String theUsername){
        try(Connection connection = getConnection()) {
            
            ResultSet resultSet = connection.createStatement().executeQuery("select * from user where username = \"" + theUsername + "\";");
            
            resultSet.next();
            return new User(resultSet.getInt(1), resultSet.getString(4), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(5));
        }   catch(Exception e) {
            return null;
        }
    }

    public static void save(User user) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name,username,password,walletBalance) values(?,?,?,?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getWalletBalance());
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println("error couldnt save " + e.getMessage());
        }

    }
    
    public static void update(User user){
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("update user set walletBalance = ? where id = ?;");
            preparedStatement.setInt(1, user.getWalletBalance());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println("error couldnt update " + e.getMessage());
        }
    }
    
    
    public static User get(int index) {
        try (Connection connection = getConnection()) {

            ResultSet rs = connection.createStatement().executeQuery("select * from user where id = " + index + ";");
            rs.next();
            return new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getInt(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    
}
