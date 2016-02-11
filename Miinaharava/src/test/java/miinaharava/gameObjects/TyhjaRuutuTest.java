package miinaharava.gameObjects;

import miinaharava.gameObjects.Ruutu;
import miinaharava.gameObjects.TyhjaRuutu;
import junit.framework.Assert;
import miinaharava.GameBoard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TyhjaRuutuTest {
    
    public TyhjaRuutu tyhjaruutu;
    
    public TyhjaRuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tyhjaruutu = new TyhjaRuutu(new GameBoard(), 1,1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void inheritsRuutu() {
         if (!(tyhjaruutu instanceof Ruutu)) {
            Assert.fail("TyhjaRuutu isn't inherited!");
        } else if (tyhjaruutu.isFlagged() != false) {
            Assert.fail("Flagged isn't false!");
        } 
    }
}
