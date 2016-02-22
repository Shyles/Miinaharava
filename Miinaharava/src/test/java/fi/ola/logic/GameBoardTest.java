package fi.ola.logic;

import fi.ola.logic.GameBoard;
import fi.ola.tiles.MiinaRuutu;
import fi.ola.tiles.NumeroRuutu;
import fi.ola.tiles.Ruutu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
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

    public GameBoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private GameBoard gameboard;
    private Integer[] availableAmounts = {9, 16, 25, 36};
    private TestUtils utilityFactory = new TestUtils();
    private Logiikka logiikka = new Logiikka();

    @Before
    public void setUp() {
        gameboard = new GameBoard();
        gameboard.setAvailableAmountsFromArray(availableAmounts);
        logiikka.currentBoard = gameboard;
    }

//    private void setUpNewGameBoard(GameBoard gb) {
//        try {
//            gb.newBoard(36, 6);
//            gb.randomizeMineLocations();
//            gb.createEmptiesAndNumbers();
//        } catch (Exception e) {
//            System.out.println("Failed to set up a new board");
//        }
//    }

    @After
    public void tearDown() {
    }

    @Test
    public void avalaibleAmountsSetContainsCorrectValues() {
        Set<Integer> expected = new HashSet(Arrays.asList(new Integer[]{9, 16, 25, 36}));
        assertEquals("Available amounts differ from expected.", expected, gameboard.getAvailableAmounts());
    }

    @Test
    public void doesntCreateUnsupportedBoardsize() {
        try {
            gameboard.newBoard(10000000, 5);
            Assert.fail();
        } catch (Exception e) {
            String expected = "Invalid argument. Currently supports integers " + gameboard.getAvailableAmounts().toString();
            assertEquals("Exception message must be correct", expected, e.getMessage());
        }
    }

    @Test
    public void randomizeMineLocationsMakesCorrectAmountOfMines() {
        gameboard.setGameboard(new Ruutu[6][6]);
        gameboard.setMineAmount(6);
        logiikka.randomizeMineLocations();
        int mineAmount = 0;
        for (Ruutu[] ruutuArray : gameboard.getGameboard()) {
            for (Ruutu ruutu1 : ruutuArray) {
                if (ruutu1 instanceof MiinaRuutu) {
                    mineAmount++;
                }
            }
        }
        assertEquals(6, mineAmount);
    }

    @Test
    public void getNeighboursReturnsCorrectNeigbhourAmount() {
        GameBoard gb = new GameBoard();
        Ruutu[][] arr = getArrayFilledWithRuutu(gb, 6, 6);
        gb.setGameboard(arr);

        int supposedToBeEight = gb.getNeighbours(gb.getGameboard()[1][1]).size();
        int supposedToBeFive = gb.getNeighbours(gb.getGameboard()[1][0]).size();
        int supposedToBeThree = gb.getNeighbours(gb.getGameboard()[5][5]).size();
        int[] output = {supposedToBeEight, supposedToBeFive, supposedToBeThree};
        int[] expected = {8, 5, 3};

        assertArrayEquals(expected, output);
    }

    private Ruutu[][] getArrayFilledWithRuutu(GameBoard gb, int rows, int cols) {
        Ruutu[][] arr = new Ruutu[rows][cols];
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {

                arr[i][j] = new Ruutu(gb, i, j);
            }
        }
        return arr;
    }

    @Test
    public void getNeighboursDoesntMindOutOfBoundsExceptions() {
        Ruutu[][] arr = getArrayFilledWithRuutu(gameboard, 6, 6);
        gameboard.setGameboard(arr);
        try {
            gameboard.getNeighbours(gameboard.getGameboard()[0][0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Caught array out of bounds exception");
        }
    }

    @Test
    public void getNeighboursReturnsCorrectNeighbours() {
        Ruutu[][] arr = getArrayFilledWithRuutu(gameboard, 6, 6);
        gameboard.setGameboard(arr);
        ArrayList<Ruutu> expectedList = new ArrayList<>();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (row == 1 && col == 1) {
                    continue;
                }
                expectedList.add(gameboard.getGameboard()[col][row]);
            }
        }
        ArrayList<Ruutu> outputList = gameboard.getNeighbours(gameboard.getGameboard()[1][1]);
        assertEquals(expectedList, outputList);
    }

    @Test
    public void getRuutuInLocationReturnsCorrectRuutu() {
        utilityFactory.setUpNewTestGameBoard(logiikka);
        for (int col = 0; col < gameboard.getCols(); col++) {
            for (int row = 0; row < gameboard.getRows(); row++) {     
                Ruutu methodRetrieved = gameboard.getRuutuInLocation(row, col);
                Ruutu expected = gameboard.getGameboard()[(int) col][(int) row];

                if (!methodRetrieved.equals(expected)) {
                    Assert.fail("Ruutu retrieved with getRuutuInLocation didn't match with ruutu in location column:" + col + " row:" + row);
                }
            }
        }
    }
    

}
