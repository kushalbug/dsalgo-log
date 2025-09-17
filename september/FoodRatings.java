//day 38 of daily log

import java.util.*;

class FoodRatings {
    // food -> cuisine
    private Map<String, String> foodToCuisine;
    // food -> rating
    private Map<String, Integer> foodToRating;
    // cuisine -> max heap of (food, rating)
    private Map<String, PriorityQueue<Food>> cuisineToHeap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToHeap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);

            cuisineToHeap
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>())
                .add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);

        // Add new entry into heap
        cuisineToHeap.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> heap = cuisineToHeap.get(cuisine);

        // Lazy removal: pop until valid
        while (!heap.isEmpty()) {
            Food top = heap.peek();
            int currentRating = foodToRating.get(top.name);
            if (top.rating == currentRating) {
                return top.name;
            }
            heap.poll(); // remove stale entry
        }
        return ""; // should never happen
    }

    // Custom comparator: higher rating first, then lexicographically smaller
    private static class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating); // higher rating first
            }
            return this.name.compareTo(other.name); // lexicographically smaller first
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
