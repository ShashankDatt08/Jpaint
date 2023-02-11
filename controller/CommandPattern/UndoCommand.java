package controller.CommandPattern;

public class UndoCommand implements ICommandPattern {

    @Override
    public void run() {
    	URCommand.undo();
    }

}
