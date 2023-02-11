package view.gui;

import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PaintCanvas extends JComponent {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

}
