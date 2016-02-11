
package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import miinaharava.gameObjects.Ruutu;


public class RuutuButton extends JButton {
    
    private final Ruutu ruutu;

    public RuutuButton(Ruutu ruutu) {
        this.ruutu = ruutu;
        addActionListener();
        this.addKeyListener(null);
    }

    private void addActionListener() {
        this.actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KORJAA MINUT");
            }
        };
    }
}
