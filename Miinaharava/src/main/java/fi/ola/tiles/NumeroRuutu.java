package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import java.awt.Color;

/**
 * NumeroRuutu kertoo vieriesten MiinaRuutujen määrän.
 */
public class NumeroRuutu extends Ruutu {

    /**
     * Asettaa NumeroRuudun grafiikat kohdalleen.
     *
     * @param gb Pöytä.
     * @param row Rivi.
     * @param col Kolumni.
     */
    public NumeroRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
        super.setToBePrintedOnRuutuButton("4");
        super.mineNeighbours = 0;
        super.color = Color.GRAY;
    }

    @Override
    public void setUpTyhjaOrNumeroRuutu() {
        for (Ruutu ruutu : gb.getNeighbours(this)) {
            if (ruutu instanceof MiinaRuutu) {
                mineNeighbours++;
            }
        }
        super.toBePrintedOnRuutuButton = "" + mineNeighbours;
    }

    @Override
    public void revealUnderneath() {
        super.revealUnderneath();
        gb.reduceEmptyOrNumeroRuutuLeft();
        if (gb.getEmptyOrNumeroRuutusLeft() == 0) {
            gb.getLogiikka().endWinningGame();
        }
    }
    
    
    
    

    
}

