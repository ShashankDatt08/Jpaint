package controller;

import java.awt.Graphics2D;

import controller.CommandPattern.RedoCommand;
import controller.CommandPattern.UndoCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.commands.CopyShape;
import view.commands.DeleteShape;
import view.commands.FlipCommand;
import view.commands.GroupCommand;
import view.commands.PasteShape;
import view.commands.RotateShape;
import view.commands.UngroupCommand;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    
    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
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
        uiModule.addEvent(EventName.GROUP, () -> new GroupCommand().run());
        uiModule.addEvent(EventName.UNGROUP, () -> new UngroupCommand().run());
        uiModule.addEvent(EventName.ROTATE, () -> new RotateShape().run());
        uiModule.addEvent(EventName.FLIP, () -> new FlipCommand().run());
    }
}
