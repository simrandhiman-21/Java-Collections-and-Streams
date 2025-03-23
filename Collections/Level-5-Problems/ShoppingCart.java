import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedCart = new TreeMap<>();

    void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    void addToCart(String name, int qty) {
        if (productPrices.containsKey(name)) {
            cart.put(name, cart.getOrDefault(name, 0) + qty);
            sortedCart.put(productPrices.get(name), name);
        }
    }

    void displayCart() {
        System.out.println("Cart: " + cart);
        System.out.println("Sorted by Price: " + sortedCart);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 3);
        cart.displayCart();
    }
}
