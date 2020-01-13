import java.util.HashMap;

public class Cart {

    HashMap<String, Integer> cart;
    Item rc = new Item();

    public Cart() {
        cart = new HashMap<String, Integer>();
    }

    /**
     * Add the item into card.
     *
     * @param item
     *            the first {@code String} to add
     * @param quantity
     *            the second {@code int} to add
     */
    public void addItem(String item, int quantity) {
        if (cart.containsKey(item)) {
            cart.put(item, (cart.get(item) + quantity));
        } else
            cart.put(item, quantity);
    }

    /**
     * update the item into card.
     *
     * @param item
     *            the first {@code String} to update
     * @param quantity
     *            the second {@code int} to update
     */
    public void updateItem(String item, int quantity) {
        if (cart.containsKey(item)) {
            cart.put(item, quantity);
        } else
            System.out.println("Item not available in cart. ");
    }

    /**
     * delete the item into card.
     *
     * @param item
     *            the first {@code String} to delete
     */
    public void deleteItem(String item) {
        if (cart.containsKey(item)) {
            cart.remove(item);
        } else
            System.out.println("Item not available in cart. ");
    }

    /**
     * show the item in the card.
     */
    public void showCart() {
        System.out.println(String.format("%20s %20s %20s", "Name of item",
                "Quantity of item", "Price of item"));
        for (HashMap.Entry<String, Integer> entry : cart.entrySet())
            System.out.println(String.format("%20s %20s %20s", entry.getKey(),
                    entry.getValue(),
                    (entry.getValue() * rc.getPrice(entry.getKey()))));
    }

    /**
     * Generate the bill for item
     */
    public void genrateBill() {
        double total = 0.0;
        System.out
                .println(String.format("%37s", "SHOPPING BILL")
                        + "\n==============================================================");
        for (HashMap.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(String.format("%20s %20s %20s", entry.getKey(),
                    entry.getValue(),
                    (entry.getValue() * rc.getPrice(entry.getKey()))));
            total = total + (entry.getValue() * rc.getPrice(entry.getKey()));
        }
        System.out.println("\n" + String.format("%20s  %40s", "Total", total));
        System.out
                .println("==============================================================");

    }
}
