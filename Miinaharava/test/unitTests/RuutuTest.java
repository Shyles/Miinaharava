
package unitTests;

import miinaharava.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RuutuTest {
    
    public Ruutu ruutu;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruutu = new Ruutu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void revealUnderneathdDoesNothingIfFlagged() {
        ruutu.setFlagged(true);
        ruutu.revealUnderneath();
        assertEquals("revealUnderneath set opened even if flagged",ruutu.isOpened(), false);
    }
    
    @Test
    public void revealUnderneathUpdatesOpened() {
        ruutu.setFlagged(false);
        ruutu.setOpened(false);
        ruutu.revealUnderneath();
        assertEquals("revealUnderneath didn't set opened true", true, ruutu.isOpened());
    }
}
