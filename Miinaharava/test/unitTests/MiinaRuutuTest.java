/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTests;

import junit.framework.Assert;
import miinaharava.MiinaRuutu;
import miinaharava.Ruutu;
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
public class MiinaRuutuTest {

    public MiinaRuutu miinaruutu;

    public MiinaRuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        miinaruutu = new MiinaRuutu();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void inheritsRuutu() {
        if (!(miinaruutu instanceof Ruutu)) {
            Assert.fail("Ruutu isn't inherited!");
        } else if (miinaruutu.isFlagged() != false) {
            Assert.fail("Flagged isn't false!");
        }
    }
}
