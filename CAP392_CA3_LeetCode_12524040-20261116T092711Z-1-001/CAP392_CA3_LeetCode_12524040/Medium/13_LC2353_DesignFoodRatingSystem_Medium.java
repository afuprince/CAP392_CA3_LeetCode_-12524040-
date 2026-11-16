/*
 * LeetCode 2353 - Design a Food Rating System (Medium)
 * Topic: Classes, objects, methods, encapsulation
 *
 * Design:
 *  - foodRating:  food    -> current rating
 *  - foodCuisine: food    -> cuisine
 *  - cuisineFoods: cuisine -> TreeSet of foods ordered by (rating desc, name asc),
 *                  so the first element is always the highest rated food.
 * All fields are private and accessed only through the public methods (encapsulation).
 * changeRating removes the food from its set BEFORE updating the rating (the comparator
 * depends on the rating), then re-inserts it.
 *
 * Time: constructor O(n log n), changeRating O(log n), highestRated O(1)/O(log n)
 *
 * Note: The file name starts with a digit (as required by the naming convention),
 * so the class cannot be declared public. Run with: java 13_LC2353_DesignFoodRatingSystem_Medium.java
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatings {

    private final Map<String, Integer> foodRating = new HashMap<>();
    private final Map<String, String> foodCuisine = new HashMap<>();
    private final Map<String, TreeSet<String>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
        }
        for (int i = 0; i < foods.length; i++) {
            cuisineFoods
                    .computeIfAbsent(cuisines[i], c -> new TreeSet<>(this::compareFoods))
                    .add(foods[i]);
        }
    }

    // Higher rating first; if equal, lexicographically smaller name first.
    private int compareFoods(String a, String b) {
        int ra = foodRating.get(a), rb = foodRating.get(b);
        if (ra != rb) {
            return Integer.compare(rb, ra);
        }
        return a.compareTo(b);
    }

    public void changeRating(String food, int newRating) {
        TreeSet<String> set = cuisineFoods.get(foodCuisine.get(food));
        set.remove(food);            // remove using the OLD rating
        foodRating.put(food, newRating);
        set.add(food);               // re-insert using the NEW rating
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }

    public static void main(String[] args) {
        FoodRatings fr = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});

        System.out.println(fr.highestRated("korean"));   // kimchi
        System.out.println(fr.highestRated("japanese")); // ramen
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese")); // sushi
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese")); // ramen (tie at 16, "ramen" < "sushi")
    }
}
