package fi.ola.logic;

import fi.ola.tiles.MiinaRuutu;
import fi.ola.tiles.NumeroRuutu;
import fi.ola.tiles.Ruutu;
import fi.ola.tiles.TyhjaRuutu;
import java.util.Random;

/**
 * Luokka huolehtii miinaharava-pelin logiikasta aukaisemalla ruutuja Logiikkaan
 * liitetystä GameBoardista.
 *
 */
public class Logiikka {

    public GameBoard currentBoard;
    public String gameEndingString;

    /**
     * Ei tee mitään erikoista.
     */
    public Logiikka() {
    }

    /**
     * Luo uuden pöydän, keskeneräinen.
     * 
     * @param sizeOfBoard Pöydän koko.
     * @throws Exception Kaikki.
     */
    public void newGame(int sizeOfBoard) throws Exception {
        GameBoard board = new GameBoard();
        board.newBoard(sizeOfBoard, 1);
    }
    
        /**
     * Sijoittaa mineAmount-määrän MiinaRuutuja GameBoardiin. Toimii vain
     * tyhjälle laudalle. Ei tee mitään jos lauta, miinojen määrä tai ruutujen
     * määrä on null.
     */
    public void randomizeMineLocations() {
//        if (gameboard == null || mineAmount == null || boxAmount == null) {
//        }
        Random rand = new Random();
        Ruutu[][] gameboardArray = currentBoard.getGameboard();

        int rowAmount = gameboardArray.length;
        int colAmount = gameboardArray.length;
        for (int i = 0; i < currentBoard.getMineAmount();) {
            int rowLocation = rand.nextInt(rowAmount);
            int columnLocation = rand.nextInt(colAmount);
            if (gameboardArray[rowLocation][columnLocation] == null) {
                gameboardArray[rowLocation][columnLocation] = new MiinaRuutu(currentBoard, rowLocation, columnLocation);
                i++;
            }
        }
    }
    
        /**
     * Täyttää pelilaudan TyhjaRuuduilla ja NumeroRuuduilla loogisesti oikein.
     */
    public void createEmptiesAndNumbers() {
        Ruutu[][] gameboardArray = currentBoard.getGameboard();
        for (int col = 0; col < currentBoard.getCols(); col++) {
            for (int row = 0; row < currentBoard.getRows(); row++) {
                if (gameboardArray[col][row] instanceof MiinaRuutu) {
                    continue;
                }
                gameboardArray[col][row] = new Ruutu(currentBoard, row, col);
            }
        }
        for (int col = 0; col < currentBoard.getCols(); col++) {
            for (int row = 0; row < currentBoard.getRows(); row++) {
                if (gameboardArray[col][row] instanceof MiinaRuutu) {
                    continue;
                }
                if (currentBoard.neighboursContainMiinaRuutu(gameboardArray[col][row])) {
                    gameboardArray[col][row] = new NumeroRuutu(currentBoard, row, col);
                    gameboardArray[col][row].setUpTyhjaOrNumeroRuutu();
                } else {
                    gameboardArray[col][row] = new TyhjaRuutu(currentBoard, row, col);
                    gameboardArray[col][row].setUpTyhjaOrNumeroRuutu();
                }
            }
        }
    }

    /**
     * Avaa Ruudun sijannissa x,y.
     * 
     * @param col Kolumni.
     * @param row Rivi.
     */
    public void open(int col, int row) {
        currentBoard.openRuutu(col, row);
        int loseIfZero = currentBoard.getGameContinues();
        System.out.println(loseIfZero);
        switch (loseIfZero) {
            case 0:
                gameEndingString = loseGame();
                endGame();
                break;
            case 1:
                gameEndingString = winGame();
                endGame();
                break;
        }
    }

    /**
     * Hävityn pelin viesti.
     * @return Häviäjälle tervehdys-
     */
    public String loseGame() {
        return "Lost the game";
    }

    /**
     * Voitokkaan pelin viesti.
     * @return Voittajalle tervehdys.
     */
    public String winGame() {
        return "Won the game";
    }

    private void endGame() {
        System.out.println(gameEndingString);
    }
}
