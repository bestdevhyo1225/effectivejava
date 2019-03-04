package com.hyoseog.effectivejava.chapter2.item2;

public class Item2Main {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).fat(20).sodium(35).carbohydrate(27).build();

        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.HAM).addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.PEPPER).build();

        CalZone calZone = new CalZone.Builder()
                .addTopping(Pizza.Topping.MUSHROOM).addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.PEPPER).sauceInside().build();
    }
}
