/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chiran
 */
public class TicTacToeControlTest {
    
    public TicTacToeControlTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of computeMove method, of class TicTacToeControl.
     */
    @Test
    public void testComputeMove() {
        System.out.println("computeMove");
        int[][] board = null;
        TicTacToeControl instance = new TicTacToeControl();
        int[][] expResult = null;
        int[][] result = instance.computeMove(board);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluvateTheBoard method, of class TicTacToeControl.
     */
    @Test
    public void testEvaluvateTheBoard() {
        System.out.println("evaluvateTheBoard");
        int[][] board = null;
        TicTacToeControl instance = new TicTacToeControl();
        String expResult = "";
        String result = instance.evaluvateTheBoard(board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
