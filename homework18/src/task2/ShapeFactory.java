package task2;

public class ShapeFactory {
    public Shape createShape(ShapeType type, double... parameters) {
        return switch (type) {
            case CIRCLE -> {
                if (parameters.length != 1) {
                    throw new IllegalArgumentException("Circle requires one parameter (radius).");
                }
                yield new Circle(parameters[0]);
            }
            case RECTANGLE -> {
                if (parameters.length != 2) {
                    throw new IllegalArgumentException("Rectangle requires two parameters (width and height).");
                }
                yield new Rectangle(parameters[0], parameters[1]);
            }
            case TRIANGLE -> {
                if (parameters.length != 2) {
                    throw new IllegalArgumentException("Triangle requires two parameters (base and height).");
                }
                yield new Triangle(parameters[0], parameters[1]);
            }
            default -> throw new IllegalArgumentException("Unsupported shape type.");
        };
    }
}

