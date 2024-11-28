class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

// Father class
class Father {
    int age;

    public Father(int age) throws WrongAgeException {
        if (age < 0) 
            throw new WrongAgeException("Father's age cannot be negative.");
        this.age = age;
    }
}

// Son class that extends Father
class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); // Call the parent (Father) constructor
        if (sonAge >= fatherAge) 
            throw new WrongAgeException("Son's age cannot be greater than or equal to father's age.");
        this.sonAge = sonAge;
    }
}

// Main class
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("TANMAY - 1BM23ME115");

        try {
            Father father = new Father(40); // Create a Father object
            Son son = new Son(40, 20);      // Create a Son object
            System.out.println("Father's Age: " + father.age + ", Son's Age: " + son.sonAge);
        } catch (WrongAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Son invalidSon = new Son(30, 35); // This will throw an exception
        } catch (WrongAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
