package fi.ola.logic;

import fi.ola.tiles.MiinaRuutu;
import fi.ola.tiles.NumeroRuutu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import fi.ola.tiles.Ruutu;
import fi.ola.tiles.TyhjaRuutu;

/**
 * Luokka huolehtii miinaharavan kentästä pitäen yllä jäljellä olevien
 * ei-MiinaRuutujen jäljellä olevaa määrää. Luokalla on tieto kentän koosta ja
 * jokaisen Ruudun sijainnista. Tarjoaa myös työkalut uusien pöytien luomiseen.
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

    /**
     * Ei tee mitään erikoista.
     */
    public GameBoard() {
    }

    /**
     * Rakentaa uuden laudan.
     *
     * @param boxAmount Ruutujen määrä
     * @param mineAmount MiinaRuutujen määrä
     *
     * @throws RuntimeException Custom made.
     */
    public void newBoard(int boxAmount, int mineAmount) throws RuntimeException {
        if (availableAmounts.contains(boxAmount)) {
            this.mineAmount = mineAmount;
            this.boxAmount = boxAmount;
            setUpRowsAndCols();
            gameboard = new Ruutu[6][6];
        } else {
            throw new RuntimeException("Invalid argument. Currently supports integers " + availableAmounts.toString());
        }
    }

    /**
     * Sets availableAmounts from given array.
     *
     * @param availableAmountsArray Array containing available amounts.
     */
    public void setAvailableAmountsFromArray(Integer[] availableAmountsArray) {
        this.availableAmountsArray = availableAmountsArray;
        this.availableAmounts = new HashSet(Arrays.asList(availableAmountsArray));
    }

    public Set<Integer> getAvailableAmounts() {
        return availableAmounts;
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
        int rowAmount = gameboard.length;
        int colAmount = gameboard.length;
        for (int i = 0; i < mineAmount;) {
            int rowLocation = rand.nextInt(rowAmount);
            int columnLocation = rand.nextInt(colAmount);
            if (gameboard[rowLocation][columnLocation] == null) {
                gameboard[rowLocation][columnLocation] = new MiinaRuutu(this, rowLocation, columnLocation);
                i++;
            }
        }
    }

    /**
     * Täyttää pelilaudan TyhjaRuuduilla ja NumeroRuuduilla loogisesti oikein.
     */
    public void createEmptiesAndNumbers() {
        for (int col = 0; col < this.cols; col++) {
            for (int row = 0; row < this.rows; row++) {
                if (gameboard[col][row] instanceof MiinaRuutu) {
                    continue;
                }
                gameboard[col][row] = new Ruutu(this, row, col);
            }
        }
        for (int col = 0; col < this.cols; col++) {
            for (int row = 0; row < this.rows; row++) {
                if (gameboard[col][row] instanceof MiinaRuutu) {
                    continue;
                }
                if (neighboursContainMiinaRuutu(gameboard[col][row])) {
                    gameboard[col][row] = new NumeroRuutu(this, row, col);
                    gameboard[col][row].setUpTyhjaOrNumeroRuutu();
                } else {
                    gameboard[col][row] = new TyhjaRuutu(this, row, col);
                    gameboard[col][row].setUpTyhjaOrNumeroRuutu();
                }
            }
        }
    }

    /**
     * Palauttaa Ruudun kaikki naapurit, määrä on 8, 5 tai 3 sijainnista
     * riippuen.
     *
     * @param ruutu jonka naapurit halutaan tietoon.
     * @return ArrayList parametrin naapuriRuuduista.
     */
    public ArrayList<Ruutu> getNeighbours(Ruutu ruutu) {
        ArrayList<Ruutu> neighbours = new ArrayList<>();
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

    /**
     * Open Ruutu from a given location.
     *
     * @param col Kolumni.
     * @param row Rivi.
     * @return Palauttaa 0 jostain syystä... hmmm?
     */
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

    /**
     * Fetches Ruutu from a given location.
     *
     * @param row Rivi.
     * @param col Kolumni.
     * @return Ruutu in a given location.
     */
    public Ruutu getRuutuInLocation(int row, int col) {
        return gameboard[col][row];
    }

    /**
     * Helper method for setting up rows and cols from given Ruutu amount.
     */
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

    private boolean neighboursContainMiinaRuutu(Ruutu ruutu) {
        ArrayList<Ruutu> naapurit = getNeighbours(ruutu);
        for (Ruutu currentRuutu : naapurit) {
            if (currentRuutu instanceof MiinaRuutu) {
                return true;
            }
        }
        return false;
    }

}
