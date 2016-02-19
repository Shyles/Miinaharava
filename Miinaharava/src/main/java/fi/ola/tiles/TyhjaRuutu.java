package fi.ola.tiles;

import fi.ola.logic.GameBoard;

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
        super.setToBePrintedOnRuutuButton("1");
    }

}
