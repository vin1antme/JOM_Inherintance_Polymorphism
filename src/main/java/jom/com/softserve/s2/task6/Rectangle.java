package jom.com.softserve.s2.task6;

public class Rectangle extends Shape{

    private double height;
    private double width;

    public Rectangle(String name, double height, double width){
         super(name);
         this.height = height;
         this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double  getWidth() {
        return width;
    }
    
    public double getRectangleArea(){
        return height * width;
    }
}
