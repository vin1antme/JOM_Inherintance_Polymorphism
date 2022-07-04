package jom.com.softserve.s2.task2;

import java.util.Map;

public class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Milk", 50);
        return super.makeDrink();
    }
}
