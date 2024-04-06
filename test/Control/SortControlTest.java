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
public class SortControlTest {
    
    public SortControlTest() {
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
     * Test of C_Sort_number method, of class SortControl.
     */
    @Test
    public void testC_Sort_number() {
        System.out.println("C_Sort_number");
        SortControl.C_Sort_number();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of C_Sort_displayValues method, of class SortControl.
     */
    @Test
    public void testC_Sort_displayValues() {
        System.out.println("C_Sort_displayValues");
        int[] expResult = null;
        int[] result = SortControl.C_Sort_displayValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of C_Sort_saveResponse method, of class SortControl.
     */
    @Test
    public void testC_Sort_saveResponse() {
        System.out.println("C_Sort_saveResponse");
        int guessedIndex1 = 0;
        int guessedIndex2 = 0;
        boolean resstatus1 = false;
        boolean resstatus2 = false;
        boolean expResult = false;
        boolean result = SortControl.C_Sort_saveResponse(guessedIndex1, guessedIndex2, resstatus1, resstatus2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
