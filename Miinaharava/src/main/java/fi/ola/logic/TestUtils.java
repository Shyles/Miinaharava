package fi.ola.logic;

import fi.ola.tiles.MiinaRuutu;

/**
 * Utilities for tests and debugging.
 *
 * @author Olaml
 */
public class TestUtils {

    /**
     * Only creates it.
     */
    public TestUtils() {
    }

    /**
     * Creates a GameBoard for Logiikka, filled with TyhjaRuutu.
     *
     * @param logiikka Gets a GameBoard with TyhjaRuutu.
     */
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

    /**
     * Kovakoodattu testipöydän rakentaminen.
     *
     * @param logiikka Logiikka to be set up.
     */
    public void setUpNewTestGameBoard(Logiikka logiikka) {
        GameBoard gb = logiikka.currentBoard;
        gb.setLogiikka(logiikka);
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

    /**
     * Creates MiinaRuutus in given locations.
     *
     * @param locations Location is given in pairs, column after row.
     * @param gb Creates MiinaRuutus here.
     */
    public void setUpMiinaRuutuInLocations(Integer[] locations, GameBoard gb) {
        for (int i = 0; i < locations.length; i += 2) {
            int row = locations[i];
            int col = locations[i + 1];
            gb.getGameboard()[row][col] = new MiinaRuutu(gb, row, col);
        }
    }

}
