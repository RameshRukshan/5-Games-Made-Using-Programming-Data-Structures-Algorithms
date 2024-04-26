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

         String query = "INSERT INTO sort_response(player_name, guessed_index1, guessed_index2, status1, status2) VALUES (?, ?, ?, ?, ?)";

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
    
 public static boolean D_Queen_saveResponse(String playerName, int[] array) {
        // Serialize the array
       String serializedArray = serializeArray(array);

    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                String sql = "INSERT INTO Queens_response (player_name, array_data) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, playerName);
                    statement.setString(2, serializedArray);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Response saved successfully.");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }
 
 
  public static boolean D_Tictactoe_saveResponse(String playerName, int[] array) {
        // Serialize the array
       String serializedArray = serializeArray(array);

    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                String sql = "INSERT INTO Tictactoe_response (player_name, array_data) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, playerName);
                    statement.setString(2, serializedArray);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Response saved successfully.");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }
  
    public static boolean D_ShortestPath_saveResponse(String playerName, int[] array) {
        // Serialize the array
       String serializedArray = serializeArray(array);

    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
                String sql = "INSERT INTO ShortestPath_response (player_name, array_data) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, playerName);
                    statement.setString(2, serializedArray);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Response saved successfully.");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }

    private static String serializeArray(int[] array) {
        // Manually construct a JSON array string
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            jsonBuilder.append(array[i]);
            if (i < array.length - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
    
/*
-- Table to store sort times
CREATE TABLE sort_times(
  id int NOT NULL AUTO_INCREMENT,
  playername varchar(100) DEFAULT NULL,
  Bubble Sort bigint DEFAULT NULL,
  Insertion Sort bigint DEFAULT NULL,
  Merge Sort bigint DEFAULT NULL,
  Radix Sort bigint DEFAULT NULL,
  Shell Sort bigint DEFAULT NULL,
  Quick Sort bigint DEFAULT NULL,
  Tim Sort bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)

-- Table to store sort responses
CREATE TABLE sort_response (
  id int NOT NULL AUTO_INCREMENT,
  player_name varchar(255) DEFAULT NULL,
  guessed_index1 int DEFAULT NULL,
  guessed_index2 int DEFAULT NULL,
  status1 varchar(10) DEFAULT NULL,
  status2 varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

-- Table to store search times
CREATE TABLE SearchTime_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    playername VARCHAR(255) NOT NULL,
    binaryTime BIGINT NOT NULL,
    jumpTime BIGINT NOT NULL,
    exponentialTime BIGINT NOT NULL,
    fibonacciTime BIGINT NOT NULL
);

-- Table to store search responses
CREATE TABLE SearchResponse_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    playername VARCHAR(255) NOT NULL,
    userChoice VARCHAR(255) NOT NULL,
    targetIndex BIGINT NOT NULL,
    response BOOLEAN NOT NULL
);

-- Queens Response Table
CREATE TABLE queens_Response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(255) NOT NULL,
    array_data TEXT NOT NULL
);

-- Tic Tac Toe Response Table
CREATE TABLE tictactoe_Response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(255) NOT NULL,
    array_data TEXT NOT NULL
);

-- Shortest Path Response Table
CREATE TABLE ShortestPath_response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(255) NOT NULL,
    array_data TEXT NOT NULL
);

*/
