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
 * Luokkaan on liitetty Ruutu. Estää Ruudun aukaisun väärissä kohdissa.
 *
 */
public class RuutuButton extends JButton {

    private final Ruutu ruutu;
    private final RuutuButton me = this;

    /**
     * Creates a RuutuButton associated to a Ruutu.
     *
     * @param ruutu My Ruutu.
     */
    public RuutuButton(Ruutu ruutu) {
        this.ruutu = ruutu;
        addActionListener();
        this.addKeyListener(null);
        this.setPreferredSize(new Dimension(40, 40));
        this.setBackground(Color.LIGHT_GRAY);
        ruutu.setRuutuButton(this);
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
                    }
                }
            }
        });

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (ruutu.isOpened()) {
                        return;
                    }
                    if (!ruutu.isFlagged()) {
                        renderFlagged();
                    } else {
                        renderUnFlagged();
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

    /**
     * Used to render RuutuButton unflagged.
     */
    public void renderUnFlagged() {
        me.setBackground(Color.LIGHT_GRAY);
        me.setText("");
    }

    /**
     * Used to render RuutuButton flagged.
     */
    public void renderFlagged() {
        me.setBackground(Color.RED);
        me.setText("F");
    }

    /**
     * Used to render RuutuButton open.
     */
    public void renderOpen() {
        me.setBackground(ruutu.getColor());
        me.setText(ruutu.getToBePrintedOnRuutuButton());
    }

    public Ruutu getRuutu() {
        return ruutu;
    }

}
