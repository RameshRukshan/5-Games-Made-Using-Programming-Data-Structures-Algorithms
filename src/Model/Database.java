/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.SortModel.playername;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author rames
 */
public class Database {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_g";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";
    
  
    //sort algorithm********************************************************************************************
    //save sort time to database
    public static void D_Sort_saveSortTimes(Map<String, Long> sortTimes) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            for (Map.Entry<String, Long> entry : sortTimes.entrySet()) {
                String PlayerName=playername;
                String sortType = entry.getKey();
                long timeTaken = entry.getValue();
                String query = "INSERT INTO sort_times (playername,sort_type, time_taken) VALUES (?,?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, PlayerName);
                    preparedStatement.setString(2, sortType);
                    preparedStatement.setLong(3, timeTaken);
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Sort times saved to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        //save player response to database
        public static boolean D_Sort_saveResponse(String palyer_name,int guessedIndex1, int guessedIndex2, boolean resstatus1, boolean resstatus2) {
         boolean success = false;
         String status1,status2;
         if (resstatus1) {
             status1 = "true";
         } else {
             status1 = "false";
         }

         if (resstatus2) {
             status2 = "true";
         } else {
             status2 = "false";
         }

         String query = "INSERT INTO response_table (player_name, guessed_index1, guessed_index2, status1, status2) VALUES (?, ?, ?, ?, ?)";

         try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, palyer_name);
             preparedStatement.setInt(2, guessedIndex1);
             preparedStatement.setInt(3, guessedIndex2);
             preparedStatement.setString(4, status1);
             preparedStatement.setString(5, status2);

             int rowsAffected = preparedStatement.executeUpdate();
             if (rowsAffected > 0) {
                 success = true;
                 System.out.println("Response saved for player: " + playername);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return success;
     }

    
}
