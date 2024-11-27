package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] marks = new int[5];

    public External(String usn, String name, String sem, int[] marks) {
        super(usn, name, sem);
        System.arraycopy(marks, 0, this.marks, 0, 5);
    }
}

