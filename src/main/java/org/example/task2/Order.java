package org.example.task2;

/**
 * Замовлення.
 */
public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     * Формує текст рахунку за замовленням.
     * Використовує дані кошика, не звертаючись до полів напряму.
     */
    public String formOrderBill(Cart cart) {

        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(id)
               .append(" for customer ").append(customer)
               .append("\n");

        double sum = 0.0;

        Item[] items = cart.getItems();
        for (Item item : items) {
            builder.append(item.getName());
            builder.append(" price: ");
            builder.append(item.getPrice());
            builder.append("\n");
            sum += item.getPrice();
        }

        builder.append("------------------\n");
        builder.append("Total sum: ");
        builder.append(sum);

        return builder.toString();
    }
}
