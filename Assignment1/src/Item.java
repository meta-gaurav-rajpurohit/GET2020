import java.util.HashMap;

public class Item {
    static HashMap<String, Integer> item;

    /**
     * Construct use to create record of item.
     *
     * @param no
     *            parameter use
     * @return nothing return
     */
    public Item() {
        item = new HashMap<String, Integer>();
        item.put("Apple", 10);
        item.put("Book", 50);
        item.put("Toast", 20);
    }

    /**
     * It use to return the price of item
     *
     * @param name
     *            {@code String} to get the price of item
     * @return the double value
     */
    double getPrice(String name) {
        return item.get(name);
    }
}
