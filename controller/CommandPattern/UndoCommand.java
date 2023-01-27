package controller.CommandPattern;

import view.interfaces.IEventCallback;

public class UndoCommand implements IEventCallback {

    @Override
    public void run() {
    	URCommand.undo();
    }

}
