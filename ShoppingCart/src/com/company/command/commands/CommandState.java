package com.company.command.commands;

public class CommandState {
        Command undo;
        Command redo;

        public CommandState(Command h1, Command h2) {
            this.undo = h1;
            this.redo = h2;
        }
    }
