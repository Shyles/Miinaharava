
package miinaharava;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogiikkaTest {
    
    public Logiikka logiikka;
    
    public LogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        logiikka = new Logiikka();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void newGameThrowsException() {
        try { 
            logiikka.newGame(10);
            Assert.fail("New game didn't throw exception");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
    
    @Test
    public void loseGameReturnsCorrectMessage() {
        String txt = "Lost the game";
        assertEquals(txt, logiikka.loseGame());
    }
    
    @Test
    public void winGameReturnsCorrectMessage() {
        String txt = "Won the game";
        assertEquals(txt, logiikka.winGame());
    }
}
