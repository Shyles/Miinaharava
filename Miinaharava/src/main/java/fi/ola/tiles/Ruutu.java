
package fi.ola.tiles;

import fi.ola.logic.GameBoard;

/**
 * Luokka on yläkäsite Miina-, Tyhja- ja NumeroRuudulle. Kaikilla Ruudut tietävät sijaintinsa niihin liitetyssä GameBoardissa.
 */
public class Ruutu {
    
    private boolean flagged = false;
    private boolean opened = false;
    private int row;
    private int col;
    protected GameBoard gb;

    public Ruutu(GameBoard gb, int row, int col) {
        this.gb = gb;
        this.row = row;
        this.col = col;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isOpened() {
        return opened;
    }
    
    
    
    public void revealUnderneath() {
        if (flagged) {
            return;
        }
        setOpened(true);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    
   
    
    @Override
    public boolean equals(Object compareTo) {
        boolean result = false;
        if (compareTo instanceof Ruutu) {
            Ruutu otherRuutu = (Ruutu) compareTo;
            if (this.flagged == otherRuutu.flagged && this.opened == otherRuutu.opened) {
                if (this.row == otherRuutu.row && this.col == otherRuutu.col) {
                    result = true;
                }
            }
        }
        return result;
    }
    
    
    
}
