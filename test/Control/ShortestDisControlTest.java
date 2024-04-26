/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Control;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the ShortestDisControl class.
 */
public class ShortestDisControlTest {
    
    private ShortestDisControl control;

    public ShortestDisControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Setup for the entire test class if needed
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Cleanup for the entire test class if needed
    }
    
    @Before
    public void setUp() {
        control = new ShortestDisControl();
    }
    
    @After
    public void tearDown() {
        // Cleanup after each test if needed
    }

    /**
     * Test of shortestDistance method, of class ShortestDisControl.
     */
    @Test
    public void testShortestDistance() {
        System.out.println("shortestDistance");
        // Assuming map is a 3x3 grid where paths can have any non-negative integer value (0 indicates no path)
        int[][] map = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 0}
        };
        control.shortestDistnace(map);
        assertNotNull("The computed path should not be null", control.computedPath);
    }

    /**
     * Test of checkPlayerAnswer method, of class ShortestDisControl.
     */
    @Test
    public void testCheckPlayerAnswer() {
        System.out.println("checkPlayerAnswer");
        // Assuming the computed path for a simple correct case
        control.computedPath = Arrays.asList(0, 1, 2);
        List<Integer> playerAnswer = Arrays.asList(0, 1, 2);
        boolean expResult = true;
        boolean result = control.checkPlayerAnswer(playerAnswer);
        assertEquals("Player's answer should be correct", expResult, result);
        
        // Test incorrect answer
        List<Integer> wrongAnswer = Arrays.asList(2, 1, 0);
        result = control.checkPlayerAnswer(wrongAnswer);
        assertFalse("Player's answer should be incorrect", result);
    }
}
