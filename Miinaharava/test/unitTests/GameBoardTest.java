package unitTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
import miinaharava.GameBoard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Olaml
 */
public class GameBoardTest {
    
    private GameBoard gameboard;
    public GameBoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    Integer[] availableAmounts = {9, 16, 25}; 
    @Before
    public void setUp() {
       gameboard = new GameBoard();
       gameboard.setAvailableAmounts(availableAmounts);

    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void avalaibleAmountsSetContainsCorrectValues() {
       Set<Integer> expected = new HashSet(Arrays.asList(new Integer [] {9,16,25}));
       assertEquals("Available amounts differ from expected." ,expected, gameboard.getAvailableAmounts());
    } 
    
    @Test
    public void doesntCreateUnsupportedBoardsize() {
        try {
            gameboard.newBoard(10000000);
            Assert.fail();
        } catch (Exception e) {
            String expected = "Invalid argument. Currently supports integers " + gameboard.availableAmounts.toString();
            assertEquals("Exception message must be correct",expected, e.getMessage());
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
