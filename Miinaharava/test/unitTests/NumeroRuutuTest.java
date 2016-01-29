package unitTests;

import junit.framework.Assert;
import miinaharava.NumeroRuutu;
import miinaharava.Ruutu;
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
        numeroruutu = new NumeroRuutu();
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
