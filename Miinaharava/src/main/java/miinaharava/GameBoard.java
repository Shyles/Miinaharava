package miinaharava;

import miinaharava.gameObjects.MiinaRuutu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import miinaharava.gameObjects.Ruutu;
import miinaharava.gameObjects.TyhjaRuutu;

/**
 * Luokka huolehtii miinaharavan kentästä pitäen yllä jäljellä olevien ei-MiinaRuutujen jäljellä olevaa määrää.
 * Luokalla on tieto kentän koosta ja jokaisen Ruudun sijainnista. Tarjoaa myös työkalut uusien pöytien luomiseen.
 */

public class GameBoard {

    private Ruutu[][] gameboard;
    private Integer[] availableAmountsArray = {36};
    private Set<Integer> availableAmounts;
    private Integer mineAmount;
    private Integer boxAmount;
    private double rows;
    private double cols;
    private int gameContinues;

    public GameBoard() {
    }

/**
 * Luokka tarjoaa useita todennäköisyyslaskentaan tarvittavia metodeita.
 */
    public void newBoard(int boxAmount, int mineAmount) throws Exception {
        if (availableAmounts.contains(boxAmount)) {
            this.mineAmount = mineAmount;
            this.boxAmount = boxAmount;
            setUpRowsAndCols();
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

    /**
     * Sijoittaa mineAmount-määrän MiinaRuutuja GameBoardiin. Toimii vain tyhjälle laudalle.
     * Ei tee mitään jos lauta, miinojen määrä tai ruutujen määrä on null.
     */
    public void randomizeMineLocations() {
        if (gameboard == null || mineAmount == null || boxAmount == null)  {
        }
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
    
    /**
     * Täyttää pelilaudan TyhjaRuuduilla ja NumeroRuuduilla loogisesti oikein.
     */

    public void createEmptiesAndNumbers() {
        int miina = 1;
        int eiMiina = 1;
        for (int col = 0; col < this.cols; col++) {
            for (int row = 0; row < this.rows; row++) {
                Ruutu ruutu = gameboard[col][row];
                if (ruutu instanceof MiinaRuutu) {continue;}
                    //TODO add howtocreatenumbers
                    gameboard[col][row] = new TyhjaRuutu(this, row, col);

            }
        }
    }
    
    /**
     * Palauttaa Ruudun kaikki naapurit, määrä on 8, 5 tai 3 sijainnista riippuen.
     * @param Ruutu jonka naapurit halutaan tietoon.
     * @return ArrayList parametrin naapuriRuuduista.
     */

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

    public void setUpNewTestGameBoard() {
        setAvailableAmounts(availableAmountsArray);
        try {
            newBoard(36, 6);
            randomizeMineLocations();
            createEmptiesAndNumbers();
        } catch (Exception e) {
            System.out.println("Failed to set up a new board");
        }
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
        gameboard[row][col].revealUnderneath();
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

    private void setUpRowsAndCols() {
        this.rows = Math.sqrt(boxAmount);
        this.cols = Math.sqrt(boxAmount);
    }

    public double getCols() {
        return cols;
    }

    public double getRows() {
        return rows;
    }

    public int getGameContinues() {
        return gameContinues;
    }

    public void setGameContinues(int gameContinues) {
        this.gameContinues = gameContinues;
    }

    
}
