package fi.ola.tiles;

import fi.ola.tiles.NumeroRuutu;
import fi.ola.tiles.Ruutu;
import junit.framework.Assert;
import fi.ola.logic.GameBoard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumeroRuutuTest {

    public NumeroRuutu numeroruutu;

    public NumeroRuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        numeroruutu = new NumeroRuutu(new GameBoard(), 1,1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void inheritsRuutu() {
        if (!(numeroruutu instanceof Ruutu)) {
            Assert.fail("Ruutu isn't inherited!");
        } else if (numeroruutu.isFlagged() != false) {
            Assert.fail("Flagged isn't false!");
        }
    }
}
