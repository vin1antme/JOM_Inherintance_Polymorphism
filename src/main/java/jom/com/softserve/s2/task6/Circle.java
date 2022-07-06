package jom.com.softserve.s2.task6;

public class Circle extends Shape{

    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircleArea() {
        return Math.PI * radius * radius;
    }
    
    public double getArea() {
        return getCircleArea();
    }
}
