package org.example.task2;

import java.util.Arrays;

/**
 * Кошик інтернет-магазину.
 * Зберігає масив товарів і поточну кількість елементів.
 */
public class Cart {

    private Item[] contents;
    private int index; // кількість елементів у кошику

    public Cart(Item[] contents) {
        if (contents == null || contents.length == 0) {
            this.contents = new Item[10];
        } else {
            this.contents = contents;
        }
        this.index = 0;
    }

    /**
     * Додає товар у кошик, якщо є місце.
     */
    public void add(Item item) {
        if (item == null || isCartFull()) {
            return;
        }
        contents[index] = item;
        index++;
    }

    /**
     * Видаляє товар за його id (а не за індексом у масиві).
     */
    public void removeById(int itemId) {
        removeById((long) itemId);
    }

    public void removeById(long itemId) {
        if (index == 0) {
            return;
        }

        for (int i = 0; i < index; i++) {
            Item current = contents[i];
            if (current != null && current.getId() == itemId) {
                // зсуваємо всі елементи ліворуч
                for (int j = i; j < index - 1; j++) {
                    contents[j] = contents[j + 1];
                }
                contents[index - 1] = null;
                index--;
                break;
            }
        }
    }

    /**
     * Повертає true, якщо кошик заповнений.
     */
    public boolean isCartFull() {
        return index == contents.length;
    }

    /**
     * Повертає масив поточних елементів (без null в кінці).
     */
    public Item[] getItems() {
        Item[] result = new Item[index];
        for (int i = 0; i < index; i++) {
            result[i] = contents[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(getItems()) +
                '}' + "\n";
    }
}

