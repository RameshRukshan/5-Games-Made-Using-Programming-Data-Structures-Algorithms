/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chiran
 */
public class QueensControlTest {
    
    @Test
    public void testCheckSafeWithNoQueens() {
        QueensControl control = new QueensControl();
        int[][] board = new int[8][8]; // An empty board
        assertTrue("Board should be safe with no queens", control.checkSafe(board));
    }

    @Test
    public void testCheckSafeWithOneQueen() {
        QueensControl control = new QueensControl();
        int[][] board = new int[8][8];
        board[0][0] = 1; // Place one queen at the top-left corner
        assertTrue("Board should be safe with one queen", control.checkSafe(board));
    }

    @Test
    public void testCheckSafeWithQueensAttackingEachOther() {
        QueensControl control = new QueensControl();
        int[][] board = new int[8][8];
        board[0][0] = 1; // Place one queen at the top-left corner
        board[0][1] = 1; // Place another queen next to the first one, horizontal attack
        assertFalse("Board should not be safe", control.checkSafe(board));
    }
    
    @Test
    public void testCheckSafeWithSafePlacements() {
        QueensControl control = new QueensControl();
        int[][] board = new int[8][8];
        board[0][0] = 1; // Place one queen at the top-left corner
        board[1][2] = 1; // Place another queen, no direct attacks
        board[2][4] = 1; // Further placement, still no attacks
        assertTrue("Board should be safe", control.checkSafe(board));
    }
    
}
