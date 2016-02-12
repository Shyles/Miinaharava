package miinaharava;

/**
 * Luokka huolehtii miinaharava-pelin logiikasta aukaisemalla ruutuja Logiikkaan liitetystä GameBoardista.
 * 
 */

public class Logiikka {

    GameBoard currentBoard;
    String gameEndingString;

    public Logiikka() {
    }

    public void newGame(int sizeOfBoard) throws Exception {
        GameBoard board = new GameBoard();
        board.newBoard(sizeOfBoard, 1);
    }

    public void open(int col, int row) {
        currentBoard.openRuutu(col, row);
        int loseIfZero = currentBoard.getGameContinues();
        System.out.println(loseIfZero);
        switch (loseIfZero) {
            case 0:
                gameEndingString = loseGame();
                System.out.println(currentBoard.getGameContinues());
                endGame();
                break;
            case 1:
                gameEndingString = winGame();
                System.out.println(currentBoard.getGameContinues());
                endGame();
                break;
        }
    }

    public String loseGame() {
        return "Lost the game";
    }

    public String winGame() {
        return "Won the game";
    }

    private void endGame() {
        System.out.println(gameEndingString);
    }
}
