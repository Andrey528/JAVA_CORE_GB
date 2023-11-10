package hw.hw4.OnlineMarketProject.models;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Order {
    Customer customer;
    Item item;
    int amount;
}
