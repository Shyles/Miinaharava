package fi.ola.minesweeper;

import fi.ola.logic.GameBoard;
import fi.ola.logic.Logiikka;
import fi.ola.logic.TestUtils;
import fi.ola.tiles.Ruutu;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestUtils utilityFactory = new TestUtils();
        GameBoard gameboard = new GameBoard();
        Logiikka logiikka = new Logiikka();
        logiikka.currentBoard = gameboard;
        utilityFactory.createNewGameBoardFilledWithEmptyRuutu(logiikka);
        utilityFactory.setUpMiinaRuutuInLocations(new Integer[] {1,0, 2,0}, gameboard);
        logiikka.createEmptiesAndNumbers();
        Ruutu zeroZero = gameboard.getGameboard()[0][0];
        Ruutu oneOne = gameboard.getGameboard()[1][1];
        Ruutu twoOne = gameboard.getGameboard()[0][0];
    }

}
