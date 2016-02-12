package userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import miinaharava.gameObjects.Ruutu;

/**
 * Luokkaan on liitetty Ruutu.
 * 
 */

public class RuutuButton extends JButton {

    private final Ruutu ruutu;
    private final RuutuButton me = this;

    public RuutuButton(Ruutu ruutu) {
        this.ruutu = ruutu;
        addActionListener();
        this.addKeyListener(null);
        this.setPreferredSize(new Dimension(40, 40));
    }

    private void addActionListener() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KORJAA MINUT");

            }
        });

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    me.setBackground(Color.red);
                    me.setContentAreaFilled(false);
                    me.setOpaque(true);
                    ruutu.setFlagged(!ruutu.isFlagged());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }
}
