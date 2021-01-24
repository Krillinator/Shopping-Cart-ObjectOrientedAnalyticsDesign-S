package com.company.command.commands;

import java.util.Stack;

public class UndoRedo{

    static Stack<CommandState> redoStack = new Stack<CommandState>();
    static Stack<CommandState> undoStack = new Stack<CommandState>();

    public static void undo(){
        if (undoStack.size() > 0) {
            int index = undoStack.size() - 1;
            undoStack.get(index).undo.execute();
            redoStack.push(undoStack.peek());
            undoStack.pop();
        }
    }

    public static void redo() {
        if (redoStack.size() > 0) {
            undoStack.push(redoStack.peek());
            redoStack.pop().redo.execute();
        }
    }

    public static void addHistoryState(CommandState commandState) {
        undoStack.push(commandState);
        redoStack.clear();
    }
}
