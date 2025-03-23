import java.util.ArrayList;
import java.util.List;

// Abstract class for warehouse items
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void display();
}

// Electronics class
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void display() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand + ", Price: $" + getPrice());
    }
}

// Groceries class
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println("Groceries: " + getName() + ", Expiry: " + expiryDate + ", Price: $" + getPrice());
    }
}

// Furniture class
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public void display() {
        System.out.println("Furniture: " + getName() + ", Material: " + material + ", Price: $" + getPrice());
    }
}

// Generic class for storage
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    // Method with wildcard to display all items
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.display();
        }
    }
}

// Main class
public class SmartWarehouse {
    public static void main(String[] args) {
        
        // Creating storages
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items
        electronicsStorage.addItem(new Electronics("Laptop", 1200.0, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.0, "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", 3.5, "2025-04-10"));
        groceriesStorage.addItem(new Groceries("Bread", 2.0, "2025-03-25"));

        furnitureStorage.addItem(new Furniture("Chair", 150.0, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 300.0, "Metal"));

        // Displaying all items using wildcard method
        System.out.println("----- Electronics Storage -----");
        Storage.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n----- Groceries Storage -----");
        Storage.displayAllItems(groceriesStorage.getItems());

        System.out.println("\n----- Furniture Storage -----");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}
