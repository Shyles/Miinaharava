package miinaharava;

import miinaharava.gameObjects.MiinaRuutu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import miinaharava.gameObjects.Ruutu;

public class GameBoard {

    private Ruutu[][] gameboard;
    private Integer[] availableAmountsArray = {};
    private Set<Integer> availableAmounts;
    private int mineAmount;
    private int boxAmount;

    public GameBoard() {
    }

    //Creates the board with randomized mine locations
    public void newBoard(int boxAmount, int mineAmount) throws Exception {
        if (availableAmounts.contains(boxAmount)) {
            this.boxAmount = boxAmount;
            this.mineAmount = mineAmount;
            gameboard = new Ruutu[6][6];
            createBoard(boxAmount);
        } else {
            throw new RuntimeException("Invalid argument. Currently supports integers " + availableAmounts.toString());
        }
    }

    private void createBoard(int boxAmount) {
        int mineAmount = 6;
        boxAmount = 36;
    }

    public void setAvailableAmounts(Integer[] availableAmountsArray) {
        this.availableAmountsArray = availableAmountsArray;
        this.availableAmounts = new HashSet(Arrays.asList(availableAmountsArray));
    }

    public Set<Integer> getAvailableAmounts() {
        return availableAmounts;
    }

    public void randomizeMineLocations() {
        Random rand = new Random();
        int rows = gameboard.length;
        int cols = gameboard.length;
        for (int i = 0; i < mineAmount;) {
            int rowLoc = rand.nextInt(rows);
            int colLoc = rand.nextInt(cols);
            if (gameboard[rowLoc][colLoc] == null) {
                gameboard[rowLoc][colLoc] = new MiinaRuutu(this, rowLoc, colLoc);
                i++;
            }
        }
    }

    public void createEmptiesAndNumbers() {
        for (Ruutu[] ruutuArr : gameboard) {
            for (Ruutu ruutu : ruutuArr) {
                if (ruutu instanceof MiinaRuutu) {
                    continue;
                }

            }
        }
    }

    public ArrayList<Ruutu> getNeighbours(Ruutu ruutu) {
        ArrayList<Ruutu> neighbours = new ArrayList<Ruutu>();
        int rowAmount = ruutu.getRow();
        int colAmount = ruutu.getCol();
        for (int col = colAmount - 1; col < colAmount + 2; col++) {
            for (int row = rowAmount - 1; row < rowAmount + 2; row++) {
                if (row == rowAmount && col == colAmount) {
                    continue;
                }
                try {
                    neighbours.add(gameboard[col][row]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return neighbours;
    }

    public void setMineAmount(int mineAmount) {
        this.mineAmount = mineAmount;
    }

    public void setGameboard(Ruutu[][] gameboard) {
        this.gameboard = gameboard;
    }

    public Ruutu[][] getGameboard() {
        return gameboard;
    }

    public int openRuutu(int col, int row) {
        gameboard[col][row].revealUnderneath();
        return 0;
    }

    public int getMineAmount() {
        return mineAmount;
    }

    public int getBoxAmount() {
        return boxAmount;
    }
    
    public Ruutu getRuutuInLocation(int row, int col) {
        return gameboard[col][row];
    }
    
    

}
