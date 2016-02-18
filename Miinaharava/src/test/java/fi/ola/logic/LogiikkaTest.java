
package fi.ola.logic;

import fi.ola.logic.Logiikka;
import fi.ola.logic.GameBoard;
import junit.framework.Assert;
import fi.ola.tiles.MiinaRuutu;
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
        logiikka.currentBoard = new GameBoard();
        logiikka.currentBoard.setUpNewTestGameBoard();
    }
    
    @After
    public void tearDown() {
    }
    
    private void putMineInLocation(int col, int row) {
        this.logiikka.currentBoard.getGameboard()[col][row] = new MiinaRuutu(this.logiikka.currentBoard, row, col);
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
    
    @Test
    public void openRuutuEndingGameStringIsCorrectIfMiinaIsOpened() {
        int col = 1;
        int row = 5;
        putMineInLocation(col, row);
        logiikka.open(col, row);
        System.out.println(logiikka.currentBoard.getGameContinues());
        assertEquals(logiikka.loseGame(), logiikka.gameEndingString);
    }
}
