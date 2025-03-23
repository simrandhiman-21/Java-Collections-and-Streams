import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// MealPlan interface (common contract for all meal types)
interface MealPlan {
    void displayMeal();
}

// Vegetarian meal
class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + mealName);
    }
}

// Vegan meal
class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: " + mealName);
    }
}

// Keto meal
class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public void displayMeal() {
        System.out.println("Keto Meal: " + mealName);
    }
}

// High-Protein meal
class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public void displayMeal() {
        System.out.println("High-Protein Meal: " + mealName);
    }
}

// Generic Meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }

    public void displayMeals() {
        for (T meal : meals) {
            meal.displayMeal();
        }
    }
}

// Utility class for meal plan generation
class MealPlanGenerator {

    // Generic method to validate and generate a personalized meal plan
    public static <T extends MealPlan> void generateMealPlan(Meal<T> mealCategory, int numberOfMeals) {
        System.out.println("\n--- Generating Meal Plan ---");
        List<T> availableMeals = mealCategory.getMeals();
        
        if (availableMeals.isEmpty()) {
            System.out.println("No meals available in this category.");
            return;
        }

        Random random = new Random();
        for (int i = 0; i < numberOfMeals; i++) {
            T meal = availableMeals.get(random.nextInt(availableMeals.size()));
            meal.displayMeal();
        }
    }
}

// Main class
public class PersonalizedMealPlan {
    public static void main(String[] args) {

        // Creating different meal categories
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>();
        Meal<VeganMeal> veganMeal = new Meal<>();
        Meal<KetoMeal> ketoMeal = new Meal<>();
        Meal<HighProteinMeal> highProteinMeal = new Meal<>();

        // Adding meals to each category
        vegetarianMeal.addMeal(new VegetarianMeal("Vegetable Stir Fry"));
        vegetarianMeal.addMeal(new VegetarianMeal("Grilled Paneer Salad"));

        veganMeal.addMeal(new VeganMeal("Tofu Scramble"));
        veganMeal.addMeal(new VeganMeal("Quinoa and Avocado Bowl"));

        ketoMeal.addMeal(new KetoMeal("Keto Chicken Salad"));
        ketoMeal.addMeal(new KetoMeal("Cauliflower Rice with Beef"));

        highProteinMeal.addMeal(new HighProteinMeal("Grilled Chicken Breast"));
        highProteinMeal.addMeal(new HighProteinMeal("Egg White Omelette"));

        // Displaying available meals
        System.out.println("--- Vegetarian Meals ---");
        vegetarianMeal.displayMeals();

        System.out.println("\n--- Vegan Meals ---");
        veganMeal.displayMeals();

        System.out.println("\n--- Keto Meals ---");
        ketoMeal.displayMeals();

        System.out.println("\n--- High-Protein Meals ---");
        highProteinMeal.displayMeals();

        // Generating personalized meal plans dynamically using the generic method
        MealPlanGenerator.generateMealPlan(vegetarianMeal, 2);   // 2 vegetarian meals
        MealPlanGenerator.generateMealPlan(veganMeal, 3);        // 3 vegan meals
        MealPlanGenerator.generateMealPlan(ketoMeal, 1);         // 1 keto meal
        MealPlanGenerator.generateMealPlan(highProteinMeal, 2);  // 2 high-protein meals
    }
}
