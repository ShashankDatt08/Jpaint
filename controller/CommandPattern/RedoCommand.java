package controller.CommandPattern;

public class RedoCommand implements ICommandPattern {

    @Override
    public void run() {
    	URCommand.redo();
    }
}
