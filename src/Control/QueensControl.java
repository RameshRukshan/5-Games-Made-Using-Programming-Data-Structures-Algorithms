/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.QueensModel;

/**
 *
 * @author chiran
 */
public class QueensControl {
    int[][] chessBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0} };
    public boolean checkSafe(int[][] board){
        QueensModel ne = new QueensModel();
        chessBoard = board;
        for(int i = 0;i < chessBoard.length; i++){
            for(int j = 0; j < chessBoard[i].length;j++){
                if(chessBoard[i][j] == 1){
                    if(ne.checkSafety(chessBoard, i, j) == true){
                        continue;
                    }
                    else if(ne.checkSafety(chessBoard, i, j) == false){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
