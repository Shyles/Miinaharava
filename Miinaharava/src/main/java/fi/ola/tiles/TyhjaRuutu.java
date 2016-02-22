package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import java.awt.Color;
import java.util.ArrayList;

/**
 * TyhjaRuudun aukaistessa aukaistaan kaikki viereiset Numero- ja TyhjaRuudut.
 */
public class TyhjaRuutu extends Ruutu {

    /**
     * Asettaa ThjaRuudun grafiikat.
     * @param gb Pöytä.
     * @param row Rivi.
     * @param col Kolumni.
     */
    public TyhjaRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
        super.setToBePrintedOnRuutuButton("");
        super.color = Color.GRAY;
    }

    @Override
    public void setToBePrintedOnRuutuButton(String toBePrintedOnRuutuButton) {
        if (super.isOpened()) {
            return;
        }
        setOpened(true);
        ArrayList<Ruutu> neighbours = gb.getNeighbours(this);
        for (Ruutu ruutu : neighbours) {
            if (!ruutu.isOpened() && !(ruutu instanceof MiinaRuutu)) {
                ruutu.revealUnderneath();
            }
        }
    }
    
    

}
