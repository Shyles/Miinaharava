package fi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import fi.ola.tiles.Ruutu;

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
        this.setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Lisätään kuuntelijat.
     */
    private void addActionListener() {
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ruutu.isFlagged()) {
                    if (!ruutu.isOpened()) {
                        ruutu.revealUnderneath();
                        me.setBackground(ruutu.getColor());
                        me.setText(ruutu.getToBePrintedOnRuutuButton());
                    }
                }
            }
        });

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (ruutu.isOpened()) { return; }
                    if (!ruutu.isFlagged()) {
                            me.setBackground(Color.RED);
                            me.setText("F");
                    } else {
                        me.setBackground(Color.LIGHT_GRAY);
                        me.setText("");
                    }
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
        }
        );

    }
}
