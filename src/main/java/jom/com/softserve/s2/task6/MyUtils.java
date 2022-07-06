package jom.com.softserve.s2.task6;

import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> figures) {
        List<Shape> circles = new ArrayList<>();
        List<Shape> rectangles = new ArrayList<>();

        for (Shape shape : figures) {
            if (shape != null) {
                if (shape.getClass().getName() == Circle.class.getName())
                    circles.add(shape);
                else if (shape.getClass().getName() == Rectangle.class.getName())
                    rectangles.add(shape);
            }
        }

        Comparator<Shape> shapesComparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape sh1, Shape sh2) {
                if (sh1.getArea() > sh2.getArea())
                    return 1;
                else if (sh1.getArea() < sh2.getArea())
                    return -1;
                return 0;
            }
        };

        if (!circles.isEmpty()) {
            double maxCircleArea = Collections.max(circles, shapesComparator).getArea();
            circles.removeIf(c -> c.getArea() < maxCircleArea);
        }

        if (!rectangles.isEmpty()) {
            double maxRectArea = Collections.max(rectangles, shapesComparator).getArea();
            rectangles.removeIf(w -> w.getArea() < maxRectArea);
        }

        List<Shape> maxShapes = new ArrayList<>();
        if (!circles.isEmpty()) {
            maxShapes.add(circles.get(0));
        }

        if (rectangles.size() > 1) {
            Rectangle firstRect = (Rectangle) rectangles.get(0);
            maxShapes.add(firstRect);
            for (int i = 1; i < rectangles.size(); i++) {
                Rectangle nextRect = (Rectangle) rectangles.get(i);
                if (nextRect.getHeight() != firstRect.getHeight()) {
                    maxShapes.add(nextRect);
                }
            }
        } else {
            maxShapes.addAll(rectangles);
        }
        return maxShapes;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle("Rect", 100, 70);
        Circle c = new Circle("Circle", 5.0);

        System.out.println(r instanceof Shape);
        System.out.println(((Shape) r) instanceof Rectangle);
        System.out.println(c.getClass().getName() == Circle.class.getName());

        Shape sh = (Shape) c;
        System.out.println(sh.getArea());
    }
}