
package miinaharava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import miinaharava.Ruutu;


public class GameBoard {
   private Ruutu[][] gameboard;
   private Integer[] availableAmountsArray = {};
   public Set<Integer> availableAmounts;


    public GameBoard() {
    }
    
    public void newBoard(int boxAmount) throws Exception {
        if (availableAmounts.contains(boxAmount)) {
            createBoard(boxAmount);
        } else {
            throw new RuntimeException("Invalid argument. Currently supports integers " + availableAmounts.toString());
        }
    }

    private void createBoard(int boxAmount) {
        
    }

    public void setAvailableAmounts(Integer[] availableAmountsArray) {
        this.availableAmountsArray = availableAmountsArray;
        this.availableAmounts = new HashSet(Arrays.asList(availableAmountsArray));
    }

    public Set<Integer> getAvailableAmounts() {
        return availableAmounts;
    }

    
    
}
