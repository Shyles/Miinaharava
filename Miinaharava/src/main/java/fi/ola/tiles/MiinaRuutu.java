
package fi.ola.tiles;

import fi.ola.logic.GameBoard;
import fi.ola.tiles.Ruutu;

/**
 * MiinaRuudun aukaistessa peli loppuu.
 */

public class MiinaRuutu extends Ruutu {

    public MiinaRuutu(GameBoard gb, int row, int col) {
        super(gb, row, col);
    }

    

    @Override
    public void revealUnderneath() {
       super.revealUnderneath();
       super.gb.setGameContinues(0);
    }
    
}
