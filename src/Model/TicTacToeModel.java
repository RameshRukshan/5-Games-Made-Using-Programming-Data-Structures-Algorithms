/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Random;
/**
 *
 * @author chiran
 */
public class TicTacToeModel {
    public int[][] computeMove(int[][] board) {
    Random random =  new Random();
    int row, col = 0;
    int i = 9;
    while(i!=0){
        row = random.nextInt(3);
        col = random.nextInt(3);
        if(row >= 0 && row < 3 && col >=0 && col < 3 && board[row][col] == 0){
            board[row][col] = 2;
            break;
        }
        else{
            continue;
        }
    }
    return board;
    }

    public void M_SaveResponse(int[][] tictactoeBoard) {
       String playerName="Hello";
       boolean value = Database.D_Tictactoe_saveResponse(playerName, tictactoeBoard);
    }
}
