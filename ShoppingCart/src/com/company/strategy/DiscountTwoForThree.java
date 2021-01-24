package com.company.strategy;

import com.company.shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DiscountTwoForThree implements Discount {

    @Override
    public BigDecimal applyDiscount(ArrayList<ShoppingCartItem> items) {

        var GetItemCost = BigDecimal.ZERO;

        for (var item : items) {
            for (var i = 2; i < item.quantity(); i+=3 ) {
                GetItemCost = item.itemCost().add(GetItemCost);
            }
        }
        return GetItemCost;
    }
}
