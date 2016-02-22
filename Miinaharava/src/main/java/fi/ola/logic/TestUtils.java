package fi.ola.logic;

import fi.ola.tiles.MiinaRuutu;
import java.util.ArrayList;

public class TestUtils {

    public void createNewGameBoardFilledWithEmptyRuutu(Logiikka logiikka) {
        Integer[] availableAmountsArray = {36};
        GameBoard gb = logiikka.currentBoard;
        gb.setAvailableAmountsFromArray(availableAmountsArray);
        try {
            gb.newBoard(36, 0);
            logiikka.createEmptiesAndNumbers();
        } catch (Exception e) {
            System.out.println("Failed to set up a new test board in createNewGameBoardFilledWithEmptyRuutu.");
        }
    }

    public TestUtils() {
    }

    /**
     * Kovakoodattu testipöydän rakentaminen.
     */
    public void setUpNewTestGameBoard(Logiikka logiikka) {
        GameBoard gb = logiikka.currentBoard;
        Integer[] availableAmountsArray = {36};
        gb.setAvailableAmountsFromArray(availableAmountsArray);
        try {
            gb.newBoard(36, 6);
            logiikka.randomizeMineLocations();
            logiikka.createEmptiesAndNumbers();
        } catch (Exception e) {
            System.out.println("Failed to set up a new test board in setUpNewTestGameBoard");
        }
    }

    public void setUpMiinaRuutuInLocations(Integer[] locations, GameBoard gb) {
        for (int i = 0; i < locations.length; i += 2) {
            int row = locations[i];
            int col = locations[i + 1];
            gb.getGameboard()[row][col] = new MiinaRuutu(gb, row, col);
        }
    }

}
