package com.company.shop;

import com.company.command.commands.Command;
import com.company.command.commands.CommandState;
import com.company.command.commands.UndoRedo;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class ShoppingCart {

    final Stack<Command> undoStack = new Stack<>();
    final ArrayList<ShoppingCartItem> items = new ArrayList<>();

    public void addCartItem(ShoppingCartItem item){
        UndoRedo.addHistoryState(new CommandState(() -> {
            System.out.println("Removing the: " + item.product().name());
            items.remove(item);
        }, () -> {
            System.out.println("Adding back the: " + item.product().name());
            items.add(item);
        }));
        items.add(item);
    }
    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }
}