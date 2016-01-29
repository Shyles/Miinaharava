
package miinaharava;


public class Ruutu {
    
    private boolean flagged = false;
    private boolean opened = false;

    public Ruutu() {
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
    
    
}
