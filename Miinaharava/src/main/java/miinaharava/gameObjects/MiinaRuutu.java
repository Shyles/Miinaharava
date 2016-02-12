
package miinaharava.gameObjects;

import miinaharava.GameBoard;
import miinaharava.gameObjects.Ruutu;

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
