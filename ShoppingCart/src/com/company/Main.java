package com.company;

import com.company.command.commands.UndoRedo;
import com.company.shop.CashRegister;
import com.company.shop.Product;
import com.company.shop.ShoppingCart;
import com.company.shop.ShoppingCartItem;

public class Main {

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        CashRegister cashRegister = new CashRegister();

        Product product1 = new Product("Milk");
        Product product2 = new Product("Bananas");
        Product product3 = new Product("Apples");
        Product product4 = new Product("Pears");

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product1, 100.00, 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(product2, 50, 1);
        ShoppingCartItem shoppingCartItem3 = new ShoppingCartItem(product3, 150, 6);
        ShoppingCartItem shoppingCartItem4 = new ShoppingCartItem(product4, 200, 1);

        shoppingCart.addCartItem(shoppingCartItem);
        shoppingCart.addCartItem(shoppingCartItem2);
        shoppingCart.addCartItem(shoppingCartItem3);
        shoppingCart.addCartItem(shoppingCartItem4);

        UndoRedo.undo();

        System.out.println(cashRegister.receipt(shoppingCart));

        UndoRedo.redo();

        System.out.println(cashRegister.receipt(shoppingCart));
    }
}
