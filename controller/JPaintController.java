package controller;

import java.awt.Graphics2D;

import controller.CommandPattern.RedoCommand;
import controller.CommandPattern.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.commands.CopyShape;
import view.commands.DeleteShape;
import view.commands.GroupCommand;
import view.commands.PasteShape;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private Graphics2D graphics;
    
    public JPaintController(IUiModule uiModule, IApplicationState applicationState,Graphics2D graphics) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.graphics = graphics;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () ->new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () ->new RedoCommand().run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShape().run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShape().run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShape().run());
        uiModule.addEvent(EventName.GROUP, () -> new GroupCommand(graphics).run());

    }
}
