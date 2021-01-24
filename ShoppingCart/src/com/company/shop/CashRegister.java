package com.company.shop;

import com.company.strategy.DiscountCheapestItem;
import com.company.strategy.DiscountOnAll;
import com.company.strategy.DiscountTwoForThree;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CashRegister {

    DiscountOnAll discountOnAll = new DiscountOnAll();
    DiscountCheapestItem discountcheapestItem = new DiscountCheapestItem();
    DiscountTwoForThree discountTwoForThree = new DiscountTwoForThree();
    ShoppingCart shoppingCart = new ShoppingCart();

    public BigDecimal calculatePrice(ShoppingCart shoppingCart){
        var sum = BigDecimal.ZERO;
        for (var item: shoppingCart.items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }

        sum.subtract(calculateDiscount(shoppingCart));

        return sum;
    }

    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {
        var x = discountTwoForThree.applyDiscount(shoppingCart.items);
        var y = discountOnAll.applyDiscount(shoppingCart.items);
        var z = discountcheapestItem.applyDiscount(shoppingCart.items);

        int[] myNum = {x.intValue(),y.intValue(),z.intValue()};
        Arrays.sort(myNum);
        var sum = myNum[myNum.length-1];

        return BigDecimal.valueOf(sum);
    }

    public String receipt(ShoppingCart shoppingCart) {
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = shoppingCart.items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-24s % 7.2f\n", each.product().name(), each.itemCost()));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice(shoppingCart)));
        return sb.toString();
    }
}
