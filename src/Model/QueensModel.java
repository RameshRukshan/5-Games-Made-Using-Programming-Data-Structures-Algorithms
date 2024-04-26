/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chiran
 */
public class QueensModel {
    public boolean checkSafety(int[][] board, int row,int col){
        int boardSize = board.length;
        for(int i = 0; i < boardSize; i++){
            if(board[row][i]==1 && i!= col){
                return false;
            }
            else if(board[i][col]==1 && i!=row){
                return false;
            }
        }
        //top 
        for(int r = row-1,c = col-1; r >= 0 && c >=0 ; r--,c--){
            if(board[r][c] == 1){
                return false;
            }
        }
        for(int r = row-1,c = col+1; r>=0 && c < boardSize; r--,c++){
            if(board[r][c] == 1){
                return false;
            }
        }
        
        //bottom
        for(int r = row+1,c = col-1; r < boardSize && c >=0; r++,c--){
            if(board[r][c]==1){
                return false;
            }
        }
        for(int r = row+1,c = col+1; r < boardSize && c < boardSize; r++,c++){
            if(board[r][c]==1){
                return false;
            }
        }
        return true;
    }
    
   
}
