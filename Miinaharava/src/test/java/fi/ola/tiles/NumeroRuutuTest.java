package fi.ola.tiles;

import fi.ola.tiles.NumeroRuutu;
import fi.ola.tiles.Ruutu;
import junit.framework.Assert;
import fi.ola.logic.GameBoard;
import fi.ola.logic.Logiikka;
import fi.ola.logic.TestUtils;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumeroRuutuTest {

    private NumeroRuutu numeroruutu;
    private TestUtils utilityFactory = new TestUtils();
    private Logiikka logiikka = new Logiikka();

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
        numeroruutu = new NumeroRuutu(new GameBoard(), 1, 1);

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

    @Test
    public void setsNeighbouringMinesAmountCorrectly() {
        GameBoard gb = new GameBoard();
        logiikka.currentBoard = gb;
        utilityFactory.createNewGameBoardFilledWithEmptyRuutu(logiikka);
        utilityFactory.setUpMiinaRuutuInLocations(new Integer[] {1,0, 1,2, 2,0}, gb);
        
        NumeroRuutu keskiRuutu = new NumeroRuutu(gb, 1, 1);
        gb.getGameboard()[1][1] = keskiRuutu;
        keskiRuutu.setUpTyhjaOrNumeroRuutu();
        
        assertEquals(3, keskiRuutu.getMineNeighbours());

    }
}
