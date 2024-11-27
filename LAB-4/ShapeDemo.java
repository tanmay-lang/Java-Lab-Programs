import java.util.Scanner;

abstract class Shape {
    int dim1, dim2;

    // Constructor to initialize dimensions
    public Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    // Abstract method to calculate and print area
    abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    void printArea() {
        System.out.println("Area of Rectangle: " + (dim1 * dim2));
    }
}

class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        System.out.println("Area of Triangle: " + (0.5 * dim1 * dim2));
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); // Only one dimension is relevant for a circle
    }

    @Override
    void printArea() {
        System.out.println("Area of Circle: " + (Math.PI * dim1 * dim1));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rectangle
        System.out.print("Enter length and breadth of the rectangle: ");
        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        Shape rectangle = new Rectangle(length, breadth);

        // Triangle
        System.out.print("Enter base and height of the triangle: ");
        int base = scanner.nextInt();
        int height = scanner.nextInt();
        Shape triangle = new Triangle(base, height);

        // Circle
        System.out.print("Enter radius of the circle: ");
        int radius = scanner.nextInt();
        Shape circle = new Circle(radius);

        // Print areas
        System.out.println("\nCalculating Areas:");
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();

        scanner.close();
    }
}
