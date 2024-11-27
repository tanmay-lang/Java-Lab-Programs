import SEE.*;
import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        External[] students = new External[n];
        int[] cieMarks = new int[5], seeMarks = new int[5];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            String sem = sc.next();

            System.out.println("Enter CIE marks for 5 courses:");
            for (int j = 0; j < 5; j++) cieMarks[j] = sc.nextInt();

            System.out.println("Enter SEE marks for 5 courses:");
            for (int j = 0; j < 5; j++) seeMarks[j] = sc.nextInt();

            students[i] = new External(usn, name, sem, seeMarks);
            System.arraycopy(cieMarks, 0, students[i].marks, 0, 5);
        }

        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - USN: " + students[i].usn);
            System.out.println("Name: " + students[i].name + ", Semester: " + students[i].sem);
            System.out.print("Final Marks: ");
            for (int j = 0; j < 5; j++) {
                int finalMarks = students[i].marks[j] + (students[i].marks[j] / 2);
                System.out.print(finalMarks + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

