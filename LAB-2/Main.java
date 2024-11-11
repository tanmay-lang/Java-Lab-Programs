import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    Subject subject[];
    String name;
    String usn;
    double SGPA;
    Scanner s;

    
    Student() {
        subject = new Subject[9]; 
        for (int i = 0; i < 9; i++) {
            subject[i] = new Subject(); 
        }
        s = new Scanner(System.in); 
    }

    
    void getStudentDetails() {
        System.out.print("Enter your Name: ");
        name = s.next();
        System.out.print("Enter your USN: ");
        usn = s.next();
    }

    
    void getMarks() {
        for (int i = 0; i < 9; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subject[i].subjectMarks = s.nextInt();
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            subject[i].credits = s.nextInt();

            
            int marks = subject[i].subjectMarks;
            if (marks >= 90) subject[i].grade = 10;
            else if (marks >= 80) subject[i].grade = 9;
            else if (marks >= 70) subject[i].grade = 8;
            else if (marks >= 60) subject[i].grade = 7;
            else if (marks >= 50) subject[i].grade = 6;
            else if (marks >= 40) subject[i].grade = 5;
            else subject[i].grade = 0; 
        }
    }

    
    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;
        for (int i = 0; i < 9; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        SGPA = (double) effectiveScore / totalCredits;
    }
}

public class Main {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.getStudentDetails(); 
        s1.getMarks(); 
        s1.computeSGPA(); 
        System.out.println("Name: " + s1.name);
        System.out.println("USN: " + s1.usn);
        System.out.println("SGPA: " + s1.SGPA); 
	System.out.println("1BM23ME115 - TANMAY");
    }
}
