package fi.ola.logic;

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
