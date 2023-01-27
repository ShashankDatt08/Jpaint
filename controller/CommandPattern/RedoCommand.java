package controller.CommandPattern;

import view.interfaces.IEventCallback;
import view.interfaces.IURCommand;

public class RedoCommand implements IEventCallback {

    @Override
    public void run() {
    	URCommand.redo();
    }
}
