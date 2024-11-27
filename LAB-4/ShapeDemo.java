import java.util.Scanner;

abstract class Shape {
    int dim1, dim2;

    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        System.out.println("Area of Rectangle: " + (dim1 * dim2));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    void printArea() {
        System.out.println("Area of Triangle: " + (0.5 * dim1 * dim2));
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    void printArea() {
        System.out.println("Area of Circle: " + (Math.PI * dim1 * dim1));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length and breadth of the rectangle: ");
        Shape rectangle = new Rectangle(scanner.nextInt(), scanner.nextInt());

        System.out.print("Enter base and height of the triangle: ");
        Shape triangle = new Triangle(scanner.nextInt(), scanner.nextInt());

        System.out.print("Enter radius of the circle: ");
        Shape circle = new Circle(scanner.nextInt());

        rectangle.printArea();
        triangle.printArea();
        circle.printArea();

        scanner.close();
    }
}

