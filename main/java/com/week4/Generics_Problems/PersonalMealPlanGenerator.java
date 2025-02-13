package com.week4.day1;

//mael plan interface
interface MealPlan {
    void displayMeal();
}

// VegetarianMeal Implementing MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: Veggie ");
    }
}

// VeganMeal Categories Implementing MealPlan
class VeganMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal:  Salad");
    }
}

// KatoMeal Categories Implementing MealPlan
class KetoMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Keto Meal: Chicken Salad");
    }
}

// HighProteinMeal Categories Implementing MealPlan
class HighProteinMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("High-Protein Meal: Milk");
    }
}

// Generic Meal Class:Generate
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void prepareMeal() {
        System.out.println("Preparing Meal...");
        mealPlan.displayMeal();
    }
}

// Meal Plan Generator:Validate
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("\nGenerating a personalized meal plan...");
        return new Meal<>(mealType);
    }
}

public class PersonalMealPlanGenerator
{
    public static void main(String[] args) {
        // Generating different meal plans
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        vegetarianMeal.prepareMeal();

        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        veganMeal.prepareMeal();

        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        ketoMeal.prepareMeal();

        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        highProteinMeal.prepareMeal();
    }
}