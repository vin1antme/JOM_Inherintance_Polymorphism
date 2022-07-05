package jom.com.softserve.s2.task6;

import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> figures){
        return null;
    }


    public static void main(String[] args) {
        Rectangle r = new Rectangle("Rect", 100, 70);
        Circle c = new Circle("Circle", 5.0);

        System.out.println(r instanceof Shape);
        System.out.println(((Shape)r) instanceof Rectangle);
        System.out.println(c.getClass().getName() == Circle.class.getName());
    }

}
