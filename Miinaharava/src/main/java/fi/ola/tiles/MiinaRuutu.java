package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import fi.ola.tiles.Ruutu;
import java.awt.Color;

/**
 * MiinaRuudun aukaistessa peli loppuu.
 */
public class MiinaRuutu extends Ruutu {

    /**
     * Asettaa MiinaRuudun grafiikat kohdalleen.
     *
     * @param gb Pöytä.
     * @param row Rivi.
     * @param col Kolumni.
     */
    public MiinaRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
        super.color = Color.BLACK;
    }

    @Override
    public void revealUnderneath() {
        super.revealUnderneath();
        super.gb.setGameContinues(0);
        System.out.println("Miina");
        
    }

}
