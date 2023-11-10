package hw.hw4.OnlineMarketProject.controllers;

import hw.hw4.OnlineMarketProject.exceptions.AmountException;
import hw.hw4.OnlineMarketProject.exceptions.CustomerException;
import hw.hw4.OnlineMarketProject.exceptions.ProductException;
import hw.hw4.OnlineMarketProject.models.Customer;
import hw.hw4.OnlineMarketProject.models.Item;
import hw.hw4.OnlineMarketProject.models.Order;

public class MarketRepository {
    public final static Customer[] people = {
        new Customer("Ivan", 20, "+7 999 999 999"),
        new Customer("Katya", 30, "+7 999 999 999")
    };
    public final static Item[] items = {
        new Item("Ball", 100),
        new Item("Sandwich", 1000),
        new Item("Table", 10000),
        new Item("Car", 100000),
        new Item("Rocket", 1000000)
    };
    public static Order[] orders = new Order[5];
    private boolean isInArray(Object[] arr, Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o))
                return true;
        }
        return false;
    }

    public Order buy(Customer who, Item what, int howMuch) {
        if (!isInArray(people, who))
            throw new CustomerException("Unknown customer: " + who);
        if (!isInArray(items, what))
            throw new ProductException("Unknown item: " + what);
        if (howMuch < 0 || howMuch > 100)
            throw new AmountException("Incorrect amount: " + howMuch);
        return new Order(who, what, howMuch);
    }
}
