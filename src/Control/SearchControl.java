/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Yasiru
 */
public class SearchControl {

    public static void C_SearchTime(long binaryTime, long jumpTime, long exponentialTime, long fibonacciTime) {
        Model.SearchModel.M_SearchTime(binaryTime, jumpTime, exponentialTime, fibonacciTime);
    }
    
    public static void C_SearchResponse(String userChoice, long targetIndex,boolean response) {
        Model.SearchModel.M_SearchResponse(userChoice, targetIndex ,response);
    }
}
