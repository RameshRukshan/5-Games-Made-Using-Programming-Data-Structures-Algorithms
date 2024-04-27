/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.TicTacToeModel;

/**
 *
 * @author chiran
 */
public class TicTacToeControl {
    
    public int[][] computeMove(int[][] board){
        TicTacToeModel obj = new TicTacToeModel();
        int[][] updatedBoard = obj.computeMove(board);
        return updatedBoard;
    }
    
    public String evaluvateTheBoard(int[][] board){
        //horizontal 
        if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1){
            return "player";
        }
        else if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1){
            return "player";
        }
        else if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1){
            return "player";
        }
        
        if(board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2){
            return "computer";
        }
        else if(board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2){
            return "computer";
        }
        else if(board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2){
            return "computer";
        }
        
        //vertically
        if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1){
            return "player";
        }
        if(board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1){
            return "player";
        }
        if(board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1){
            return "player";
        }
        
        if(board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2){
            return "computer";
        }
        if(board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2){
            return "computer";
        }
        if(board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2){
            return "computer";
        }
        
        //diagonally
        if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){
            return "player";
        }
        if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1){
            return "player";
        }
        
        if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){
            return "computer";
        }
        if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1){
            return "computer";
        }
        return "draw";
    }

    public void C_Save_response(int[][] tictactoeBoard) {
        TicTacToeModel m = new TicTacToeModel();
        m.M_SaveResponse(tictactoeBoard);
    }
}
