import java.util.ArrayList;
import java.util.List;

// Abstract class for product categories
abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void display();
}

// Book category
class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Book: " + getName() + ", Author: " + author + ", Price: $" + getPrice());
    }
}

// Clothing category
class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing: " + getName() + ", Size: " + size + ", Price: $" + getPrice());
    }
}

// Gadget category
class Gadget extends Product {
    private String brand;

    public Gadget(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void display() {
        System.out.println("Gadget: " + getName() + ", Brand: " + brand + ", Price: $" + getPrice());
    }
}

// Generic catalog class with bounded type parameter
class Catalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public void displayCatalog() {
        for (T product : products) {
            product.display();
        }
    }
}

// Utility class with a generic method to apply discounts dynamically
class Discount {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("Discount applied! New price of " + product.getName() + ": $" + product.getPrice());
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {

        // Catalogs for different product categories
        Catalog<Book> bookCatalog = new Catalog<>();
        Catalog<Clothing> clothingCatalog = new Catalog<>();
        Catalog<Gadget> gadgetCatalog = new Catalog<>();

        // Adding products to respective catalogs
        bookCatalog.addProduct(new Book("Java Programming", 50.0, "James Gosling"));
        bookCatalog.addProduct(new Book("Effective Java", 60.0, "Joshua Bloch"));

        clothingCatalog.addProduct(new Clothing("T-Shirt", 25.0, "M"));
        clothingCatalog.addProduct(new Clothing("Jeans", 40.0, "L"));

        gadgetCatalog.addProduct(new Gadget("Smartphone", 500.0, "Apple"));
        gadgetCatalog.addProduct(new Gadget("Laptop", 1200.0, "Dell"));

        // Displaying initial catalogs
        System.out.println("----- Book Catalog -----");
        bookCatalog.displayCatalog();

        System.out.println("\n----- Clothing Catalog -----");
        clothingCatalog.displayCatalog();

        System.out.println("\n----- Gadget Catalog -----");
        gadgetCatalog.displayCatalog();

        // Applying discounts dynamically
        System.out.println("\n----- Applying Discounts -----");
        Discount.applyDiscount(bookCatalog.getProducts().get(0), 10);     // 10% discount on first book
        Discount.applyDiscount(clothingCatalog.getProducts().get(1), 15); // 15% discount on second clothing item
        Discount.applyDiscount(gadgetCatalog.getProducts().get(0), 5);    // 5% discount on first gadget

        // Displaying catalogs after discount
        System.out.println("\n----- Updated Catalogs after Discount -----");
        System.out.println("\nBook Catalog:");
        bookCatalog.displayCatalog();

        System.out.println("\nClothing Catalog:");
        clothingCatalog.displayCatalog();

        System.out.println("\nGadget Catalog:");
        gadgetCatalog.displayCatalog();
    }
}
