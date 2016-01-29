package miinaharava;

public class Logiikka {

    public Logiikka() {
    }

    public void newGame(int sizeOfBoard) throws Exception {
        GameBoard board = new GameBoard();
        board.newBoard(sizeOfBoard);
    }
    
    public String loseGame() {
        return "Lost the game";
    }
    
    public String winGame() {
        return "Won the game";
    }
}
