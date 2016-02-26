package fi.ola.logic;

import fi.ola.tiles.MiinaRuutu;
import fi.ola.tiles.NumeroRuutu;
import fi.ola.tiles.Ruutu;
import fi.ola.tiles.TyhjaRuutu;
import fi.ui.MinesweeperUI;
import java.util.Random;

/**
 * Luokka huolehtii miinaharava-pelin logiikasta aukaisemalla ruutuja Logiikkaan
 * liitetystä GameBoardista.
 *
 */
public class Logiikka {

    public GameBoard currentBoard;
    public String gameEndingString;
    private MinesweeperUI userInterface;

    /**
     * Ei tee mitään erikoista.
     */
    public Logiikka() {
    }

    /**
     * Tells interface to render a lost game.
     */
    public void endLosingGame() {
        userInterface.renderAllRuutuButtonsOpen();
        userInterface.popupLostGameDialoque();
    }

    
    /**
     * Tells interface to render a won game.
     */
    public void endWinningGame() {
        userInterface.renderAllRuutuButtonsOpen();
        userInterface.popupLostGameDialoque();
    }

    /**
     * Luo uuden pöydän.
     *
     * @param boxesAndMines Ruutujen ja MiinaRuutujen määrä, indeksissä 0 on Ruutujen kokonaismäärä.
     * @throws Exception Kaikki.
     */
    public void newGame(int[] boxesAndMines) throws Exception {
        currentBoard = new GameBoard();
        currentBoard.setLogiikka(this);
        currentBoard.newBoard(boxesAndMines[0], boxesAndMines[1]);
        randomizeMineLocations();
        createEmptiesAndNumbers();
    }

    /**
     * Sijoittaa mineAmount-määrän MiinaRuutuja GameBoardiin. Toimii vain
     * tyhjälle laudalle.
     */
    public void randomizeMineLocations() {
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
     * Hävityn pelin viesti.
     *
     * @return Häviäjälle tervehdys.
     */
    public String loseGame() {
        return "Lost the game";
    }

    /**
     * Voitokkaan pelin viesti.
     *
     * @return Voittajalle tervehdys.
     */
    public String winGame() {
        return "Won the game";
    }

    public void setUserInterface(MinesweeperUI userInterface) {
        this.userInterface = userInterface;
    }

}
