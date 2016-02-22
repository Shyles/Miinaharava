package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import fi.ui.RuutuButton;
import java.awt.Color;

/**
 * Luokka on ylÃ¤kÃ¤site Miina-, Tyhja- ja NumeroRuudulle. Kaikilla Ruudut
 * tietÃ¤vÃ¤t sijaintinsa niihin liitetyssÃ¤ GameBoardissa. Ruutu tietÃ¤Ã¤ myÃ¶s onko
 * se aukaistu ja onko se liputettu. MyÃ¶s tieto minkÃ¤laiseksi RuutuButtonin
 * nappi tulee sitÃ¤ painettaessa lÃ¶ytyy Ruudusta.
 */
public class Ruutu {

    private boolean flagged = false;
    private boolean opened = false;
    private final int row;
    private final int col;
    protected GameBoard gb;
    protected Color color;
    protected String toBePrintedOnRuutuButton;
    protected int mineNeighbours;
    protected RuutuButton ruutuButton;

    /**
     * Konstruktori.
     * @param gb PÃ¶ytÃ¤ johon Ruutu on liitetty.
     * @param row Ruudun rivi.
     * @param col Ruudun kolumni.
     */
    public Ruutu(GameBoard gb, int row, int col) {
        this.gb = gb;
        this.row = row;
        this.col = col;
        this.color = Color.BLUE;
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
    
    /**
     * Reveals the underneath of Ruutu and acts accordingly.
     */
    public void revealUnderneath() {
        if (opened) {
            return;
        }
        setOpened(true);
        ruutuButton.renderOpen();
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

    public Color getColor() {
        return color;
    }

    public String getToBePrintedOnRuutuButton() {
        return toBePrintedOnRuutuButton;
    }

    public void setToBePrintedOnRuutuButton(String toBePrintedOnRuutuButton) {
        this.toBePrintedOnRuutuButton = toBePrintedOnRuutuButton;
    }

    public int getMineNeighbours() {
        return mineNeighbours;
    }

    public void setUpTyhjaOrNumeroRuutu() {
    }

    public void setRuutuButton(RuutuButton ruutuButton) {
        this.ruutuButton = ruutuButton;
    }

    public RuutuButton getRuutuButton() {
        return ruutuButton;
    }
}
