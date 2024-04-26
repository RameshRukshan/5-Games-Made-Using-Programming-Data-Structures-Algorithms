/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import View.Home;
import Control.QueensControl;
import Control.TicTacToeControl;
import Control.ShortestDisControl;
import Model.ShortestDisModel;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chiran
 */
public class main {
    
    public void queensCheck(){
        QueensControl ne = new QueensControl();
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
        }
    }
    
    public static void main(String[] args){
        main obj = new main();
        obj.queensCheck();
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
