package view.gui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import view.draw.Shaper;

public class ComponentChecker extends ComponentAdapter {
    private Shaper shape;
    
    @Override
    public void componentResized(ComponentEvent e) {
        shape.update();
    }

    public ComponentChecker(Shaper shaper) {
        this.shape = shaper;
    }


}
