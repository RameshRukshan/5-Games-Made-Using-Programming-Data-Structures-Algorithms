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
    public boolean checkSafe(int row1,int col1,int row2,int col2,int row3,int col3,int row4,int col4,int row5,int col5,int row6,int col6,int row7,int col7,int row8,int col8){
        QueensModel ne = new QueensModel();
        chessBoard[row1][col1] = 1;
        chessBoard[row2][col2] = 1;
        chessBoard[row3][col3] = 1;
        chessBoard[row4][col4] = 1;
        chessBoard[row5][col5] = 1;
        chessBoard[row6][col6] = 1;
        chessBoard[row7][col7] = 1;
        chessBoard[row8][col8] = 1;
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
