package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTest {
    //    private CartManager manager = new CartManager(0);
    private PurchaseItem first = new PurchaseItem(1, 1, "one", 1, 1);
    private PurchaseItem second = new PurchaseItem(2, 2, "two", 1, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "three", 1, 1);
    private PurchaseItem fourth = new PurchaseItem(4, 4, "four", 1, 1);
    private PurchaseItem fifth = new PurchaseItem(5, 5, "five", 1, 1);
    private PurchaseItem sixth = new PurchaseItem(6, 6, "six", 1, 1);
    private PurchaseItem seventh = new PurchaseItem(7, 7, "seven", 1, 1);
    private PurchaseItem eighth = new PurchaseItem(8, 8, "eight", 1, 1);
    private PurchaseItem ninth = new PurchaseItem(9, 9, "nine", 1, 1);
    private PurchaseItem tenth = new PurchaseItem(10, 10, "ten", 1, 1);
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "eleven", 1, 1);
    private PurchaseItem twelfth = new PurchaseItem(12, 12, "twelve", 1, 1);

    @Test
    public void showTheLastFive() {
        CartManager manager = new CartManager(5); //количеством фильмов
        manager.add(first);        //данные только что созданный менеджер
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        PurchaseItem[] actual = manager.numLastW(); //получаем последние фильмы
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showTheLastTenn() {
        CartManager manager = new CartManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        PurchaseItem[] actual = manager.numLastW();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showTheLast() {         // при наличии фильмов в ленте меньше запрашиваемых
        CartManager manager = new CartManager(13);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        PurchaseItem[] actual = manager.numLastW();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showTheLastZeroOrNegative() {
        CartManager manager = new CartManager(-5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        PurchaseItem[] actual = manager.numLastW();
        PurchaseItem[] expected = new PurchaseItem[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }


}