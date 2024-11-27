package CIE;

public class Internals {
    public int[] marks = new int[5];

    public Internals(int[] marks) {
        System.arraycopy(marks, 0, this.marks, 0, 5);
    }
}

