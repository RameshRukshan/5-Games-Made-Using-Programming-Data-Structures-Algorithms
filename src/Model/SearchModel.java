/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import View.*;
/**
 *
 * @author Yasiru
 */
public class SearchModel {
     public static String playername;
      

    public static void M_SearchTime(long binaryTime, long jumpTime, long exponentialTime, long fibonacciTime) {
        Welcome w = new Welcome();
        playername = w.returnPlayerName();
        Model.Database.D_SearchTime(playername,binaryTime,jumpTime,exponentialTime,fibonacciTime);//save search times
    }

    public static void M_SearchResponse(String userChoice, long targetIndex,boolean response) {
        Model.Database.D_SearchResponse(playername,userChoice,targetIndex,response);
    }
    
}
