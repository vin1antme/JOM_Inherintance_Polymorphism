package jom.com.softserve.s2.task2;

public interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}
