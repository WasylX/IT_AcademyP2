package task2;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.createShape(ShapeType.CIRCLE, 5.0);
        System.out.println("Circle Area: " + circle.calculateArea());

        Shape rectangle = factory.createShape(ShapeType.RECTANGLE, 4.0, 6.0);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        Shape triangle = factory.createShape(ShapeType.TRIANGLE, 3.0, 4.0);
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}

