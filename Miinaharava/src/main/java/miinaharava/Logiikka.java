package miinaharava;

public class Logiikka {
    
    GameBoard currentBoard;

    public Logiikka() {
    }

    public void newGame(int sizeOfBoard) throws Exception {
        GameBoard board = new GameBoard();
        board.newBoard(sizeOfBoard, 1);
    }
    
    public void open(int col, int row) {
        currentBoard.openRuutu(col, row);
    }
    
    public String loseGame() {
        return "Lost the game";
    }
    
    public String winGame() {
        return "Won the game";
    }
}
