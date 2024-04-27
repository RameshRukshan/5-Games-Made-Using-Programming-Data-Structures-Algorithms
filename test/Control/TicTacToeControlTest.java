/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeControlTest {

    private TicTacToeControl control;

    @Before
    public void setUp() {
        control = new TicTacToeControl();
    }

    @Test
    public void testEvaluateBoardPlayerWinsHorizontal() {
        int[][] board = {
            {1, 1, 1},
            {2, 2, 0},
            {0, 0, 0}
        };
        assertEquals("Evaluation should show player win", "player", control.evaluvateTheBoard(board));
    }

    @Test
    public void testEvaluateBoardComputerWinsVertical() {
        int[][] board = {
            {2, 1, 0},
            {2, 1, 0},
            {2, 0, 1}
        };
        assertEquals("Evaluation should show computer win", "computer", control.evaluvateTheBoard(board));
    }

    @Test
    public void testEvaluateBoardDraw() {
        int[][] board = {
            {1, 2, 1},
            {2, 1, 2},
            {2, 1, 1}
        };
        assertEquals("Evaluation should indicate a draw", "draw", control.evaluvateTheBoard(board));
    }

    @Test
    public void testEvaluateBoardPlayerWinsDiagonally() {
        int[][] board = {
            {1, 2, 0},
            {0, 1, 2},
            {0, 0, 1}
        };
        assertEquals("Evaluation should show player win", "player", control.evaluvateTheBoard(board));
    }

    @Test
    public void testEvaluateBoardComputerWinsDiagonally() {
        int[][] board = {
            {2, 0, 1},
            {0, 2, 1},
            {1, 0, 2}
        };
        assertEquals("Evaluation should show computer win", "computer", control.evaluvateTheBoard(board));
    }
}
