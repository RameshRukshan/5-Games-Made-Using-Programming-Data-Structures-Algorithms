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
public static void D_Sort_saveSortTimes(String playerName, Map<String, Long> sortTimes) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
        StringBuilder columns = new StringBuilder("playername");
        StringBuilder values = new StringBuilder("?");

        for (Map.Entry<String, Long> entry : sortTimes.entrySet()) {
            columns.append(", `").append(entry.getKey()).append("`");
            values.append(", ?");
        }

        String query = "INSERT INTO sort_times (" + columns + ") VALUES (" + values + ")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, playerName);

            int index = 2;
            for (long time : sortTimes.values()) {
                preparedStatement.setLong(index++, time);
            }

            preparedStatement.executeUpdate();
        }

        System.out.println("Sort times saved to the database for player: " + playerName);
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

        //save search time to database
    public static void D_SearchTime(String playername, long binaryTime, long jumpTime, long exponentialTime, long fibonacciTime) {
        String query = "INSERT INTO SearchTime_table (playername, binaryTime, jumpTime, exponentialTime, fibonacciTime) VALUES (?, ?, ?, ?, ?)";

         try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, playername);
             preparedStatement.setLong(2, binaryTime);
             preparedStatement.setLong(3, jumpTime);
             preparedStatement.setLong(4, exponentialTime);
             preparedStatement.setLong(5, fibonacciTime);

             int rowsAffected = preparedStatement.executeUpdate();
             if (rowsAffected > 0) {
                 System.out.println("Search Time saved for player: " + playername);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    //save the search response to database 
    static void D_SearchResponse(String playername, String userChoice, long targetIndex, boolean response) {
        String query = "INSERT INTO SearchResponse_table (playername, userChoice, targetIndex, response) VALUES (?, ?, ?, ?)";

         try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, playername);
             preparedStatement.setString(2, userChoice);
             preparedStatement.setLong(3, targetIndex);
             preparedStatement.setBoolean(4, response);
           

             int rowsAffected = preparedStatement.executeUpdate();
             if (rowsAffected > 0) {
                 System.out.println("Search response saved for player: " + playername);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    
}
