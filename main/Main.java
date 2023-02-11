package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.click;
import model.ShapeListManager;
import model.persistence.ApplicationState;
import view.draw.Shaper;
import view.gui.ComponentChecker;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        click Click = new click(appState , paintCanvas);
        IJPaintController controller = new JPaintController(uiModule, appState); 
        controller.setup();
        paintCanvas.addMouseListener(Click);
        Shaper shaper = new Shaper(paintCanvas);
        ShapeListManager.getShapeList().registerObserver(shaper);
        ComponentChecker resizeComponent = new ComponentChecker(shaper);
        ((GuiWindow) guiWindow).addComponentListener(resizeComponent);    }
}
