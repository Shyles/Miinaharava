package fi.ola.logic;

import fi.ola.logic.Logiikka;
import fi.ola.logic.GameBoard;
import junit.framework.Assert;
import fi.ola.tiles.MiinaRuutu;
import fi.ola.tiles.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogiikkaTest {

    public Logiikka logiikka;
    public TestUtils utilityFactory;
    public GameBoard gameboard;

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
        gameboard = logiikka.currentBoard;
        utilityFactory = new TestUtils();
        utilityFactory.setUpNewTestGameBoard(logiikka);

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
            logiikka.newGame(new int[] {10, 5});
            Assert.fail("New game didn't throw exception");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void loseGameReturnsCorrectMessage() {
        String txt = "BOOM";
        assertEquals(txt, logiikka.loseGame());
    }

    @Test
    public void winGameReturnsCorrectMessage() {
        String txt = "Gongratulations, you just beat the game!";
        assertEquals(txt, logiikka.winGame());
    }

//    @Test
//    public void openRuutuEndingGameStringIsCorrectIfMiinaIsOpened() {
//        int col = 1;
//        int row = 5;
//        putMineInLocation(col, row);
//        logiikka.open(col, row);
//        assertEquals(logiikka.loseGame(), logiikka.gameEndingString);
//    }
        @Test
    public void createEmptiesAndNumbersCreatesCorrectNumbersForNumeroRuutu() {
        utilityFactory.createNewGameBoardFilledWithEmptyRuutu(logiikka);
        utilityFactory.setUpMiinaRuutuInLocations(new Integer[] {1,0, 2,0}, gameboard);
        logiikka.createEmptiesAndNumbers();
        Ruutu zeroZero = gameboard.getGameboard()[0][0];
        Ruutu oneOne = gameboard.getGameboard()[1][1];
        Ruutu twoOne = gameboard.getGameboard()[0][0];
        
        assertEquals(1, zeroZero.getMineNeighbours());
        assertEquals(2, oneOne.getMineNeighbours());
        assertEquals(1, twoOne.getMineNeighbours());
    }
}
