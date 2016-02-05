
package miinaharava;


public class Ruutu {
    
    private boolean flagged = false;
    private boolean opened = false;
    private int row;
    private int col;
    private GameBoard gb;

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
    
    
    
}
