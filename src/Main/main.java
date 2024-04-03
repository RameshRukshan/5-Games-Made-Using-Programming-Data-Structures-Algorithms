/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import View.Home;
import Control.QueensControl;
/**
 *
 * @author chiran
 */
public class main {
    public static void main(String[] args){
        //Home ne = new Home();
        //ne.setVisible(true);
        QueensControl ne = new QueensControl();
        if(ne.checkSafe(0, 3, 1, 6, 2, 2, 3, 7, 4, 1, 5, 4, 6, 0, 7, 5) == true){
            System.out.println("--- Valid Solution ---");
        }
        else{
            System.out.println("--- Invalid Solution ---");
        }
        
    }
}
