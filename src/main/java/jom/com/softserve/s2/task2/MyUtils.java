package jom.com.softserve.s2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffeeRatings) {
        Map<String, ArrayList<Integer>> allRatingsForEachCoffee = new HashMap<>();
        ArrayList<Integer> ratings;
        for (Caffee caffee : coffeeRatings) {
            String caffeeName = caffee.getName();
            if (allRatingsForEachCoffee.containsKey(caffeeName))
                ratings = allRatingsForEachCoffee.get(caffeeName);
            else
                ratings = new ArrayList<>();
            ratings.add(caffee.getRating());
            allRatingsForEachCoffee.put(caffeeName, ratings);
        }
        Map<String, Double> averageRating = new HashMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : allRatingsForEachCoffee.entrySet()) {
            ratings = entry.getValue();
            averageRating.put(entry.getKey(), (double) sumOfList(ratings) / ratings.size());
        }
        return averageRating;
    }

    public int sumOfList(List<Integer> list) {
        if (list == null || list.size() < 1)
            return 0;
        int sum = 0;
        for (Integer i : list)
            sum = sum + i;
        return sum;
    }
}