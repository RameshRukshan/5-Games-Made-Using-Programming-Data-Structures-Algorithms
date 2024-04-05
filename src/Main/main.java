/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
//import View.Home;
//import Control.QueensControl;
import Control.TicTacToeControl;
/**
 *
 * @author chiran
 */
public class main {
    public static void main(String[] args){
        //Home ne = new Home();
        //ne.setVisible(true);
        /*QueensControl ne = new QueensControl();
        int[][] chessBoard = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0} };
        if(ne.checkSafe(chessBoard) == true){
            System.out.println("--- Valid Solution ---");
        }
        else{
            System.out.println("--- Invalid Solution ---");
        }*/
        int[][] tictactoeBoard = {
                        {1,0,0},
                        {0,1,0},
                        {0,0,0} };
        TicTacToeControl ne = new TicTacToeControl();
        int[][] newboard = ne.computeMove(tictactoeBoard);
        newboard = ne.computeMove(tictactoeBoard);
        newboard = ne.computeMove(tictactoeBoard);
        newboard = ne.computeMove(tictactoeBoard);
        for(int i = 0;i < newboard.length; i++){
            for(int j = 0;j < newboard[i].length; j++){
                System.out.println(newboard[i][j] + ", ");
            }
        
        }
    }
}
