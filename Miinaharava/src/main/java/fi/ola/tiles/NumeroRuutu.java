package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import fi.ola.tiles.Ruutu;

/**
 * NumeroRuutu kertoo vieriesten MiinaRuutujen määrän.
 */
public class NumeroRuutu extends Ruutu {

    /**
     * Asettaa NumeroRuudun grafiikat kohdalleen.
     * @param gb Pöytä.
     * @param row Rivi.
     * @param col  Kolumni.
     */
    public NumeroRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
        super.setToBePrintedOnRuutuButton("4");
    }

}
