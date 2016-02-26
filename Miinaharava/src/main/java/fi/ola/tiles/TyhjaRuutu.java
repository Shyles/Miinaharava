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
     *
     * @param gb PÃ¶ytÃ¤.
     * @param row Rivi.
     * @param col Kolumni.
     */
    public TyhjaRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
        super.setToBePrintedOnRuutuButton("");
        super.color = Color.GRAY;
    }

    @Override
    public void revealUnderneath() {
        super.revealUnderneath();
        ArrayList<Ruutu> neighbours = gb.getNeighbours(this);
        for (Ruutu ruutu : neighbours) {
            if (!ruutu.isOpened() && !(ruutu instanceof MiinaRuutu)) {
                ruutu.revealUnderneath();
                ruutuButton.renderOpen();
            }
        }
        gb.reduceEmptyOrNumeroRuutuLeft();
        if (gb.getEmptyOrNumeroRuutusLeft() == 0) {
           gb.getLogiikka().endWinningGame();
        }
    }

}
