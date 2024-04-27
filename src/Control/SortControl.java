/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.SortModel;

/**
 *
 * @author Yasiru
 */
public class SortControl 
{
    public static void C_Sort_number() {
    Model.SortModel.M_Sort_number();
    }

    public static int[] C_Sort_displayValues() {
        int values[] = Model.SortModel.M_Sort_displayValues();
        return values;
    }
    
 public static boolean C_Sort_saveResponse(int guessedIndex1, int guessedIndex2, boolean resstatus1, boolean resstatus2) {
    // Call the model method to save the response
    boolean result = Model.SortModel.M_Sort_saveResponse(guessedIndex1, guessedIndex2, resstatus1, resstatus2);
    return result;
}

        
}
