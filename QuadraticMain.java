import java.util.Scanner;

class Quadratic {
    int a, b, c;
    double r1, r2, d;

    
    void getd() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the coefficients of a, b, c:");
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
    }

    
    void compute() {
        
        if (a == 0) {
            System.out.println("Not a quadratic equation");
            return;
        }

        
        d = b*b - 4*a*c;

        
        if (d < 0) {
            System.out.println("There are no real solutions.");
        } 
        
        else if (d == 0) {
            r1 = -b / (2.0 * a);
            System.out.println("Roots are real and equal.");
            System.out.println("Root1 = Root2 = " + r1);
        } 
        
        else {
            r1 = (-b + Math.sqrt(d)) / (2.0 * a);
            r2 = (-b - Math.sqrt(d)) / (2.0 * a);
            System.out.println("Roots are real and distinct.");
            System.out.println("Root1 = " + r1 + ", Root2 = " + r2);
        }
    }
}

public class QuadraticMain {
    public static void main(String[] args) {
        Quadratic q = new Quadratic();
        q.getd();  
        q.compute();  
    }
}
