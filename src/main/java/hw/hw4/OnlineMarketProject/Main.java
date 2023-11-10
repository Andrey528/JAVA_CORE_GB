package hw.hw4.OnlineMarketProject;

import hw.hw4.OnlineMarketProject.controllers.MarketRepository;
import hw.hw4.OnlineMarketProject.exceptions.AmountException;
import hw.hw4.OnlineMarketProject.exceptions.CustomerException;
import hw.hw4.OnlineMarketProject.exceptions.ProductException;
import hw.hw4.OnlineMarketProject.models.Customer;
import hw.hw4.OnlineMarketProject.models.Item;

/**
 *
 2. Задача: Эмуляция интернет-магазина
 1 - написать классы покупатель, товар и заказ;
 2 - создать массив покупателей, массив товаров и массив заказов;
 3 - создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа. Метод должен вернуть объект заказа
 4 - Если в метод передан несуществующий покупатель, товар или отрицательное количество, метод должен выбросить соответствующее исключение;
 5 - Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения.
 6 - Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.
 */
public class Main {
    public static void main(String[] args) {
        MarketRepository marketRepository = new MarketRepository();
        Object[][] info = {
                {marketRepository.people[0], marketRepository.items[0], 1},
                {marketRepository.people[1], marketRepository.items[1], -1},
                {marketRepository.people[0], marketRepository.items[2], 150},
                {marketRepository.people[1], new Item("Flower", 10), 1},
                {new Customer("Fedor", 40, "+3444555444"), marketRepository.items[3], 1},
        };
        int capacity = 0;
        int i = 0;
        while (capacity != marketRepository.orders.length - 1 || i != info.length) {
            try {
                marketRepository.orders[capacity] = marketRepository.buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                marketRepository.orders[capacity++] = marketRepository.buy((Customer) info[i][0], (Item) info[i][1], 1);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++i;
        }
    }
}
